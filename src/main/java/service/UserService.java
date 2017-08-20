package service;

import dao.entity.User;
import dto.response.Response;

import java.util.List;

/**
 * Created by HWAY on 2017-08-14.
 */
public interface UserService {
    void insertUser(User user);

    void updateUser(User user);

    User getUserById(int usrId);

    User getUserByName(String name);

    List<User> getAllUser();
    Response login(String name, String psw);
    Response register(User user);
}
