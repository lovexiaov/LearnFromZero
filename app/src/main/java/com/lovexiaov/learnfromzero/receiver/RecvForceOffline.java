package com.lovexiaov.learnfromzero.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

import com.lovexiaov.learnfromzero.AtyTableLayout;
import com.lovexiaov.learnfromzero.tools.ActivityController;

/**
 * Receiver to listen force offline action.
 * Created by lovexiaov on 15/12/10.
 */
public class RecvForceOffline extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Warning");
        builder.setMessage("You are forced to be offline. Please try again later");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityController.finashAll();

                Intent loginIntent = new Intent(context, AtyTableLayout.class);
                loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(loginIntent);
            }
        });

        // request permission of system alert
        // need permission: android.permission.SYSTEM_ALERT_WINDOW
        AlertDialog dialog = builder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        dialog.show();
    }
}
