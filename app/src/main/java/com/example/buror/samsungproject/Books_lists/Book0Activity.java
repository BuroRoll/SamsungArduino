package com.example.buror.samsungproject.Books_lists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.buror.samsungproject.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.r0adkll.slidr.Slidr;



public class Book0Activity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String key =  getIntent().getStringExtra("key");
        switch(key){
            case "zero":
                setContentView(R.layout.book0);
                Slidr.attach(this);
                MobileAds.initialize(this,
                        "ca-app-pub-2406878860777073/2323998984");

                mAdView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
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