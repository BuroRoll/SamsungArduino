package com.example.buror.samsungproject;

import android.app.FragmentTransaction;
import android.bluetooth.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.buror.samsungproject.Chat.ChatActivity;
import com.example.buror.samsungproject.FeedBack.FeedBack;
import com.example.buror.samsungproject.IDE.IDEActivity;
import com.example.buror.samsungproject.Projects.Fragment1;
import com.example.buror.samsungproject.fragments.FragmentBook;
import com.example.buror.samsungproject.fragments.FragmentChat;
import com.example.buror.samsungproject.fragments.FragmentControl;
import com.example.buror.samsungproject.fragments.FragmentModuls;

import me.aflak.bluetooth.Bluetooth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentBook fragbook;
    FragmentModuls fragmoduls;
    FragmentChat fragchat;
    FragmentControl fcontrol;
    Fragment1 fragment1;
    String te;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        Bluetooth bluetooth = new Bluetooth(this);
//        Log.d("Blurtooth", "onCreate: "+ String.valueOf(bluetooth));
////        Log.d("Blurtooth", "onCreate: "+ String.valueOf());
//            bluetooth.enable();
////            if(bluetooth.isEnabled()){
//                Log.d("Bluetooth", "onCreate: БЛЮТУЗ ВКЛЮЧЕН");
//  //          }else{
//                Log.d("Bluetooth", "onCreate: НЕ ВКЛЮЧИЛСЯ");
//    //        }
        BluetoothAdapter bluetooth= BluetoothAdapter.getDefaultAdapter();

        if (bluetooth.isEnabled()) {
            // Bluetooth включен. Работаем.
        }
        else
        {
            // Bluetooth выключен. Предложим пользователю включить его.
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);
        }


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragchat = new FragmentChat();
        fragbook = new FragmentBook();
        fragmoduls = new FragmentModuls();
        fcontrol = new FragmentControl();
        fragment1 = new Fragment1();

        FragmentTransaction ftranse = getFragmentManager().beginTransaction();
        ftranse.replace(R.id.container, fragbook);
        ftranse.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        te = "hi";
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();


        FragmentTransaction ftranse = getFragmentManager().beginTransaction();

        if (id == R.id.nav_book) {
            ftranse.replace(R.id.container, fragbook);
        } else if (id == R.id.nav_moduls) {
            ftranse.replace(R.id.container, fragmoduls);
        } else if (id == R.id.nav_control) {
//            BluetoothAdapter bluetooth= BluetoothAdapter.getDefaultAdapter();
//            if (bluetooth.isEnabled()) {
//                // Bluetooth включен. Работаем.
//            }
//            else
//            {
//                // Bluetooth выключен. Предложим пользователю включить его.
////                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
////                startActivityForResult(enableBtIntent, 1);
//                BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
//                btAdapter.enable();
//            }

            ftranse.replace(R.id.container, fcontrol);
        } else if (id == R.id.nav_ide) {
            Intent intent = new Intent(this, IDEActivity.class);
            startActivityForResult(intent, 1);
        } else if (id == R.id.nav_int_projects) {
            ftranse.replace(R.id.container, fragment1);
        } else if (id == R.id.nav_chat) {
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(this, FeedBack.class);
            startActivity(intent);
        }
        ftranse.commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
