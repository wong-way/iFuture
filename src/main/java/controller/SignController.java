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
        response = userService.register(user);
        return response;
    }

    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public Response login(@RequestParam String name, @RequestParam String psw) {
        Response response = userService.login(name, psw);
        return response;
    }
}

