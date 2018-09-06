package com.example.sean.database_1;

import org.litepal.crud.DataSupport;

public class Staff extends DataSupport{

    private String name;
    private String sex;
    private int gh;
    private String post;
    private String school;

 public String getName(){
        return  name;
    }

    public void setName(String name)  {
        this.name = name;
    }

    public String getSex(){
        return  sex;
    }

    public void setSex(String sex)  {
        this.sex = sex;
    }

    public String getPost(){
        return  post;
    }

    public void setPost(String post)  {
        this.post = post;
    }

    public String getSchool(){
        return  school;
    }

    public void setSchool(String school)  {
        this.school = school;
    }

    public int getGh(){
        return  gh;
    }

    public void setGh(int gh)  {
        this.gh = gh;
    }
}
