package com.turtlemint.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {

    public static String formatDate(String serverDate) {
        // 2018-12-24T15:48:15.707+05:30
        if (serverDate != null && !TextUtils.isEmpty(serverDate)) {
            DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);//These format come to server
            originalFormat.setTimeZone(TimeZone.getDefault());
            DateFormat targetFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);  //change to new format here  //dd-MM-yyyy HH:mm:ss
            Date date;
            String formattedDate = "";
            try {
                date = originalFormat.parse(serverDate);

                formattedDate = targetFormat.format(date);  //result
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return formattedDate;
        } else {
            return "";
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
