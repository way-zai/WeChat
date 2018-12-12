package com.example.wayzai.wechat.Thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.wayzai.wechat.util.HttpHelp;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 19592 on 2018/12/12.
 */
public class ImageHttpThread extends Thread {
    private String imageUrl;
    private Bitmap resultBitmap;

    public ImageHttpThread(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void run() {
        try{
            URL url = new URL(HttpHelp.URL+imageUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            InputStream inputStream = conn.getInputStream();
            setResultBitmap(BitmapFactory.decodeStream(inputStream));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Bitmap getResultBitmap() {
        return resultBitmap;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setResultBitmap(Bitmap resultBitmap) {
        this.resultBitmap = resultBitmap;
    }
}
