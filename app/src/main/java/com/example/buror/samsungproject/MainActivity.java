package com.example.buror.samsungproject;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buror.samsungproject.Chat.ChatActivity;
import com.example.buror.samsungproject.fragments.Book1Activity;
import com.example.buror.samsungproject.fragments.FragmentBook;
import com.example.buror.samsungproject.fragments.FragmentChat;
import com.example.buror.samsungproject.fragments.FragmentControl;
import com.example.buror.samsungproject.fragments.FragmentModuls;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentBook fragbook;
    FragmentModuls fragmoduls;
    FragmentChat fragchat;
    FragmentControl fcontrol;


    ImageView cats;
    ImageView lcdWelcome;
    TextView welcome;
    public Intent chatt;

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

//        Intent intent = new Intent(MainActivity.this, );
//        startActivity(intent);
        fragchat = new FragmentChat();
        fragbook = new FragmentBook();
        fragmoduls = new FragmentModuls();
        fcontrol = new FragmentControl();

        welcome = findViewById(R.id.welcome);
        cats = findViewById(R.id.cats);
        lcdWelcome =findViewById(R.id.lcdWelcome);
        //welcome = new TextView(this);

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        FragmentTransaction ftranse = getFragmentManager().beginTransaction();

        if (id == R.id.nav_book) {
            ftranse.replace(R.id.container, fragbook);
            welcome.setText("");
            cats.setVisibility(View.GONE);
            lcdWelcome.setVisibility(View.GONE);
        } else if (id == R.id.nav_moduls) {
            ftranse.replace(R.id.container, fragmoduls);
            welcome.setText("");
            cats.setVisibility(View.GONE);
            lcdWelcome.setVisibility(View.GONE);
        } else if (id == R.id.nav_control) {
            ftranse.replace(R.id.container, fcontrol);

            welcome.setText("");
            cats.setVisibility(View.GONE);
            lcdWelcome.setVisibility(View.GONE);
        } else if (id == R.id.nav_ide) {

            welcome.setText("");
            cats.setVisibility(View.GONE);
            lcdWelcome.setVisibility(View.GONE);
        } else if (id == R.id.nav_int_projects) {

            welcome.setText("");
            cats.setVisibility(View.GONE);
            lcdWelcome.setVisibility(View.GONE);
        } else if (id == R.id.nav_chat) {
            ftranse.replace(R.id.container, fragchat);
            welcome.setText("");
            cats.setVisibility(View.GONE);
            lcdWelcome.setVisibility(View.GONE);
//            chatt = new Intent(MainActivity.this, ChatActivity.class);
        } else if (id == R.id.nav_share) {

            welcome.setText("");
            cats.setVisibility(View.GONE);
            lcdWelcome.setVisibility(View.GONE);
        } else if (id == R.id.nav_send) {

            welcome.setText("");
            cats.setVisibility(View.GONE);
            lcdWelcome.setVisibility(View.GONE);
        }
//        if(chatt != null){
//            startActivity(chatt);
//        }else{
//        }
        ftranse.commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
