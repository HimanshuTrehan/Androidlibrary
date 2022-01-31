package com.himanshu.customergludemolibrary;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MiddleDialog extends Activity {
    String url ="";
    double opacity = 0.5,backgroundOpcatity = 0.5;
    RelativeLayout main;
    ProgressBar pg;
    CardView card;
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.middle_dialog);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                Log.e("CustomerGlu", "Uncaught Exception" + Arrays.toString(e.getCause().getStackTrace()));
                String s = "Uncaught Exception" +e.getCause() +Arrays.toString(e.getCause().getStackTrace());

              //  CustomerGlu.getInstance().sendCrashAnalytics(getApplicationContext(),s);
            }
        });
        findViews();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buzzer);
//        mediaPlayer.start();
//    }

    @SuppressLint("SetJavaScriptEnabled")
    private void findViews() {
        webView = findViewById(R.id.web_notification);
        pg = findViewById(R.id.pg);
        card = findViewById(R.id.card);
        String  color;
        color = Prefs.getKey(getApplicationContext(),"Loadercolor");
        if (color.isEmpty())
        {
            color = "#FF000000";
        }
        pg.getIndeterminateDrawable().setColorFilter(Color.parseColor(color), PorterDuff.Mode.MULTIPLY);

        main = findViewById(R.id.main);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        url = getIntent().getStringExtra("nudge_url");
        String view_opacity = getIntent().getStringExtra("opacity");
            opacity = Double.parseDouble(view_opacity);
            backgroundOpcatity = 255*opacity;


        main.getBackground().setAlpha((int) backgroundOpcatity);

        System.out.println("RET");
        System.out.println(url);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        double height = (displaymetrics.heightPixels) / 1.4;
       double width = displaymetrics.widthPixels;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(new RelativeLayout.LayoutParams((int)width, (int) height));
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        layoutParams.leftMargin = 20;
        layoutParams.rightMargin = 20;


        card.setLayoutParams(layoutParams);
        webView.setWebViewClient(new WebViewClient()
        {

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {

                String url = request.getUrl().toString();
                System.out.println("Interceptor url");
                System.out.println(url);
                String [] split = url.split("/");
                int size = split.length;
                String req = "/"+split[size-1];
                System.out.println(req);
                ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
                File zip = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
                File file = new File(zip,"CustomerGlu");
                String asset_path = file.getPath()+"/build/";
                if (url.contains("/wallet"))
                {
                    Log.e("CustomerGlu","index.html");

                    File asset_file = new File(asset_path+"/wallet/index.html");
                    try {
                        InputStream is = new FileInputStream(asset_file);
                        return new WebResourceResponse("text/html", "UTF-8",is);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (url.contains("/program-nudge"))
                {

                    File asset_file = new File(asset_path+"/program-nudge/index.html");
                    try {
                        InputStream is = new FileInputStream(asset_file);
                        return new WebResourceResponse("text/html", "UTF-8",is);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (url.contains("/program/?token"))
                {

                    File asset_file = new File(asset_path+"/program/index.html");
                    try {
                        InputStream is = new FileInputStream(asset_file);
                        return new WebResourceResponse("text/html", "UTF-8",is);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (url.contains("/embedded"))
                {

                    File asset_file = new File(asset_path+"/embedded/index.html");
                    try {
                        InputStream is = new FileInputStream(asset_file);
                        return new WebResourceResponse("text/html", "UTF-8",is);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (url.contains("/reward/?token"))
                {
                    Log.e("CustomerGlu","index.html");

                    File asset_file = new File(asset_path+"/reward/index.html");
                    try {
                        InputStream is = new FileInputStream(asset_file);
                        return new WebResourceResponse("text/html", "UTF-8",is);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(req.contains(".js"))
                {
                    try {
                        //   System.out.println("Start "+counter+"ms");

                        File asset_file = new File(req);

                        InputStream is = new FileInputStream(asset_path+asset_file);
                        System.out.println("cache hit");

                        //   System.out.println("End "+counter+"ms");

                        return new WebResourceResponse("text/javascript", "UTF-8",is);

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("cache miss");

                    }
                }
                if(req.contains(".woff2"))
                {
                    try {
                        //   System.out.println("Start "+counter+"ms");

                        File asset_file = new File(req);

                        InputStream is = new FileInputStream(asset_path+"/fonts"+asset_file);
                        System.out.println("cache hit");

                        //   System.out.println("End "+counter+"ms");

                        return new WebResourceResponse("font/woff2", "UTF-8",is);

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("cache miss");

                    }
                }
                if(req.contains(".woff"))
                {
                    try {
                        //   System.out.println("Start "+counter+"ms");

                        File asset_file = new File(req);

                        InputStream is = new FileInputStream(asset_path+"/fonts"+asset_file);
                        System.out.println("cache hit");

                        //   System.out.println("End "+counter+"ms");

                        return new WebResourceResponse("font/woff", "UTF-8",is);

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("cache miss");

                    }
                }
                if(req.contains(".css"))
                {
                    try {

                        File asset_file = new File(asset_path+req);

                        InputStream is = new FileInputStream(asset_file);

                        //    System.out.println("End "+counter+"ms");

                        return new WebResourceResponse("text/css", "UTF-8",is);

                    } catch (IOException e) {
                        System.out.println("cache miss");

                        e.printStackTrace();
                    }
                }
                if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
                    System.out.println("OPTION");

                    return build();
                }

                //  Log.e("CustomerGlu","cache miss");

                return super.shouldInterceptRequest(view, request);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                pg.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebViewJavaScriptInterface(getApplicationContext(),this), "app"); // **IMPORTANT** call it app
        webView.loadUrl(url);

    }
    @TargetApi(21)
    public WebResourceResponse build() {
        final SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy kk:mm:ss", Locale.US);
        Date date = new Date();
        final String dateString = formatter.format(date);

        Map<String, String> headers = new HashMap<String, String>() {{
            put("Connection", "close");
            put("Content-Type", "text/plain");
            put("Date", dateString + " GMT");
            put("Access-Control-Allow-Origin", "*");
            put("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
            put("Access-Control-Max-Age", "600");
            put("Access-Control-Allow-Credentials", "true");
            put("Access-Control-Allow-Headers", "accept, authorization, Content-Type");
            put("Via", "1.1 vegur");
        }};

        return new WebResourceResponse("text/plain", "UTF-8", 200, "OK", headers, null);
    }
}
