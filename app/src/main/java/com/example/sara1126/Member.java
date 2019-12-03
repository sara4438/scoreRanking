package com.example.sara1126;

import com.example.sara1126.commonrecycler.BaseModel;

public class Member implements BaseModel {
    public static final String TYPE = "ITEM_1";
    private String name;
    private String account;
    private String phoneNum;
    private String birth;

    public Member(String name, String account, String phoneNum, String birth){
        this.name = name;
        this.account = account;
        this.phoneNum = phoneNum;
        this.birth = birth;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    public void setBirth(String birth){
        this.birth = birth;
    }

    public String getName(){
        return name;
    }

    public String getAccount(){
        return account;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public String getBirth(){
        return birth;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
