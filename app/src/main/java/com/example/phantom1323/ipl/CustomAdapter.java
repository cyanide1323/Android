package com.example.phantom1323.ipl;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;



public class CustomAdapter extends ArrayAdapter<Datamodel> implements View.OnClickListener{

    private ArrayList<Datamodel> dataset;
    Context context;

    public CustomAdapter(ArrayList<Datamodel> data, Context context){
        super(context,R.layout.row_item,data);
        this.dataset = data;
        this.context = context;
    }
    @Override
    public void onClick(View v) {
        int position = (Integer)v.getTag();
        Datamodel datamodel = (Datamodel)getItem(position);
        switch (v.getId()){
            case R.id.team1:
                // Do something
                break;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Datamodel datamodel = getItem(position);
        ViewHolder viewHolder;
        final View result;
    }
}
