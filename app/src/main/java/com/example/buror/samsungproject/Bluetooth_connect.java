package com.example.buror.samsungproject;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.buror.samsungproject.fragments.FragmentControl;
import java.util.ArrayList;
import java.util.Set;

public class Bluetooth_connect extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    Button btn;
    private ListView listView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayList<String> mDeviceName = new ArrayList<>();
    private ArrayList<String> mDeviceAdress = new ArrayList<>();
    Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_connect);
        btn = findViewById(R.id.button2);
        listView = findViewById(R.id.list);
//        tb = findViewById(R.id.toolbar);
//        tb.setTitle("Arduino Tutorial");
//        setSupportActionBar(tb);

        mSwipeRefreshLayout = findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);


        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentControl.setAddress(mDeviceAdress.get(position));
                onBackPressed();
            }
        });


    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        if (mBluetoothAdapter.isEnabled()) {}
        else{
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);
        }

        for(BluetoothDevice bt : pairedDevices){
            mDeviceName.clear();
            mDeviceAdress.clear();
            mDeviceName.add(bt.getName());
            mDeviceAdress.add(bt.getAddress());
            Log.d("TAG", "onCreate: " + bt.getName());
            Log.d("TAG", "onCreate: " + bt.getAddress());
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, mDeviceName);
            listView.setAdapter(adapter);
        }
    }
}
