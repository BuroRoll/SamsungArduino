package com.example.buror.samsungproject.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.buror.samsungproject.R;

/**
 * Created by buror on 24.01.2018.
 */

public class Book1Activity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.book1);
        textview = findViewById(R.id.list_e_taskdesc);
        textview.setMovementMethod(new ScrollingMovementMethod());
    }

}
