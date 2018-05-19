package com.example.buror.samsungproject.fragments;

import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.buror.samsungproject.R;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by buror on 27.01.2018.
 */

public class FragmentControl extends Fragment {
    public FragmentControl() {}

    Button btnOn;
    EditText sendData;


    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;

    // SPP UUID сервиса
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    // MAC-адрес Bluetooth модуля(меняется)
    static String address = "98:D3:32:31:58:6C";

    final ArrayList<String> history = new ArrayList<>();
    View view;

    public static void setAddress(String addres){
        address = addres;
        Log.d("setAddress", "setAddress: Seted" + addres);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.control_frag, container, false);
        ListView listView = view.findViewById(R.id.listView);
        btnOn = view.findViewById(R.id.btnOn);
        sendData = view.findViewById(R.id.editText);
        //Button btn = view.findViewById(R.id.btn);
        btnOn.setEnabled(false);
        //btnOn.setEnabled(true);

        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                btAdapter = BluetoothAdapter.getDefaultAdapter();
                checkBTState();
            }
        });
        myThready.start();

        btnOn.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnOn.setEnabled(true);
            }
        }, 7000);

        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, history);
        listView.setAdapter(adapter);

        try{
            btnOn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (sendData.getText().length() != 0) { //sendData != null
                        String data = sendData.getText().toString();
                        sendData(data);
                        history.add(data);
                        adapter.notifyDataSetChanged();
                        sendData.setText("");
                    }
                }
            });
        }catch(Exception e){
            Log.d("btn click", e.getMessage());
        }


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//
//                LayoutInflater inflater = null;
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//                    inflater = getLayoutInflater();
//                }
//                View dialogView = inflater.inflate(R.layout.alertdialog_custom_view, null);
//                //Установка кастомной разметки
//                builder.setView(dialogView);
//
//                Button btn_positive = dialogView.findViewById(R.id.dialog_positive_btn);
//                Button btn_negative = dialogView.findViewById(R.id.dialog_negative_btn);
//                final EditText et_name = dialogView.findViewById(R.id.et_name);
//
//                //Создание диалогового окна
//                final AlertDialog dialog = builder.create();
//btn.setEnabled(true);
//
//                btn_positive.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.cancel();
//                        address = et_name.getText().toString();
//                        Log.d("Change MAC", String.valueOf(address));
//                    }
//                });
//
//
//                btn_negative.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
//            }
//        });
        return view;
    }

    private void checkBTState() {
        //Для включения СинегоЗуба
        if (btAdapter == null) {
            Log.d("Error", String.valueOf(btAdapter));
        } else {
            if (btAdapter.isEnabled()) {
                Log.d("ВКЛ BlueTooth", "Bluetooth включен");
            } else {
                //Включаем СинийЗуб
                Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Thread myThready = new Thread(new Runnable() {
            public void run()
            {
                if (outStream != null) {
                    try {
                        outStream.flush();
                    } catch (IOException e) {
                        Log.d("Error", e.getMessage());
                    }
                }
                try{
                    btSocket.close();
                } catch (IOException e2) {
                    Log.d("Error", e2.getMessage());
                }
            }
        });
        myThready.start();

    }

    @Override
    public void onResume() {
        super.onResume();

        Thread myThready = new Thread(new Runnable() {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                //Настройка соеинения по адрессу
                BluetoothDevice device = btAdapter.getRemoteDevice(address);

                try {
                    btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
                } catch (IOException e) {}
                btAdapter.cancelDiscovery();


                Log.d("Connect", "Соединяемся");
                try {
                    btSocket.connect();
                    Log.d("Connect", "Соединение установлено");
                } catch (IOException e) {
                    try {
                        btSocket.close();
                    } catch (IOException e2) {
                        Log.d("Error", e.getMessage());
                    }
                }

                try {
                    outStream = btSocket.getOutputStream();
                } catch (IOException e) {
                    Log.d("error", e.getMessage());
                }
//                btn.setEnabled(true);
            }
        });
        myThready.start();
    }

    private void sendData(String message) {
        byte[] msgBuffer = message.getBytes();

        Log.d("Send", "Посылаем данные: " + message);

        try {
            outStream.write(msgBuffer);
        } catch (IOException e) {

        }
    }
}