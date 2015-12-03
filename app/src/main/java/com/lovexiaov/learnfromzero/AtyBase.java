package com.lovexiaov.learnfromzero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Base Activity for Activity Manager
 * Created by lovexiaov on 15/12/2.
 */
public class AtyBase extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("ActivityName", getClass().getSimpleName());
    }
}
