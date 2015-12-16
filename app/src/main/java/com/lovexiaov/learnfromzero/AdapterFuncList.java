package com.lovexiaov.learnfromzero;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.lovexiaov.learnfromzero.entity.Func;

import java.util.List;

/**
 * Adapter for AtyMain's list_func
 * Created by lovexiaov on 15/12/9.
 */
public class AdapterFuncList extends ArrayAdapter {

    private Context context;
    private List<Func> funcs;

    public AdapterFuncList(Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.funcs = objects;

    }

    public void refresh(List<Func> funcs) {
        this.funcs = funcs;
        notifyDataSetChanged();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button btn_show_func;
        if (convertView != null) {
            btn_show_func = (Button) convertView.getTag();
        } else {
            convertView = View.inflate(context, R.layout.list_func, null);
            btn_show_func = (Button) convertView.findViewById(R.id.btn_show_func);
            convertView.setTag(btn_show_func);
        }

        btn_show_func.setText(funcs.get(position).getName());
        btn_show_func.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funcs.get(position).onClick();
            }
        });

        return convertView;
    }
}
