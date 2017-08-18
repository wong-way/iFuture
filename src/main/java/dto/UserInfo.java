package dto;

import dao.entity.User;

/**
 * Created by DELL on 2017-08-19.
 */
public class UserInfo {
    private String token ;
    private int id;

    public UserInfo(String token, int id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
