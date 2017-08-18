package service;

import dao.entity.User;
import dao.mapper.UserMapper;
import dto.Token;
import helper.DateHelper;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public User getUserByName(String name) {

        User user = null;
        try{
            user = mapper.getUserByName(name);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }

    public int login(String name, String psw) {
        User user = null;
        try{
            user = mapper.getUserByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (user == null) {
            return Constant.USER_NOT_EXIST;
        }
        if (user.getPsw().equals(psw)) {
            user.setToken(new Token().getTokenStr());
            user.setOutDate(DateHelper.getOutDate(10));
            mapper.update(user);
            return Constant.LOGIN_SUCCESS;

        }return Constant.WRONG_PASSWORD;
    }


    public int register(User user) {
        if (mapper.getUserByName(user.getName()) != null) {
            return Constant.REGISTERED_REPEAT;
        }
        try{
            Token token = new Token();
            user.setToken(token.getTokenStr());
            user.setOutDate(DateHelper.getOutDate(10));
            mapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            return Constant.REGISTER_FAILED;
        }
        return Constant.REGISTER_SUCCESS;
    }
    //TODO 其他业务逻辑
}
