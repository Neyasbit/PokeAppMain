package com.example.pokeappmain;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MyApplication extends Application {

    private static MyApplication INSTANCE = null;

    public static MyApplication getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MyApplication();

        }
        return INSTANCE;
    }

    /*public static boolean hasNetwork() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }*/
}
