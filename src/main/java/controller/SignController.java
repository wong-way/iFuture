package controller;

import dao.entity.User;
import dto.Token;
import dto.response.Info;
import dto.response.Response;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

/**
 * Created by DELL on 2017-08-18.
 */
@RestController
@RequestMapping("/")
public class SignController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public Response register(@RequestParam String name, @RequestParam String phone,
                             @RequestParam Integer gender, @RequestParam String psw) {
        Response response = new Response();
        int result;
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setGender(gender);
        user.setPsw(psw);
        result = userService.register(user);
        if (result == Constant.REGISTER_FAILED) {
            Info info = new Info(Constant.REGISTER_FAILED, "注册失败，请稍后重试");
            response.setInfo(info);
        } else if (result == Constant.REGISTERED_REPEAT) {
            Info info = new Info(Constant.REGISTERED_REPEAT, "用户已注册，请直接登录");
            response.setInfo(info);
        } else if (result == Constant.REGISTER_SUCCESS) {
            Info info = new Info(Constant.REGISTER_SUCCESS, "注册成功");
            String tokenStr = userService.getUserByName(name).getToken();
            Token token = new Token(tokenStr);
            response.setInfo(info);
            response.setData(token);
        }
        return response;
    }

    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public Response login(String name, String psw) {
        int result ;
        Response response = new Response();
        result = userService.login(name, psw);
        if (result == Constant.USER_NOT_EXIST) {
            Info info = new Info(Constant.USER_NOT_EXIST, "用户不存在，请注册");
            response.setInfo(info);
        } else if (result == Constant.WRONG_PASSWORD) {
            Info info = new Info(Constant.WRONG_PASSWORD, "密码错误，请重新登录");
            response.setInfo(info);
        }else if(result == Constant.LOGIN_SUCCESS){
            Info info = new Info(Constant.LOGIN_SUCCESS, "登录成功");
            String tokenStr = userService.getUserByName(name).getToken();
            Token token = new Token(tokenStr);
            response.setInfo(info);
            response.setData(token);

        }
        return response;


    }
}

