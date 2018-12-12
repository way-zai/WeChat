package com.example.wayzai.wechat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wayzai.wechat.R;
import com.example.wayzai.wechat.Thread.ImageHttpThread;
import com.example.wayzai.wechat.bean.Friend;

import java.util.List;

/**
 * Created by cjj on 2018/12/11.
 */
public class FriendAdapter extends BaseAdapter{
    private Context mContext;
    private List<Friend> mData;

    public FriendAdapter(Context mContext, List<Friend> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewHolder holder = null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.friend_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.img_head);
            holder.nameView = (TextView)convertView.findViewById(R.id.name);
            holder.contentView = (TextView)convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.nameView.setText(mData.get(position).getName());
        holder.contentView.setText(mData.get(position).getContent());
        ImageHttpThread imageHttpThread = new ImageHttpThread(mData.get(position).getHead());
        imageHttpThread.start();
        try{
            imageHttpThread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        holder.imageView.setImageBitmap(imageHttpThread.getResultBitmap());
        return convertView;
    }
    static class ViewHolder{
        ImageView imageView;
        TextView nameView;
        TextView contentView;

    }
}

