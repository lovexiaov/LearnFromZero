package com.lovexiaov.learnfromzero.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * broadcast receiver used to listen local broadcast
 * Created by lovexiaov on 15/12/9.
 */
public class RecvLocal extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "I have received a local broadcast(~.~)", Toast.LENGTH_SHORT).show();
    }
}
