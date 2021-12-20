package com.himanshu.customergludemolibrary;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.himanshu.customergludemolibrary.Interface.RewardInterface;
import com.himanshu.customergludemolibrary.Modal.EventData;
import com.himanshu.customergludemolibrary.Modal.RewardModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class OpenCustomerGluWeb extends AppCompatActivity {

    String customer_token="";
    String type="";
    WebViewJavaScriptInterface webViewJavaScriptInterface;
    public static boolean exit = false;


    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        findViews();
        getRewardsData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        exit = false;
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();
        }

    }


    private void getRewardsData() {

        customer_token = getIntent().getStringExtra("customer_token");
        type = getIntent().getStringExtra("type");

        CustomerGlu.retrieveDataByType(getApplicationContext(), customer_token,type ,new RewardInterface() {
            @Override
            public void onSuccess(RewardModel rewardModel) {

                if(type.equalsIgnoreCase("")) {
                    String default_url = rewardModel.defaultUrl;
                    //   Toast.makeText(MainActivity.this, rewardModel.defaultUrl, Toast.LENGTH_SHORT).show();
                    web.loadUrl(default_url);
                } else if (rewardModel.getCampaigns().size()==0) {

                    Toast.makeText(OpenCustomerGluWeb.this, "Invalid Campaign Type", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    String url = rewardModel.getCampaigns().get(0).getUrl();

                    web.loadUrl(url);
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void findViews() {
        web = findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.addJavascriptInterface(new WebViewJavaScriptInterface(getApplicationContext(),this), "app"); // **IMPORTANT** call it app

    }

    @Override
    protected void onStart() {
        super.onStart();
    //    EventBus.getDefault().register(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
      //  EventBus.getDefault().unregister(this);
    }

/*    @SuppressLint("SetJavaScriptEnabled")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventData event){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.detail_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        dialog.show();

        WebView webView = dialog.findViewById(R.id.notification_web);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(event.getNudge_url());


    }*/


}
