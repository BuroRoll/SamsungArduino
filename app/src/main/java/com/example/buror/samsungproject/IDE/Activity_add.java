package com.example.buror.samsungproject.IDE;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.buror.samsungproject.R;

public class Activity_add extends AppCompatActivity{
    EditText addName, addCode;
    Button addBtn;
    String nameAdd, codeAdd;

    @Override
    public void onBackPressed() { //вызов бокового меню
        Log.d("BACK", "Pressed");
        Intent intent = new Intent(this, IDEActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();

        try{
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nameAdd = addName.getText().toString();
                    codeAdd = addCode.getText().toString();
                    //CodeHelper ch = new CodeHelper(getApplicationContext()); //создание хелпера для добавления данных
                    //ch.insert(nameAdd, codeAdd); //Добавление данных в БД
                    //Log.d("Add", "add success");
                    //Trance t = new Trance(nameAdd, codeAdd);
                    //Log.d("Data", ch.getAll().toString());
                    Intent intent = new Intent();
                    intent.putExtra("nameAdd", nameAdd);
                    intent.putExtra("codeAdd", codeAdd);
                    setResult(RESULT_OK, intent);
                    finish();
//                    Intent intent = new Intent(Activity_add.this, MainActivity.class);
//                    startActivity(intent);
                }
            });
        }catch (Exception e){
            Log.e("Some Error", e.getMessage());
        }

    }

    private void initView() {
        addName = findViewById(R.id.editName);
        addCode = findViewById(R.id.phon);
        addBtn = findViewById(R.id.addBtn);
    }
}

