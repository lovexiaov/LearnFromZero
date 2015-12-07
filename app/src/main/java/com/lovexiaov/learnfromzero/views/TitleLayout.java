package com.lovexiaov.learnfromzero.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lovexiaov.learnfromzero.R;

/**
 * Custom View
 * Created by lovexiaov on 15/12/7.
 */
public class TitleLayout extends LinearLayout {

    // 代码中直接生成
    public TitleLayout(Context context) {
        super(context);
    }

    // 布局中使用
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context)
                      .inflate(R.layout.layout_title, this);

        Button back = (Button) findViewById(R.id.btn_back);
        Button edit = (Button) findViewById(R.id.btn_edit);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });

        edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Your clicked Edit button", Toast.LENGTH_LONG).show();
            }
        });

    }

    //布局中带样式使用
    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
