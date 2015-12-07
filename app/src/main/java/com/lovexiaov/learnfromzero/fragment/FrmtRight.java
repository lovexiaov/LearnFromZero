package com.lovexiaov.learnfromzero.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lovexiaov.learnfromzero.R;


/**
 * Right Fragment
 * Created by lovexiaov on 15/12/7.
 */
public class FrmtRight extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.frmt_right, container, false);
    }
}
