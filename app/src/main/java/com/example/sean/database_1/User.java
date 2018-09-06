package com.example.sean.database_1;

import org.litepal.crud.DataSupport;

public class User extends DataSupport {

    private String name;  //登录者姓名
    private int password;  //登录密码


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPassword() {
        return password;
    }
}
