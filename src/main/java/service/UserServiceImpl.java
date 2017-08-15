package service;

import dao.entity.User;
import dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by DELL on 2017-08-14.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper mapper;
    public void insertUser(User user) {

    }

    public void updateUser(User user) {

    }

    public User getUserById(int usrId) {
        return null;
    }

    public List<User> getAllUser() {
        List<User> usrList = mapper.getAllUser();
        return usrList;

    }
    //TODO 其他业务逻辑
}
