package com.lovexiaov.learnfromzero;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * set TableLayout as content
 * Created by lovexiaov on 15/12/7.
 */
public class AtyTableLayout extends AtyBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_table_layout);

        Button btn_login = (Button) super.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO log in
            }
        });
    }
}
