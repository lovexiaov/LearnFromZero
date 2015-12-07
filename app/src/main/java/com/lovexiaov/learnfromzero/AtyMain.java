package com.lovexiaov.learnfromzero;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lovexiaov.learnfromzero.tools.ActivityController;


public class AtyMain extends AtyBase implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hide title bar
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.aty_main);
        ActivityController.addActivity(this);

        super.findViewById(R.id.btn_start)
             .setOnClickListener(this);
        super.findViewById(R.id.btn_show_alert_dialog)
             .setOnClickListener(this);
        super.findViewById(R.id.btn_show_progress_dialog)
             .setOnClickListener(this);
        super.findViewById(R.id.btn_show_table_layout).setOnClickListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                AtyEasyStart.actionStart(this, "lovexiaov", "ITer");
                break;

            case R.id.btn_show_alert_dialog:
                showAlert();
                break;

            case R.id.btn_show_progress_dialog:
                showProgressDialog();
                break;

            case R.id.btn_show_table_layout:
                showTableLayout();

            default:

                break;
        }

    }

    private void showTableLayout() {
        Intent intent = new Intent(AtyMain.this, AtyTableLayout.class);
        startActivity(intent);
    }

    private void showProgressDialog() {
        ProgressDialog dialog = new ProgressDialog(AtyMain.this);
        dialog.setTitle("Progress Dialog");
        dialog.setMessage("Progress Dialog Message");
        dialog.setCancelable(true);
        dialog.show();
    }

    private void showAlert() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AtyMain.this);
        dialog.setTitle("Alert");
        dialog.setView(new Button(AtyMain.this));
        dialog.setMessage("This is an alert dialog");
        dialog.setPositiveButton("OK", null);
        dialog.setNegativeButton("Cancel", null);
        dialog.setNeutralButton("Neutral", null);
        dialog.show();

    }
}
