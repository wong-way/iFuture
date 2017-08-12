package dao.entity;

import java.sql.Date;

/**
 * Created by HWAY on 2017-08-11.
 * 这个类用于管理员
 */
public class Admin {

    private int id;
    private String name;
    private String token;
    private Date outDate;
    private String phone;
    private int gender;
    private int type;
    private String mail;

    public Admin() {
    }

    public Admin(int id, String name, String token, Date outDate, String phone, int gender, int type, String mail) {
        this.id = id;
        this.name = name;
        this.token = token;
        this.outDate = outDate;
        this.phone = phone;
        this.gender = gender;
        this.type = type;
        this.mail = mail;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
