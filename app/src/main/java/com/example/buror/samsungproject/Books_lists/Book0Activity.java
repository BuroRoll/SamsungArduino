package com.example.buror.samsungproject.Books_lists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.buror.samsungproject.R;
import com.r0adkll.slidr.Slidr;

/**
 * Created by buror on 24.01.2018.
 */

public class Book0Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String key =  getIntent().getStringExtra("key");
        switch(key){
            case "zero":
                setContentView(R.layout.book0);
                Slidr.attach(this);
                break;
            case "one":
                setContentView(R.layout.book1);
                Slidr.attach(this);
                break;
            case "two":
                setContentView(R.layout.book2);
                Slidr.attach(this);
                break;
            case "three":
                setContentView(R.layout.book3);
                Slidr.attach(this);
                break;
            case "four":
                setContentView(R.layout.book4);
                Slidr.attach(this);
                break;
            case "five":
                setContentView(R.layout.book5);
                Slidr.attach(this);
                break;
            case "six":
                setContentView(R.layout.book6);
                Slidr.attach(this);
                break;
            case "seven":
                setContentView(R.layout.book7);
//                TextView t2 =findViewById(R.id.textlink);
//                t2.setMovementMethod(LinkMovementMethod.getInstance());
                Slidr.attach(this);
                break;
            case "eight":
                setContentView(R.layout.book8);
                Slidr.attach(this);
                break;
            case "nine":
                setContentView(R.layout.book9);
                Slidr.attach(this);
                break;
            case "ten":
                setContentView(R.layout.book10);
                Slidr.attach(this);
                TextView t2 = findViewById(R.id.text5);
                t2.setMovementMethod(LinkMovementMethod.getInstance());
                break;
        }

    }

}