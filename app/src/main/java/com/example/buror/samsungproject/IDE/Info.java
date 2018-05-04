package com.example.buror.samsungproject.IDE;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.buror.samsungproject.R;

public class Info extends AppCompatActivity{
    Button delite, change;
    EditText editName, editCode;
    Code code;

    @Override
    public void onBackPressed() {
        Log.d("BACK", "Pressed");
        Intent intent = new Intent();
        intent.putExtra("exitInfo", "1");
        setResult(RESULT_OK, intent);
        finish();
//        Intent intent = new Intent(this, IDEActivity.class);
//        startActivity(intent);
    }


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();

        code = getIntent().getParcelableExtra("codeSend");
        Log.d("ПРИНЯЛ", String.valueOf(code));
        editName.setText(code.getName());
        editCode.setText(code.getCode());

        delite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CodeHelper ch = new CodeHelper(getApplicationContext());
                //ch.delete(code.getId());
                //Intent intent = new Intent(Info.this, MainActivity.class);
                //startActivity(intent);
                try{
                    Intent intent = new Intent();
                    intent.putExtra("id", code.getId());
                    setResult(RESULT_OK, intent);
                    finish();
                }catch (Exception e){
                    Log.d("My Exception DELITE", e.getMessage());
                }
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    CodeHelper ch = new CodeHelper(getApplicationContext());
                    code.setName(editName.getText().toString()); //передача данных из полей  EditText
                    code.setCode(editCode.getText().toString());
                    ch.update(code); //Упгрэйд
                    Intent intent = new Intent();
                    intent.putExtra("change",1);
//                    intent.putExtra("name", editName.getText().toString());
//                    intent.putExtra("codeEdit", editCode.getText().toString());
//                    intent.putExtra("idUpdate", code.getId());
                    setResult(RESULT_OK, intent);
                    finish();
                }catch (Exception e){
                    Log.d("My Exception EDIT", e.getMessage());
                }
            }
        });

    }

    void initView() {
        delite = findViewById(R.id.delite_btn);
        change = findViewById(R.id.change);
        editName = findViewById(R.id.editName);
        editCode = findViewById(R.id.editCode);
    }
}
