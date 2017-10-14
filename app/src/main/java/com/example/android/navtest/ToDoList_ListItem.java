package com.example.android.navtest;

/**
 * Created by Omar on 5/1/2017.
 */

public class ToDoList_ListItem {
    private int icon;
    private String head;
    private String desc;
    private String date;
    private String email;

    public ToDoList_ListItem(int icon, String head, String desc,String date,String email) {
        this.icon = icon;
        this.head = head;
        this.desc = desc;
        this.date = date;
        this.email=email;
    }
    public ToDoList_ListItem(){

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

    public String getDate() {
        return date;
    }
    public String getEmail(){return email;}
    public void setIcon(int icon){this.icon=icon;}

}
