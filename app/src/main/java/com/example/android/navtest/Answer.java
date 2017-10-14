package com.example.android.navtest;

import java.util.Date;

/**
 * Created by Luffy on 5/20/2017.
 */

public class Answer
{
    int ansId;
    int qid;
    String title;
    String text;
    String senderEmail;
    String recieverEmail;
    boolean read;
    Date date;
    public int getQid() {
        return qid;
    }

    public int getAnsId() {
        return ansId;
    }

    public boolean isRead() {
        return read;
    }

    public String getRecieverEmail() {
        return recieverEmail;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public Date getDate() {
        return date;
    }
    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}


