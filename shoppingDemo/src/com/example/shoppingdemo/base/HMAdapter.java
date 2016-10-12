    package com.example.shoppingdemo.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjz on 2016/7/17.
 */
public abstract class HMAdapter<T> extends BaseAdapter {

    private List<T> list=new ArrayList<T>();

    public HMAdapter(List<T> list) {
        super();
        this.list=list;
    }

    @Override

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //留给子类实现
    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
