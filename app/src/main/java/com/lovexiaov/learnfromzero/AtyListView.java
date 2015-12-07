package com.lovexiaov.learnfromzero;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * set listview as content
 * Created by lovexiaov on 15/12/7.
 */
public class AtyListView extends AtyBase {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_list_view);

        ListView lv_content = (ListView) super.findViewById(R.id.lv_content);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AtyListView.this, android.R.layout.simple_list_item_1, data);
        lv_content.setAdapter(adapter);
    }
}
