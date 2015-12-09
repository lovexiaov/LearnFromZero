package com.lovexiaov.learnfromzero.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * class for use BroadcastReceiver
 * Created by lovexiaov on 15/12/9.
 */
public class RecvNetChange extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // need permission: "android.permission.ACCESS_NETWORK_STATE"
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "NetWork not available~~", Toast.LENGTH_SHORT).show();

        }
    }
}
