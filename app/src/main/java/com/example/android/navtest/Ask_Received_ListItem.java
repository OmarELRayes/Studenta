package com.example.android.navtest;

/**
 * Created by Omar on 5/12/2017.
 */

public class Ask_Received_ListItem {

    private int mainIcon;
    private int stateIcon;
    private String name;
    private String title;


    public Ask_Received_ListItem(int mainIcon, int stateIcon, String name, String title) {
        this.mainIcon = mainIcon;
        this.stateIcon = stateIcon;
        this.name = name;
        this.title = title;
    }


    public int getMainIcon() {
        return mainIcon;
    }

    public int getStateIcon() {
        return stateIcon;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }


}
