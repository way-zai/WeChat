package com.example.wayzai.wechat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wayzai.wechat.Thread.UserHttpThread;
import com.example.wayzai.wechat.util.HttpHelp;


public class login extends ActionBarActivity {
    private EditText editName;
    private EditText editPassword;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = (EditText)findViewById(R.id.editName);
        editPassword = (EditText)findViewById(R.id.editPassword);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, passwd;
                name = editName.getText().toString();
                passwd = editPassword.getText().toString();
                if (name.equals("") || passwd.equals("")) {
                    Toast.makeText(login.this, "用户名，密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (match(name, passwd)) {
                        Toast.makeText(login.this, "登录成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(login.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public boolean match(String name,String passwd){
        UserHttpThread userHttpThread = new UserHttpThread(HttpHelp.LOGIN_SERVLET,name,passwd);
        userHttpThread.start();
        try{
            userHttpThread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        String state = userHttpThread.getResult();
        if(state.equals("Yes")){
            return true;
        }else if(state.equals("No")){
            return false;
        }
        return false;
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
