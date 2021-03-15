package com.domain;

import java.util.Date;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/3/15 15:18
 */
public class User {
    private Integer id;

    private String username;

    private String sex;

    private Date birthday;

    private Integer iphone;

    private String address;

    public User() {
    }

    public User(String username, String sex, Date birthday, Integer iphone, String address) {
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.iphone = iphone;
        this.address = address;
    }

    public User(Integer id, String username, String sex, Date birthday, Integer iphone, String address) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.iphone = iphone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", iphone=" + iphone +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getIphone() {
        return iphone;
    }

    public void setIphone(Integer iphone) {
        this.iphone = iphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}