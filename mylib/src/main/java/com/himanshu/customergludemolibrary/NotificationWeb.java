package com.himanshu.customergludemolibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

public class NotificationWeb extends Activity {
    String url ="";

    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_web);
        findViews();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void findViews() {
        webView = findViewById(R.id.web_notification);
        url = getIntent().getStringExtra("nudge_url");
        System.out.println("RET");
        System.out.println(url);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebViewJavaScriptInterface(getApplicationContext(),this), "app"); // **IMPORTANT** call it app
        webView.loadUrl(url);

    }





}
