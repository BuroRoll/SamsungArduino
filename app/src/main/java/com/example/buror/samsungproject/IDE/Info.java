package com.example.buror.samsungproject.IDE;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.buror.samsungproject.R;
import com.r0adkll.slidr.Slidr;

import java.util.HashMap;
import java.util.Map;

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
                    ch.update(code);
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


        final Map<String,Integer> map = new HashMap<>();
        map.put("void", Color.BLUE);
        map.put("#define", Color.GREEN);
        map.put("const", Color.BLUE);
        map.put("Serial", R.color.green);
        map.put("setup(",R.color.green);
        map.put("setup",R.color.green);
        map.put("loop(",R.color.green);
        map.put("pinMode",R.color.orange);
        map.put("delay",R.color.orange);
        map.put("digitalWrite",R.color.orange);
        map.put("LOW",Color.BLUE);
        map.put("HIGH",Color.BLUE);
        editCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String string = editable.toString();
                String[] split = string.split("\\s");

                int startIndex = 0;
                for(int i = 0 ; i < split.length ; i++){
                    String s = split[i];
                    if(map.containsKey(s)){

                        int index = string.indexOf(s, startIndex);
                        int color = map.get(s);
                        editable.setSpan(new ForegroundColorSpan(color),
                                index,
                                index + s.length(),
                                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        startIndex = index + s.length();
                    }

                }
            }
        });

        editCode.setText(code.getCode());
    }

    void initView() {
        editName = findViewById(R.id.editName);
        editCode = findViewById(R.id.editCode);
    }
}