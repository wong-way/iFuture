package dao.entity;

import java.sql.Date;

/**
 * Created by HWAY on 2017/5/8.
 * 这个类用于用户账号
 */


public class User {

    private int id;

    private String name;

    private String token;

    private Date outDate;

    private String phone;

    private int gender;

    public User() {
    }

    public User(int id, String name, String token, Date outDate, String phone, int gender) {
        this.id = id;
        this.name = name;
        this.token = token;
        this.outDate = outDate;
        this.phone = phone;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
