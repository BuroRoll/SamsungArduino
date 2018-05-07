package com.example.buror.samsungproject.IDE;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.buror.samsungproject.MainActivity;
import com.example.buror.samsungproject.R;
import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;

public class IDEActivity extends AppCompatActivity {
    RecyclerView rv;
    Code code;


    @Override
    public void onBackPressed() { //вызов бокового меню
        Log.d("BACK", "Pressed");
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        Intent intent = new Intent();
        intent.putExtra("Hi", 1);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ide);
        final CodeHelper cHelp = new CodeHelper(getApplicationContext());
        final int key = 1;



        rv = findViewById(R.id.recycler_view11);
        rv.setLayoutManager(new LinearLayoutManager(this)); // устанавливаем разметку для списка.
        rv.setItemAnimator(new DefaultItemAnimator()); //устанавливаем класс, отвечающий за анимации в списке
        rv.setAdapter(new RVAdapter(cHelp.getAll(), this)); //устанавливаем наш адаптер




        FloatingActionButton fab = findViewById(R.id.fab);  //кнопка
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_add.class);
                //startActivity(intent);
                startActivityForResult(intent, key);
            }
        });
        Slidr.attach(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) { //если Add
            if(data.hasExtra("nameAdd")){
                CodeHelper ch = new CodeHelper(getApplicationContext()); //создание хелпера для добавления данных
                ch.insert(data.getStringExtra("nameAdd"), data.getStringExtra("codeAdd")); //Добавление данных в БД
                rv.setLayoutManager(new LinearLayoutManager(this)); // устанавливаем разметку для списка.
                rv.setItemAnimator(new DefaultItemAnimator()); //устанавливаем класс, отвечающий за анимации в списке
                rv.setAdapter(new RVAdapter(ch.getAll(), this));

                Log.d("Add", String.valueOf(data.getStringExtra("nameAdd")));//то, что положили в интент
                Log.d("Add", String.valueOf(data.getStringExtra("codeAdd")));
                //Log.d("TEST", String.valueOf(getIntent().hasExtra("")));
                Log.d("requestCode", String.valueOf(requestCode));              //key
            }
            if(data.hasExtra("exitAdd")){
                CodeHelper ch = new CodeHelper(getApplicationContext());
                rv.setLayoutManager(new LinearLayoutManager(this)); // устанавливаем разметку для списка.
                rv.setItemAnimator(new DefaultItemAnimator()); //устанавливаем класс, отвечающий за анимации в списке
                rv.setAdapter(new RVAdapter(ch.getAll(), this));
            }

        }
        if(requestCode == 2){//if delite
            if(data.hasExtra("id")){
                CodeHelper ch = new CodeHelper(getApplicationContext());
                ch.delete((Long) data.getSerializableExtra("id"));
                rv.setLayoutManager(new LinearLayoutManager(this)); // устанавливаем разметку для списка.
                rv.setItemAnimator(new DefaultItemAnimator()); //устанавливаем класс, отвечающий за анимации в списке
                rv.setAdapter(new RVAdapter(ch.getAll(), this));
                Log.d("DELITE", String.valueOf(data.hasExtra("id")));//то, что положили в интент
                Log.d("DELITasdE", String.valueOf(data.getSerializableExtra("id")));//то, что положили в интент
                Log.d("DELITE2", String.valueOf(requestCode));
            }
            if(data.hasExtra("change")){
                CodeHelper ch = new CodeHelper(getApplicationContext());
                rv.setLayoutManager(new LinearLayoutManager(this)); // устанавливаем разметку для списка.
                rv.setItemAnimator(new DefaultItemAnimator()); //устанавливаем класс, отвечающий за анимации в списке
                rv.setAdapter(new RVAdapter(ch.getAll(), this));
            }
            if(data.hasExtra("exitInfo")){
                CodeHelper ch = new CodeHelper(getApplicationContext());
                rv.setLayoutManager(new LinearLayoutManager(this)); // устанавливаем разметку для списка.
                rv.setItemAnimator(new DefaultItemAnimator()); //устанавливаем класс, отвечающий за анимации в списке
                rv.setAdapter(new RVAdapter(ch.getAll(), this));
            }

        }

    }

}