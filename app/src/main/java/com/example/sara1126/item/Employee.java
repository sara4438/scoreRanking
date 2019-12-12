package com.example.sara1126.item;

import com.example.sara1126.commonrecycler.BaseModel;

public class Employee implements BaseModel {
    private String name;
    private String category;
    private String title;
    public static String TYPE = "EMPLOYEE";

    public Employee(String category,String name, String title){
        this.name = name;
        this.category = category;
        this.title = title;
    }
    public String getType(){
        return TYPE;
    }


    public String getCatName() {
        return category;
    }

    @Override
    public int getSeat() {
        return 0;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getName(){
        return  name;
    }

//    public String getCategory() {
//        return category;
//    }

    public String getTitle() {
        return title;
    }
}
