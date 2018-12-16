package com.example.wayzai.wechat.Thread;

import com.example.wayzai.wechat.util.HttpHelp;
import com.example.wayzai.wechat.util.HttpMethod;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by 19592 on 2018/12/10.
 */
public class UserHttpThread extends Thread {
    private String mode;                //请求服务器的哪个servlet文件，登录或者注册
    private String username;            //用户名
    private String password;            //密码
    private String sex;                 //性别
    private String result;              //服务器返回的结果

    public UserHttpThread(String mode, String username, String password) {
        this.mode = mode;
        this.username = username;
        this.password = password;
    }

    public UserHttpThread(String mode, String username, String password, String sex) {
        this.mode = mode;
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

    @Override
    public void run() {
        try {

            String address=HttpHelp.URL + mode + "?userName=" + URLEncoder.encode(username,HttpHelp.Character_Encoding)
                    + "&password=" + URLEncoder.encode(password,HttpHelp.Character_Encoding);
            if(sex!=null)
                address+="&sex=" + URLEncoder.encode(sex,HttpHelp.Character_Encoding);
            URL url=new URL(address);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(String.valueOf(HttpMethod.GET));
            conn.setConnectTimeout(HttpHelp.TIME_OUT);
            if (conn.getResponseCode() ==HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(is, HttpHelp.Character_Encoding);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuffer results = new StringBuffer();
                String temp;
                while ((temp = reader.readLine()) != null) {
                    results.append(temp);
                }
                setResult(results.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
