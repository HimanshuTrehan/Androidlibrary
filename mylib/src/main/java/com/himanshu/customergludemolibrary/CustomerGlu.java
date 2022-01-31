package com.himanshu.customergludemolibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.himanshu.customergludemolibrary.Interface.DataListner;
import com.himanshu.customergludemolibrary.Interface.RewardInterface;
import com.himanshu.customergludemolibrary.Modal.EventData;
import com.himanshu.customergludemolibrary.Modal.RegisterModal;
import com.himanshu.customergludemolibrary.Modal.RegisterObject;
import com.himanshu.customergludemolibrary.Modal.RewardModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Notification.DEFAULT_ALL;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static androidx.core.app.NotificationCompat.PRIORITY_MAX;

public class CustomerGlu {

    public static ApiInterface mService;
    public static String token="";
   public static RegisterModal registerModal;
   public static RewardModel rewardModel;
    public static EventData eventData;



    public static void doRegister(Context context, RegisterObject registerObject, DataListner callBack)
    {
        /*ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("loading");
        progressDialog.show();*/
        try {
            mService = Comman.getApiToken("");
            registerModal = new RegisterModal();
            mService.doRegisterWithNotification(registerObject)
                    .enqueue(new Callback<RegisterModal>() {
                        @Override
                        public void onResponse(Call<RegisterModal> call, Response<RegisterModal> response) {
                            try {
                                //      progressDialog.dismiss();

                                if(response.body().success.equalsIgnoreCase("true")) {
                                    //Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                                    registerModal.setData(response.body().getData());

                                    //   Toast.makeText(context, registerModal.data.token, Toast.LENGTH_LONG).show();
                                    token = registerModal.data.token;
                                    callBack.onData(registerModal);
                                    //   retierveData(context,token);
                                }

                            } catch (Exception ex) {
                                //    progressDialog.dismiss();

                                Toast.makeText(context, "" + ex, Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onFailure(Call<RegisterModal> call, Throwable t) {

                            //       Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                            callBack.onFail(t.getMessage());

                        }
                    });

        } catch (Exception e) {
            //  Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
            callBack.onFail(e.toString());

        }

    }



    public static void retrieveDataByType(Context context, String token,String type, RewardInterface callback) {

        try {

            mService = Comman.getApiToken(token);

            mService.customerRetrieveData(type)
                    .enqueue(new Callback<RewardModel>() {
                        @Override
                        public void onResponse(Call<RewardModel> call, Response<RewardModel> response) {
                            try {
                                if(response.body().success.equalsIgnoreCase("true")) {

                                  //  Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
                                    callback.onSuccess(response.body());

                                }

                            } catch (Exception ex) {
                                Toast.makeText(context, "" + ex, Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<RewardModel> call, Throwable t) {

                            Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

        } catch (Exception e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
        }
    }


    public static void openWebByType(Context context,String customer_token,String type)
    {

        if(type.equalsIgnoreCase(""))
        {
            Toast.makeText(context, "Please enter type", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent web = new Intent(context, OpenCustomerGluWeb.class);
            web.putExtra("customer_token", customer_token);
            web.putExtra("type", type);
            web.setFlags(FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(web);
        }
    }

    public static void openWallet(Context context,String customer_token)
    {
        Intent web = new Intent(context,OpenCustomerGluWeb.class);
        web.putExtra("customer_token",customer_token);
        web.putExtra("type","");
        web.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(web);

    }

    public static void openMiddleNudge(Context context,String customer_token)
    {
        Intent web = new Intent(context,MiddleDialog.class);
        web.putExtra("nudge_url","https://google.com");
        web.putExtra("opacity","0.5");
        web.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(web);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void displayCustomerGluNotification(Context context,JSONObject json) {
        JSONObject data = null;
        try {
            data = new JSONObject(String.valueOf(json));

            String type = data.getString("type");


            if(type.equalsIgnoreCase("CustomerGlu")) {
                String url = data.getString("nudge_url");
                String body = data.getString("body");
                String title = data.getString("title");
                String glu_message_type = data.getString("glu_message_type");
                if (glu_message_type.equalsIgnoreCase("in-app")) {
                    CustomerGlu.handleDataMessage(context,url);

                } else {
                    displayNotification(context, title, body, url);
                }
            }
            else
            {
                return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public static String handleDeepLink(Uri deeplink)
    {
        String referrerUserId = deeplink.getQueryParameter("userId");
        return  referrerUserId;
    }

        public static void handleDataMessage(Context context,String url) {

       // EventBus.getDefault().post(new EventData(url));
        Intent intent = new Intent(context,NotificationWeb.class);
        intent.putExtra("nudge_url",url);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }




    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventData event){

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void displayNotification(Context context, String title, String message, String url) {
        System.out.println("sdadsad");
        System.out.println(url);
        Intent intent = new Intent(context, NotificationWeb.class);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("nudge_url",url);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "234")
                .setSmallIcon(R.drawable.customerglu)
                .setContentTitle(Html.fromHtml(title))
                .setContentText(Html.fromHtml(message))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setPriority(PRIORITY_MAX)
                .setDefaults(DEFAULT_ALL);
        NotificationManager manager = context.getSystemService(NotificationManager.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new NotificationChannel("234", "CustomerGlu", NotificationManager.IMPORTANCE_MAX);

            manager.createNotificationChannel(notificationChannel);
        }
        manager.notify(Integer.parseInt(("234")), builder.build());




    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void sendEventData(Context context, String WriteKey,String userId ,String eventName )
    {
        try {
            eventData = new EventData();
            String uniqueId = UUID.randomUUID().toString();
            eventData.setUser_id(userId);
            eventData.setEvent_id(uniqueId);
            eventData.setEvent_name(eventName);

            eventData.setTimestamp(String.valueOf(LocalDateTime.now()));
            mService = Comman.getApiToken(WriteKey);
            registerModal = new RegisterModal();
            mService.sendEvents(WriteKey,eventData)
                    .enqueue(new Callback<RegisterModal>() {
                        @Override
                        public void onResponse(Call<RegisterModal> call, Response<RegisterModal> response) {
                            try {


                            } catch (Exception ex) {

                                Toast.makeText(context, "" + ex, Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onFailure(Call<RegisterModal> call, Throwable t) {

                            //       Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

        } catch (Exception e) {
              Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void sendEventData(Context context, String WriteKey, String userId , String eventName, EventData.EventProperties eventProperties)
    {
        try {
            eventData = new EventData();
            String uniqueId = UUID.randomUUID().toString();
            eventData.setUser_id(userId);
            eventData.setEvent_id(uniqueId);
            eventData.setEvent_name(eventName);
            eventData.setEventProperties(eventProperties);

            eventData.setTimestamp(String.valueOf(LocalDateTime.now()));
            mService = Comman.getApiToken(WriteKey);
            registerModal = new RegisterModal();
            mService.sendEvents(WriteKey,eventData)
                    .enqueue(new Callback<RegisterModal>() {
                        @Override
                        public void onResponse(Call<RegisterModal> call, Response<RegisterModal> response) {
                            try {


                            } catch (Exception ex) {

                                Toast.makeText(context, "" + ex, Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onFailure(Call<RegisterModal> call, Throwable t) {

                            //       Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

        } catch (Exception e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();

        }
    }

}


