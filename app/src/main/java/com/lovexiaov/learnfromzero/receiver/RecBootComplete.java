package com.lovexiaov.learnfromzero.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.lovexiaov.learnfromzero.AtyMain;

/**
 * Receiver to listen device boot complate
 * Created by lovexiaov on 15/12/9.
 */
public class RecBootComplete extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startIntent = new Intent(context, AtyMain.class);
        startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startIntent);
        Toast.makeText(context, "BOOT COMPLETED~~", Toast.LENGTH_SHORT)
             .show();

    }
}
