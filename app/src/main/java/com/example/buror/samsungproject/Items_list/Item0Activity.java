package com.example.buror.samsungproject.Items_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.buror.samsungproject.R;

/**
 * Created by BuroRoll on 28.03.2018.
 */
public class Item0Activity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.book0);
        textview = findViewById(R.id.list_e_taskdesc);
        textview.setMovementMethod(new ScrollingMovementMethod());
    }
}
