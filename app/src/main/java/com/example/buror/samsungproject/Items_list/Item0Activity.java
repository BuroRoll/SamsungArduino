package com.example.buror.samsungproject.Items_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.buror.samsungproject.R;
import com.r0adkll.slidr.Slidr;



public class Item0Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String key =  getIntent().getStringExtra("key");
        switch(key){
            case "zero":
                setContentView(R.layout.item0);
                Slidr.attach(this);
                TextView t2 = findViewById(R.id.buyUno);
                t2.setMovementMethod(LinkMovementMethod.getInstance());
                break;
        }
    }
}
