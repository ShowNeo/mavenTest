package com.blog.bean;

import com.blog.dao.anno.DBField;
import com.blog.dao.anno.DBTable;

/**
 * Created by wangshaonan on 17/8/29.
 */
@DBTable("user")
public class User extends DBDomain {

    @DBField("id")
    private Integer id;

    @DBField("name")
    private String name;
    @DBField("password")
    private String password;
    @DBField("phone")
    private String phone;
    @DBField("email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
