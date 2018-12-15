package com.jxaucjj.utils;

/**
 * Created by 19592 on 2018/12/12.
 */
public class Friend {
    private String head;
    private String name;
    private String content;
    private String[] picture;

    public Friend() {
    }

    public Friend(String head, String name, String content, String[] picture) {
        this.head = head;
        this.name = name;
        this.content = content;
        this.picture = picture;
    }

    public String getHead() {
        return head;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String[] getPicture() {
        return picture;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPicture(String[] picture) {
        this.picture = picture;
    }
}
