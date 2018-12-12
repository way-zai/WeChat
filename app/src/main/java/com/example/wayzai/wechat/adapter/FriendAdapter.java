package com.example.wayzai.wechat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;

/**
 * Created by cjj on 2018/12/11.
 */
public class FriendAdapter extends ArrayAdapter{

    private int resourcesId;

    public FriendAdapter(Context context, int resource,List friends) {
        super(context, resource,friends);
        this.resourcesId=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null)
            convertView= LayoutInflater.from(getContext()).inflate(resourcesId,parent,false);

        return convertView;
    }
}

