package com.himanshu.customergludemolibrary;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJavaScriptInterface {
    private Context context;
    private Activity activity;
    /*
     * Need a reference to the context in order to sent a post message
     */
    public WebViewJavaScriptInterface(Context context,Activity activity){
        this.context = context;
        this.activity = activity;
    }

    @JavascriptInterface
    public void callback(String message){
        JSONObject data = null;
        try {
            data = new JSONObject(message);
            String event = data.getString("eventName");

            if(event.equalsIgnoreCase("CLOSE"))
            {
               activity.finish();

            }

            if(event.equalsIgnoreCase("OPEN_DEEPLINK"))
            {
                JSONObject me = data.getJSONObject("data");
                String url = me.getString("deepLink");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.setPackage("com.example.modpod");
                try {
                    activity.startActivity(i);
                } catch (ActivityNotFoundException e) {
                    // Chrome is probably not installed
                    // Try with the default browser
                    i.setPackage(null);
                    activity.startActivity(i);
                }
            }

            if(event.equalsIgnoreCase("SHARE"))
            {
                JSONObject me = data.getJSONObject("data");
                String text = me.getString("text");
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                activity.startActivity(Intent.createChooser(sendIntent, "Share"));
                activity.startActivity(sendIntent);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // data has the event information
    }


}