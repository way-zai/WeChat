package com.example.wayzai.wechat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wayzai.wechat.Thread.FriendHttpThread;
import com.example.wayzai.wechat.util.HttpHelp;


public class EditMy extends AppCompatActivity {

    private TextView textView;
    private TextView contents;
    private String name;
    private String myContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my);
        textView = (TextView)findViewById(R.id.publish);
        contents = (TextView)findViewById(R.id.edit_letter);
        Intent it = getIntent();
        name = it.getStringExtra("name");
        myContent = contents.getText().toString();
    }

    public void publish(View v){
        FriendHttpThread friendThread = new FriendHttpThread(HttpHelp.FRIEND_SERVLET,name,myContent);
        friendThread.start();
        try{
            friendThread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        Intent intent = new Intent(EditMy.this,FriendsCircle.class);
        startActivity(intent);
        finish();
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
