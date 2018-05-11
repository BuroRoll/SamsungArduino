package com.example.buror.samsungproject.IDE;

import android.content.Intent;
import android.os.Bundle;
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

public class Activity_add extends AppCompatActivity{
    EditText addName, addCode;
    String nameAdd, codeAdd;

    @Override
    public void onBackPressed() {
        Log.d("BACK", "Pressed");
        Intent intent = new Intent();
        intent.putExtra("exitAdd", "1");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();
        switch (id) {
            case R.id.save_add:
                try{
                    nameAdd = addName.getText().toString();
                    codeAdd = addCode.getText().toString();
                    Intent intent = new Intent();
                    intent.putExtra("nameAdd", nameAdd);
                    intent.putExtra("codeAdd", codeAdd);
                    setResult(RESULT_OK, intent);
                    finish();
                }catch (Exception e){
                    Log.e("Some Error", e.getMessage());
                }
                return true;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_ide, menu);
        return true;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
    }

    private void initView() {
        addName = findViewById(R.id.editName);
        addCode = findViewById(R.id.phon);
    }
}