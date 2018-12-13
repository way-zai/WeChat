package com.example.wayzai.wechat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wayzai.wechat.Thread.FriendHttpThread;
import com.example.wayzai.wechat.util.HttpHelp;


public class EditMy extends AppCompatActivity {

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
                Intent intent = new Intent(EditMy.this,FriendsCircle.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void toBack(View v){
        Intent intent = new Intent(EditMy.this,FriendsCircle.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
