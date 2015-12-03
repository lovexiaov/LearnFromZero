package com.lovexiaov.learnfromzero;

import android.os.Bundle;
import android.view.View;

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
                AtyForPassDataGraceful.actionStart(this, "lovexiaov", "ITer");
        }
    }
}
