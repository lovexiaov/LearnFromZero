package com.lovexiaov.learnfromzero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lovexiaov.learnfromzero.tools.ActivityController;

/**
 * Base Activity for Activity Manager
 * Created by lovexiaov on 15/12/2.
 */
public class AtyBase extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("ActivityName", getClass().getSimpleName());
        ActivityController.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }
}
