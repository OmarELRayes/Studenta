package com.example.android.navtest;

import java.util.Date;

/**
 * Created by Luffy on 5/18/2017.
 */

public class user {
    int id;
    String fname;
    String lname;
    String fullName=fname + ' '+lname;
    String phoneNumber;
    String email;
    String avatar;
    Date registerDate;
    String type;
    public user
            (int id,String fname, String lname, String phoneNumber,String email,String avatar, Date registerDate,String type){
        this.id=id;
        this. fname=fname;
        this. lname=lname;
        this.  phoneNumber=phoneNumber;
        this.  email=email;
        this. avatar=avatar;
        this.  registerDate=registerDate;
        this.type=type;
    }
    public user(){}
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id=id;
    }
    public String getFname(){
        return fname;
    }
    public void setFname(String fname){
        this.fname=fname;
    }
    public String getLname(){
        return lname;
    }
    public void setLname(String lname){
        this.lname=lname;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void getPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getAvatar(){
        return avatar;
    }
    public void setAvatar(String avatar){
        this.avatar=avatar;
    }
    public Date getRegisterDate(){
        return registerDate;
    }
    public void setRegisterDate(Date registerDate){
        this.registerDate=registerDate;
    }
    public String getFullName(){
        return fullName;
    }
    public String getType(){
        return type;
    }
    public void setType(String type)
    {
        this.type=type;
    }

}
