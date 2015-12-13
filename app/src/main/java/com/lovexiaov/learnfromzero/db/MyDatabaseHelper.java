package com.lovexiaov.learnfromzero.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Database helper
 * Created by lovexiaov on 15/12/10.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context mContext;

    public static final String TABLE_BOOK  = "BOOK";
    public static final String BOOK_AUTHOR = "AUTHOR";
    public static final String BOOK_PRICE  = "PRICE";
    public static final String BOOK_PAGE   = "PAGE";
    public static final String BOOK_NAME   = "NAME";

    private final String CREATE_BOOK =
            "create table " + TABLE_BOOK + " ("
            + "id integer primary key autoincrement,"
            + BOOK_AUTHOR + " text,"
            + BOOK_PRICE + " real,"
            + BOOK_PAGE + " integer,"
            + BOOK_NAME + " text)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
        Toast.makeText(mContext, "Create db success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                // do modify to update to version 2
            case 2:
                // do modify to update to version 3
            // ...
            // no break...
        }
    }
}
