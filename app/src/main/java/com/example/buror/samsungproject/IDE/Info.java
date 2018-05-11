package com.example.buror.samsungproject.IDE;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.buror.samsungproject.R;
import com.r0adkll.slidr.Slidr;

public class Info extends AppCompatActivity{
    EditText editName, editCode;
    Code code;

    @Override
    public void onBackPressed() {
        Log.d("BACK", "Pressed");
        Intent intent = new Intent();
        intent.putExtra("exitInfo", "1");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info_ide, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();
        switch (id) {
            case R.id.save_info:
                try{
                    CodeHelper ch = new CodeHelper(getApplicationContext());
                    code.setName(editName.getText().toString()); //передача данных из полей  EditText
                    code.setCode(editCode.getText().toString());
                    ch.update(code); //Упгрэйд
                    Intent intent = new Intent();
                    intent.putExtra("change",1);
                    setResult(RESULT_OK, intent);
                    finish();
                }catch (Exception e){
                    Log.d("My Exception EDIT", e.getMessage());
                }
                return true;
            case R.id.delite_info:
                try{
                    Intent intent = new Intent();
                    intent.putExtra("id", code.getId());
                    setResult(RESULT_OK, intent);
                    finish();
                }catch (Exception e){
                    Log.d("My Exception DELITE", e.getMessage());
                }
                return true;
        }

        return true;
    }


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();

        code = getIntent().getParcelableExtra("codeSend");
        Log.d("ПРИНЯЛ", String.valueOf(code));
        editName.setText(code.getName());
        editCode.setText(code.getCode());
    }

    void initView() {
        editName = findViewById(R.id.editName);
        editCode = findViewById(R.id.editCode);
    }
}