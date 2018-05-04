package com.example.buror.samsungproject.Books_lists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buror.samsungproject.R;

/**
 * Created by buror on 24.01.2018.
 */

public class Book0Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.book0);
        ImageView Om = findViewById(R.id.om);
        Om.setImageResource(R.drawable.om2);
    }

}