package com.example.wayzai.wechat.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private static final int IMGAE_COUNT=3;

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
            holder.contentImage[0]=(ImageView)convertView.findViewById(R.id.img_content1);
            holder.contentImage[1]=(ImageView)convertView.findViewById(R.id.img_content2);
            holder.contentImage[2]=(ImageView)convertView.findViewById(R.id.img_content3);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        Friend friend=mData.get(position);
        holder.nameView.setText(friend.getName());
        holder.contentView.setText(friend.getContent());
        holder.imageView.setImageBitmap(getImage(friend.getHead()));

        String[] pictures=friend.getPicture();
        for(int i=0;i<IMGAE_COUNT;i++){
            if(i<pictures.length)
                holder.contentImage[i].setImageBitmap(getImage(pictures[i]));
            else
                holder.contentImage[i].setImageBitmap(null);
        }
        return convertView;
    }
    static class ViewHolder{
        ImageView imageView;
        TextView nameView;
        TextView contentView;
        ImageView[] contentImage= new ImageView[IMGAE_COUNT];
    }

    private Bitmap getImage(String imgUrl){
        ImageHttpThread imageHttpThread = new ImageHttpThread(imgUrl);
        imageHttpThread.start();
        try{
            imageHttpThread.join();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return imageHttpThread.getResultBitmap();
    }
}

