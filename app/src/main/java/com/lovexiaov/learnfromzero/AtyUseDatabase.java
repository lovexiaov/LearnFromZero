package com.lovexiaov.learnfromzero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Aty to use database
 * Created by lovexiaov on 15/12/10.
 */
public class AtyUseDatabase extends AtyBase {

    public static final String CREATE_BOOK = "create table Book ("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "page integer,"
            + "name text)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_use_database);
//        DatabaseUtils.createDbFromSqlStatements(AtyUseDatabase.this,"test.db", 1, CREATE_BOOK);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, AtyUseDatabase.class);
        context.startActivity(intent);
    }

    public void add(View view) {

    }

    public void update(View view) {

    }

    public void delete(View view) {

    }

    public void retrieve(View view) {

    }
}
