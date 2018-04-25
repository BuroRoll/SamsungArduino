package com.example.buror.samsungproject;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.example.buror.samsungproject.Chat.ChatActivity;
import com.example.buror.samsungproject.IDE.IDEActivity;
import com.example.buror.samsungproject.fragments.FragmentBook;
import com.example.buror.samsungproject.fragments.FragmentChat;
import com.example.buror.samsungproject.fragments.FragmentControl;
import com.example.buror.samsungproject.fragments.FragmentModuls;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentBook fragbook;
    FragmentModuls fragmoduls;
    FragmentChat fragchat;
    FragmentControl fcontrol;
    String te;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);      //activity_main
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragchat = new FragmentChat();
        fragbook = new FragmentBook();
        fragmoduls = new FragmentModuls();
        fcontrol = new FragmentControl();

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
            ftranse.replace(R.id.container, fcontrol);
        } else if (id == R.id.nav_ide) {
            Intent intent = new Intent(this, IDEActivity.class);
            startActivityForResult(intent, 1);

        } else if (id == R.id.nav_int_projects) {


        } else if (id == R.id.nav_chat) {
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {


        } else if (id == R.id.nav_send) {


        }
        ftranse.commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
