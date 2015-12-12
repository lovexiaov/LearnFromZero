package com.lovexiaov.learnfromzero;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lovexiaov.learnfromzero.db.MyDatabaseHelper;

/**
 * Aty to use database
 * Created by lovexiaov on 15/12/10.
 */
public class AtyUseDatabase extends AtyBase {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_use_database);
//        DatabaseUtils.createDbFromSqlStatements(AtyUseDatabase.this,"test.db", 1, CREATE_BOOK);
        dbHelper = new MyDatabaseHelper(this, "test.db", null, 1);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, AtyUseDatabase.class);
        context.startActivity(intent);
    }

    public void add(View view) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("author", "lovexiaov");
        values.put("price", 99.0);
        values.put("page", 399);
        values.put("name", "Learn Android From 0");
        database.insert(MyDatabaseHelper.TABLE_BOOK, null, values);
        Toast.makeText(AtyUseDatabase.this, "add data", Toast.LENGTH_SHORT).show();
        database.close();
    }

    public void update(View view) {

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues  values   = new ContentValues();
        values.put("price", 9.9);
        database.update(MyDatabaseHelper.TABLE_BOOK, values, "name = ?", new String[]{"Learn Android From 0"});
        database.close();
    }

    public void delete(View view) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete(MyDatabaseHelper.TABLE_BOOK, "name = ?", new String[]{"Learn Android From 0"});
        database.close();
    }

    public void retrieve(View view) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor         cursor   = database.query(MyDatabaseHelper.TABLE_BOOK, null, null, null, null, null, null);
        int            count    = 0;
        while (cursor.moveToNext()) {
            count++;
        }
        cursor.close();
        database.close();
        Toast.makeText(AtyUseDatabase.this, "total: " + count, Toast.LENGTH_SHORT).show();
    }
}
