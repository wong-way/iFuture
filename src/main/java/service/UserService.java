package service;

import dao.entity.User;

import java.util.List;

/**
 * Created by HWAY on 2017-08-14.
 */
public interface UserService {
    void insertUser(User user);

    void updateUser(User user);

    User getUserById(int usrId);

    List<User> getAllUser();
}
