package com.lovexiaov.learnfromzero.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

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
        LayoutInflater.from(context).inflate(R.layout.layout_title,this);
    }

    //布局中带样式使用
    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



}
