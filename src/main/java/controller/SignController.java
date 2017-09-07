package controller;

import dao.entity.User;
import dto.Token;
import dto.UserInfo;
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

    /**
     *
     * @param name 用户名
     * @param phone 电话
     * @param gender 性别
     * @param psw 密码
     * @return
     */
    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public Response register(@RequestParam String name, @RequestParam String phone,
                             @RequestParam Integer gender, @RequestParam String psw) {
        Response response ;
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setGender(gender);
        user.setPsw(psw);
        response = userService.register(user);
        return response;
    }

    /**
     *
     * @param name 用户名
     * @param psw 密码
     * @return response
     */
    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public Response login(@RequestParam String name, @RequestParam String psw) {
        Response response = userService.login(name, psw);
        return response;
    }
}

