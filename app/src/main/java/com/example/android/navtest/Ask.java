package com.example.android.navtest;

import java.util.Date;

/**
 * Created by Luffy on 5/20/2017.
 */

public class Ask {
    int qid;
    String sentName;
    String recievedName;
    String title;
    String text;
    String senderEmail;
    String recieverEmail;
    boolean answered;
    boolean read;
    Date date;
    public Ask(){}
    public Ask(int qid,String sentName,String recievedName,String title,String text,String senderEmail,String recieverEmail,Date date)
    {
        this.sentName=sentName;
        this.qid=qid;
        this.title=title;
        this.text=text;
        this.senderEmail=senderEmail;
        this.recieverEmail=recieverEmail;
        this.date=date;
        this.recievedName=recievedName;
    }

    public String getSentName() {
        return sentName;
    }

    public boolean isAnswered() {
        return answered;
    }

    public String getRecievedName() {
        return recievedName;
    }

    public boolean isRead() {
        return read;
    }

    public Date getDate() {
        return date;
    }

    public int getQid() {
        return qid;
    }

    public String getRecieverEmail() {
        return recieverEmail;
    }

    public String getSenderEmail() {
        return senderEmail;
    }


    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}
