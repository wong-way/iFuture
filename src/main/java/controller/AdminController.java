package controller;

import dao.entity.Admin;
import dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;


/**
 * Created by Hway on 2017-08-20.
 */
@RestController
@RequestMapping("/")
public class AdminController {
    @Autowired
    private AdminService service;

    /**
     *
     * @param name 姓名
     * @param phone 电话
     * @param gender 性别
     * @param type 管理类型
     * @param mail 管理员邮箱
     * @param psw 密码
     * @return response
     */
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

    /**
     *
     * @param name 管理员账号
     * @param psw 密码
     * @return response
     */
    @RequestMapping(value = "admin/login", method = RequestMethod.POST)
    public Response login(@RequestParam String name, @RequestParam String psw) {
        Response response = service.login(name, psw);
        return response;
    }
}
