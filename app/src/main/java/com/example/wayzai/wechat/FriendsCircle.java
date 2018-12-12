package com.example.wayzai.wechat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.example.wayzai.wechat.adapter.FriendAdapter;

import java.util.Arrays;
import java.util.List;



public class FriendsCircle extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_circle);

        final LayoutInflater inflater = LayoutInflater.from(this);
        View headView = inflater.inflate(R.layout.head_list, null, false);


        ListView friendList=(ListView)findViewById(R.id.frined_list);

        List friends= Arrays.asList("a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a");
        FriendAdapter  adapter=new FriendAdapter(this,R.layout.friend_item,friends);
        friendList.addHeaderView(headView);
        friendList.setAdapter(adapter);
    }
}
