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
 * Created by 19592 on 2018/12/12.
 */
public class FriendHttpThread extends Thread {
    private String mode;                //请求服务器的哪个servlet文件
    private String result;              //服务器返回的结果
    private String name;                //发给服务器的名字
    private String content;             //发给服务器说说的内容
    public FriendHttpThread(String mode) {
        this.mode = mode;
    }

    public FriendHttpThread(String mode, String name, String content) {
        this.mode = mode;
        this.name = name;
        this.content = content;
    }

    @Override
    public void run() {
        try {
            URL url ;
            if (name == null) {
                url = new URL(HttpHelp.URL + mode);
            } else {
                url = new URL(HttpHelp.URL + mode + "?userName=" + URLEncoder.encode(name,"utf-8") +
                        "&contents=" + URLEncoder.encode(content,"utf-8") );
            }
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(String.valueOf(HttpMethod.GET));
            conn.setConnectTimeout(HttpHelp.TIME_OUT);
            if (conn.getResponseCode() == 200) {
                InputStream is = conn.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(is, "utf-8");
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
