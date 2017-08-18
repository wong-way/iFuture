package service;

import dao.entity.User;
import dao.mapper.UserMapper;
import dto.Token;
import dto.UserInfo;
import dto.response.Info;
import dto.response.Response;
import helper.DateHelper;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Response login(String name, String psw) {
        User user = null;
        Response response = new Response();
        try{
            user = mapper.getUserByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (user == null) {
            Info info = new Info(Constant.USER_NOT_EXIST, "用户不存在，请注册");
            response.setInfo(info);
        }
        if (user.getPsw().equals(psw)) {
            String tokenStr =new Token().getTokenStr();
            user.setToken(tokenStr);
            user.setOutDate(DateHelper.getOutDate(10));
            mapper.update(user);

            Info info = new Info(Constant.LOGIN_SUCCESS, "登录成功");
            int usrId = user.getId();
            UserInfo userInfo = new UserInfo(tokenStr, usrId);
            response.setInfo(info);
            response.setData(userInfo);

        }else{
            Info info = new Info(Constant.WRONG_PASSWORD, "密码错误，请重新登录");
            response.setInfo(info);
        }
        return  response;
    }


    public Response register(User user) {
        Response response = new Response();
        if (mapper.getUserByName(user.getName()) != null) {
            Info info = new Info(Constant.REGISTERED_REPEAT, "用户已注册，请直接登录");
            response.setInfo(info);
            return response;
        }
        try {
            Token token = new Token();
            user.setToken(token.getTokenStr());
            user.setOutDate(DateHelper.getOutDate(10));
            mapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            Info info = new Info(Constant.REGISTER_FAILED, "注册失败，请稍后重试");
            response.setInfo(info);
            return response;
        }
        Info info = new Info(Constant.REGISTER_SUCCESS, "注册成功");
        User tmpUser = mapper.getUserByName(user.getName());
        String tokenStr = tmpUser.getToken();
        int usrId = user.getId();
        UserInfo userInfo = new UserInfo(tokenStr, usrId);
        response.setInfo(info);
        response.setData(userInfo);
        return response;
    }
    //TODO 其他业务逻辑
}
