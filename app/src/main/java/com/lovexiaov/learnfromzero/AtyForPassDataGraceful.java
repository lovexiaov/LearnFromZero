package com.lovexiaov.learnfromzero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lovexiaov.learnfromzero.tools.MyConfig;

/**
 * Activity for test pass data gracefully in intent
 * Created by lovexiaov on 15/12/2.
 */
public class AtyForPassDataGraceful extends AtyBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_for_pass_data_graceful);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MyConfig.KEY_NAME);
        String occupation = intent.getStringExtra(MyConfig.KEY_OCCUPATION);

        TextView text_info = (TextView) super.findViewById(R.id.text_info);
        text_info.setText("Hi, my name is " + name +", I am a " + occupation);

    }

    /**
     * Start itself by necessary params
     * @param context who start this activity
     * @param name
     * @param occupation
     */
    public static void actionStart(Context context, String name, String occupation) {
        Intent intent = new Intent(context, AtyForPassDataGraceful.class);
        intent.putExtra(MyConfig.KEY_NAME, name);
        intent.putExtra(MyConfig.KEY_OCCUPATION, occupation);
        context.startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
