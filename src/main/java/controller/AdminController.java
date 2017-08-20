package controller;

import dao.entity.Admin;
import dao.entity.User;
import dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;
import service.UserService;

/**
 * Created by DELL on 2017-08-20.
 */
@RestController
@RequestMapping("/")
public class AdminController {
    @Autowired
    private AdminService service;

    @RequestMapping(value = "admin/register", method = RequestMethod.POST)
    public Response register(@RequestParam String name, @RequestParam String phone,
                             @RequestParam Integer gender, @RequestParam int type,
                             @RequestParam String mail,@RequestParam String psw) {
        Response response ;
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPhone(phone);
        admin.setGender(gender);
        admin.setPsw(psw);
        admin.setType(type);
        admin.setMail(mail);
        response = service.register(admin);
        return response;
    }
    @RequestMapping(value = "admin/login", method = RequestMethod.POST)
    public Response login(@RequestParam String name, @RequestParam String psw) {
        Response response = service.login(name, psw);
        return response;
    }
}
