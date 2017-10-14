package com.example.android.navtest;

/**
 * Created by Omar on 5/1/2017.
 */

public class Notifications_ListItem {
    private int icon;
    private String head;
    private String desc;

    public Notifications_ListItem(int icon, String head, String desc) {
        this.icon = icon;
        this.head = head;
        this.desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
