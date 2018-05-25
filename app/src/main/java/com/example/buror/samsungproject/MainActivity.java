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
import com.example.buror.samsungproject.Items_list.Item0Activity;
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
    IDEActivity fide;
    String te;
    BluetoothAdapter bluetooth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bluetooth = BluetoothAdapter.getDefaultAdapter();

        if (bluetooth.isEnabled()) {}
        else
        {
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
        fide = new IDEActivity();

        FragmentTransaction ftranse = getFragmentManager().beginTransaction();
        ftranse.replace(R.id.container, fragbook);
        ftranse.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent setting = new Intent(getApplicationContext(), Bluetooth_connect.class);
            startActivity(setting);
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


        int id = item.getItemId();


        FragmentTransaction ftranse = getFragmentManager().beginTransaction();

        if (id == R.id.nav_book) {
            ftranse.replace(R.id.container, fragbook);
        } else if (id == R.id.nav_moduls) {
            ftranse.replace(R.id.container, fragmoduls);
        } else if (id == R.id.nav_control) {
            if (bluetooth.isEnabled()) {}
            else{
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
            while(true){
                try{
                    ftranse.replace(R.id.container, fcontrol);
                    break;
                }catch (Exception e){
                    Log.d("Start Control", "onNavigationItemSelected: " + e.getMessage());
                }
            }


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

        while(true){
            try{
                ftranse.commit();
                break;
            }catch (Exception e){
                Log.d("Commit Error", "onNavigationItemSelected: " + e.getMessage());
            }
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
