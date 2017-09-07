package service;

import dao.entity.User;
import dto.response.Response;

import java.util.List;

/**
 * Created by HWAY on 2017-08-14.
 */
public interface UserService {

    List<User> getAllUser();
    Response login(String name, String psw);
    Response register(User user);
}
