package com.lovexiaov.learnfromzero;

import android.os.Bundle;
import android.view.Window;

/**
 * set custom view as content
 * Created by lovexiaov on 15/12/7.
 */
public class AtyCustomView extends AtyBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.aty_custom_view);
    }
}
