package com.example.wayzai.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wayzai.wechat.Thread.UserHttpThread;
import com.example.wayzai.wechat.util.HttpHelp;


public class LoginActivity extends AppCompatActivity{
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
                if ("".equals(name) || "".equals(name)) {
                    Toast.makeText(LoginActivity.this, "用户名，密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (match(name, passwd)) {
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,FriendsCircleActivity.class);
                        intent.putExtra("name",name);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
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
        if("Yes".equals(state)){
            return true;
        }else if("No".equals(state)){
            return false;
        }
        return false;
    }
}
