package com.himanshu.customergludemolibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Comman {

    private static final String IMAGE_DIRECTORY = "/QRcodeImages";
    public static Dialog dialog;
    public static ProgressDialog progress;
    public static Context context;
    public static ApiInterface apiInterface;

    public Comman(Context context) {
        this.context=context;
    }




    public static ApiInterface getApi() {
        return ApiClients.getClient().create(ApiInterface.class);
    }

    public static ApiInterface getApiToken(String token) {
        return ApiClients.getClient_token(token).create(ApiInterface.class);
    }


    public static void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    }
    public static String rupeeFormat(String value) {
        value = value.replace(",", "");
        char lastDigit = value.charAt(value.length() - 1);
        String result = "";
        int len = value.length() - 1;
        int nDigits = 0;
        if (len == 3) {
            return value;
        } else {
            for (int i = len - 1; i >= 0; i--) {
                result = value.charAt(i) + result;
                nDigits++;
                if (((nDigits % 2) == 0) && (i > 0)) {
                    result = "," + result;
                }
            }
            return (result + lastDigit);
        }
    }







    public static String singleCapsName(String first) {

        if (first == null || first.equals("")) {
            return "N/A";
        }

        String First = first.substring(0, 1).toUpperCase() + first.substring(1);

        return First;
    }


    public static String timeTwelveFormat(String time) {

        DateFormat f1 = new SimpleDateFormat("HH:mm:ss"); //HH for hour of the day (0 - 23)
        Date d = null;

        try {

            d = f1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat f2 = new SimpleDateFormat("hh:mm aa");

        return f2.format(d).toLowerCase();// "12:18 am"
    }


    public static String TwelveHoursFormat(String time) {

        if (time == null || time.isEmpty()) {
            return "";

        }

        DateFormat f1 = new SimpleDateFormat("hh:mm aa"); //HH for hour of the day (0 - 23)
        Date d = null;

        try {

            d = f1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat f2 = new SimpleDateFormat("HH:mm ss");

        return f2.format(d).toLowerCase();// "12:18 am"
    }


  /*  public static String DateFormat(String dateData) {

        // 12 August 2019
        DateFormat originalFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("dd MM yyyy");
        Date date = null;
        try {

            date = originalFormat.parse(dateData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = targetFormat.format(date);

        return formattedDate;// "12 08 2019
    }*/

    public static String formatDate(String dStartDt) {
        String newDate="";

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",
                    Locale.ENGLISH);
            Date parsedDate = sdf.parse(dStartDt);
            String pattern = "MMM dd, yyyy";
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat(pattern, new Locale("en", "UK"));
            //Date date = simpleDateFormat.parse(parsedDate);
            newDate = simpleDateFormat.format(parsedDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return newDate;
    }



    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}
