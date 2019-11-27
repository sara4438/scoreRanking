package com.example.sara1126;

public class Member {
    private String name;
    private String account;
    private String phoneNum;
    private String birth;

    public Member(String name, String account, String phonNum, String birth){
        this.name = name;
        this.account = account;
        this.phoneNum = phonNum ;
        this.birth = birth;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAccount(String account){
        this.account = account;
    }
    public void setBirth (String birth){
        this.birth = birth;
    }
    public void setPhoneNum (String phoneNum){
        this.phoneNum = phoneNum;
    }
    public String getAccount(){
        return account;
    }
    public String getName(){
        return name;
    }
    public String getBirth(){
        return birth;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
}

