package com.lovexiaov.learnfromzero.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Receiver to listen custom broadcast
 * Created by lovexiaov on 15/12/9.
 */
public class RecvCustomBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "I have received a custom broadcast(~.~)", Toast.LENGTH_SHORT)
             .show();
        abortBroadcast(); // abort ordered broadcast
    }
}
