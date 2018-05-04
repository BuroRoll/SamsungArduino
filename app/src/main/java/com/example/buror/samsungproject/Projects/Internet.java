package com.example.buror.samsungproject.Projects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.buror.samsungproject.R;

public class Internet extends AppCompatActivity {
    private WebView mWebView;
    String url;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet);
        Log.d("GOGOGOGOOG", "GOOGOGOG");
        try{
            mWebView = (WebView) findViewById(R.id.webView);
            mWebView.getSettings().setLoadWithOverviewMode(true);
            mWebView.getSettings().setUseWideViewPort(true);
            Intent intent = getIntent();
            url = intent.getStringExtra("link");
            Log.d("Link", url);
            mWebView.loadUrl(url);
            mWebView.setWebViewClient(new MyWebViewClient());
        }catch (Exception e){
            Log.d("ERRORRRRR", e.getMessage());
        }

    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }
}

