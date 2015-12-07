package com.lovexiaov.learnfromzero;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lovexiaov.learnfromzero.fragment.FrmtAnother;

/**
 * set fragment as content
 * Created by lovexiaov on 15/12/7.
 */
public class AtyFragment extends AtyBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_fragment);

        Button btn_switcher = (Button) super.findViewById(R.id.btn_switch_fragment);
        btn_switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrmtAnother another = new FrmtAnother();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout, another);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


    }
}
