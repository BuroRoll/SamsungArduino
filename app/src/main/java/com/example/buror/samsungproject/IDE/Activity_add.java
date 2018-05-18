package com.example.buror.samsungproject.IDE;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.example.buror.samsungproject.R;


import java.util.HashMap;
import java.util.Map;

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

        final Map<String,Integer> map = new HashMap<>();
        map.put("void", Color.BLUE);
        map.put("#define", Color.GREEN);
        map.put("const", Color.BLUE);
        map.put("Serial", R.color.green);
        map.put("setup(",R.color.green);
        map.put("loop(",R.color.green);
        map.put("pinMode",R.color.orange);
        map.put("delay",R.color.orange);
        map.put("digitalWrite",R.color.orange);
        map.put("LOW",Color.BLUE);
        map.put("HIGH",Color.BLUE);



        addCode.addTextChangedListener(new TextWatcher() {
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
    }

    private void initView() {
        addName = findViewById(R.id.editName);
        addCode = findViewById(R.id.phon);
    }
}