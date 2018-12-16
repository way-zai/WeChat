package com.example.wayzai.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wayzai.wechat.Thread.FriendHttpThread;
import com.example.wayzai.wechat.util.HttpHelp;


public class EditMyActivity extends AppCompatActivity {

    private TextView textView;
    private EditText contents;
    private String name;
    private String myContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my);
        textView = (TextView)findViewById(R.id.publish);
        contents = (EditText)findViewById(R.id.editPublish);
        Intent it = getIntent();
        name = it.getStringExtra("name");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContent = contents.getText().toString();
                FriendHttpThread friendThread = new FriendHttpThread(HttpHelp.FRIEND_SERVLET,name,myContent);
                friendThread.start();
                Intent intent = new Intent(EditMyActivity.this,FriendsCircleActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void toBack(View v){
        Intent intent = new Intent(EditMyActivity.this,FriendsCircleActivity.class);
        startActivity(intent);
    }
}
