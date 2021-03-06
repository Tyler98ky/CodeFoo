package com.localknowledge.codefoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
//        ab.setLogo(R.mipmap.ic_launcher);

        ab.setElevation(50);

        setWebview();
    }

    protected void setWebview(){
        Intent intent = getIntent();
        String webAddress = intent.getStringExtra("address");

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(false);
        webview.getSettings().setAppCacheEnabled(true);
        webview.setLayerType(View.LAYER_TYPE_HARDWARE, null);


        final Activity activity = this;
        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl(webAddress);
    }
}
