package com.example.wayzai.wechat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.wayzai.wechat.Thread.UserHttpThread;
import com.example.wayzai.wechat.util.HttpHelp;


public class RegisterActivity extends AppCompatActivity{
    private Context mContext;
    private EditText editName;
    private EditText editPassword;
    private EditText editPassword1;
    private RadioGroup radioGroup;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = RegisterActivity.this;
        bindViews();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name="",password="",password1="",sex="";
                name = editName.getText().toString();
                password = editPassword.getText().toString();
                password1 = editPassword1.getText().toString();
                //判断男女
                for(int i=0;i<radioGroup.getChildCount();i++){
                    RadioButton raidoButton = (RadioButton)radioGroup.getChildAt(i);
                    if(raidoButton.isChecked()){
                        sex = raidoButton.getText().toString();
                    }
                }
                if("".equals(name)||"".equals(password)||"".equals(password1)||"".equals(sex)){
                    Toast.makeText(mContext,"用户名，密码，性别不能为空",Toast.LENGTH_SHORT).show();
                }else if(password.equals(password1)){
                    if(haveName(name,password,sex)){
                        Toast.makeText(mContext,"该用户名已经被用过了，请重新输入",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(mContext,"注册成功",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(mContext,"两次密码不一致",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void bindViews(){
        editName = (EditText)findViewById(R.id.editName);
        editPassword = (EditText)findViewById(R.id.editPassword);
        editPassword1 = (EditText)findViewById(R.id.editPassword1);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        button = (Button)findViewById(R.id.button);
    }
    //判断数据库中是否已有该用户名
    private boolean haveName(String names,String passwd,String sex){
        UserHttpThread userHttpThread = new UserHttpThread(HttpHelp.REGISTER_SERVLET,names,passwd,sex);
        userHttpThread.start();
        try{
            userHttpThread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        String state = userHttpThread.getResult();
        return "No".equals(state);
    }
}
