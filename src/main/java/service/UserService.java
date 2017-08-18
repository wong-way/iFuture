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
    public Response login(String name, String psw);
    public Response register(User user);
}
