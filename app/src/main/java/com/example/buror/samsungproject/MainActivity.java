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
import android.widget.TextView;

import com.example.buror.samsungproject.fragments.Book1Activity;
import com.example.buror.samsungproject.fragments.FragmentBook;
import com.example.buror.samsungproject.fragments.FragmentModuls;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentBook fragbook;
    FragmentModuls fragmoduls;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Intent intent = new Intent(MainActivity.this, );
//        startActivity(intent);
        
        fragbook = new FragmentBook();
        fragmoduls = new FragmentModuls();

        welcome = findViewById(R.id.welcome);
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
        } else if (id == R.id.nav_moduls) {
            ftranse.replace(R.id.container, fragmoduls);
            welcome.setText("");

        } else if (id == R.id.nav_control) {

            welcome.setText("");
        } else if (id == R.id.nav_ide) {

            welcome.setText("");
        } else if (id == R.id.nav_int_projects) {

            welcome.setText("");
        } else if (id == R.id.nav_chat) {

            welcome.setText("");
        } else if (id == R.id.nav_share) {

            welcome.setText("");
        } else if (id == R.id.nav_send) {

            welcome.setText("");
        }ftranse.commit();
        //welcome.setText("");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
