package com.example.pokeappmain;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;

import com.example.pokeappmain.api.ApiService;
import com.example.pokeappmain.api.PokeClient;

public class Utils {

    public static ApiService getApi() {
        return PokeClient.retrofitBuilder().create(ApiService.class);
    }
    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }

}
