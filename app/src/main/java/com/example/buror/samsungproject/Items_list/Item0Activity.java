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
                TextView i0 = findViewById(R.id.buyUno);
                i0.setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case "first":
                setContentView(R.layout.item1);
                Slidr.attach(this);
                TextView i1 = findViewById(R.id.buyNano);
                i1.setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case "second":
                setContentView(R.layout.item2);
                Slidr.attach(this);
                TextView i2 = findViewById(R.id.buyMega);
                i2.setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case "three":
                setContentView(R.layout.item3);
                Slidr.attach(this);
                TextView i3 = findViewById(R.id.buyDHT11);
                TextView i33 = findViewById(R.id.buyDHT22);
                TextView i333 = findViewById(R.id.downloadLibForDHT);
                i3.setMovementMethod(LinkMovementMethod.getInstance());
                i33.setMovementMethod(LinkMovementMethod.getInstance());
                i333.setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case "four":
                setContentView(R.layout.item4);
                Slidr.attach(this);
                TextView i4 = findViewById(R.id.buyRele);
                i4.setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case "five":
                setContentView(R.layout.item5);
                Slidr.attach(this);
                TextView i5 = findViewById(R.id.buyLCD);
                TextView i55 =findViewById(R.id.downloadLibForLCD);
                i5.setMovementMethod(LinkMovementMethod.getInstance());
                i55.setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case "six":
                setContentView(R.layout.item6);
                Slidr.attach(this);
                TextView i6 = findViewById(R.id.buyBluetooth);
                i6.setMovementMethod(LinkMovementMethod.getInstance());
                break;
        }
    }
}
