package com.example.sara1126.item;

import com.example.sara1126.commonrecycler.BaseModel;

public class Category implements BaseModel {
    public static String TYPE = "CATEGORY";
    private String catName;

    public Category(String catName){
        this.catName = catName;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    public String getCatName(){
        return catName;
    }


    public String getName() {
        return null;
    }


    public String getTitle() {
        return null;
    }
}
