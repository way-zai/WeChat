package com.example.wayzai.wechat.Thread;

import com.example.wayzai.wechat.util.HttpHelp;
import com.example.wayzai.wechat.util.HttpMethod;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 19592 on 2018/12/12.
 */
public class FriendHttpThread extends Thread {
    private String mode;                //请求服务器的哪个servlet文件
    private String result;              //服务器返回的结果

    public FriendHttpThread(String mode) {
        this.mode = mode;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(HttpHelp.URL+mode);
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
