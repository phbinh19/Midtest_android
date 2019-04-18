package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.model.PhepChia;
import com.example.thi_gk.R;

import java.util.List;

public class PhepChiaAdapter extends ArrayAdapter<PhepChia> {
    Activity context;
    int resource;
    List<PhepChia> objects;
    public PhepChiaAdapter(Activity context, int resource, List<PhepChia> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        PhepChia phepChia = this.objects.get(position);

        TextView itemKQ = (TextView) row.findViewById(R.id.itemKQ);

        itemKQ.setText(phepChia.getTxtKQ());
        return row;
    }
}
