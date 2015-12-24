package com.lovexiaov.learnfromzero.entity;

/**
 * List of function entity
 * Created by lovexiaov on 15/12/9.
 */
public class Func {
    private OnClickListener onClickListener;
    private String          name;

    public Func(String name, OnClickListener onClickListener) {
        this.name = name;
        this.onClickListener = onClickListener;
    }

    public String getName() {
        return name;
    }

    public void onClick() {
        onClickListener.action();
    }


    public interface OnClickListener {
        void action();
    }
}
