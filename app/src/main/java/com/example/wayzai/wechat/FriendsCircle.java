package com.example.wayzai.wechat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.wayzai.wechat.Thread.FriendHttpThread;
import com.example.wayzai.wechat.Thread.UserHttpThread;
import com.example.wayzai.wechat.adapter.FriendAdapter;
import com.example.wayzai.wechat.bean.Friend;
import com.example.wayzai.wechat.util.HttpHelp;

import java.util.Arrays;
import java.util.List;



public class FriendsCircle extends AppCompatActivity {
    private ListView listView;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_circle);
        FriendHttpThread friendHttpThread = new FriendHttpThread(HttpHelp.FRIEND_SERVLET);
        friendHttpThread.start();
        try{
            friendHttpThread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Friend> friends = JSON.parseArray(friendHttpThread.getResult(),Friend.class);
        FriendAdapter friendAdapter = new FriendAdapter(FriendsCircle.this,friends);
        listView = (ListView)findViewById(R.id.friend_list);

        View v = LayoutInflater.from(this).inflate(R.layout.head_list, null);
        listView.addHeaderView(v);
        listView.setAdapter(friendAdapter);
        //Intent it = getIntent();
        //name = it.getStringExtra("name");
    }
//    public void toPublish(View v){
//        Intent intent = new Intent(FriendsCircle.this,EditMy.class);
//        intent.putExtra("name",name);
//        startActivity(intent);
//        finish();
//    }
}
