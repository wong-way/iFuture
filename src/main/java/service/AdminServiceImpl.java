package service;

import dao.entity.Admin;
import dao.entity.User;
import dao.mapper.AdminMapper;
import dto.Token;
import dto.UserInfo;
import dto.response.Info;
import dto.response.Response;
import helper.DateHelper;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DELL on 2017-08-20.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper  mapper;

    /**
     *
     * @param id 管理员id
     * @return response
     */
    public Admin getAdminById(int id) {
        Admin admin = new Admin();
        try {
            admin = mapper.getAdminById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    /**
     *
     * @param name 管理员名字
     * @return response
     */
    public Admin getAdminByName(String name) {
        Admin admin = new Admin();
        try {
            admin = mapper.getAdminByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    /**
     *
     * @param name 管理员名字
     * @param psw 密码
     * @return response
     */
    public Response login(String name, String psw) {
        Admin admin = null;
        Response response = new Response();
        try{
            admin = mapper.getAdminByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (admin == null) {
            Info info = new Info(Constant.ADMIN_NOT_EXIST, "管理员不存在，请注册");
            response.setInfo(info);
        }
        if (admin.getPsw().equals(psw)) {
            String tokenStr =new Token().getTokenStr();
            admin.setToken(tokenStr);
            admin.setOutDate(DateHelper.getOutDate(10));
            mapper.update(admin);

            Info info = new Info(Constant.LOGIN_SUCCESS, "管理员登录成功");
            int usrId = admin.getId();
            UserInfo userInfo = new UserInfo(tokenStr, usrId);
            response.setInfo(info);
            response.setData(userInfo);

        }else{
            Info info = new Info(Constant.WRONG_PASSWORD, "密码错误，请重新登录");
            response.setInfo(info);
        }
        return  response;
    }

    /**
     *
     * @param admin 管理员信息
     * @return response
     */
    public Response register(Admin admin) {
        Response response = new Response();
        if (mapper.getAdminByName(admin.getName()) != null) {
            Info info = new Info(Constant.ADMIN_REGISTERED_REPEAT, "管理员已注册，请直接登录");
            response.setInfo(info);
            return response;
        }
        try {
            Token token = new Token();
            admin.setToken(token.getTokenStr());
            admin.setOutDate(DateHelper.getOutDate(10));
            mapper.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            Info info = new Info(Constant.ADMIN_REGISTER_FAILED, "管理员注册失败，请稍后重试");
            response.setInfo(info);
            return response;
        }
        Info info = new Info(Constant.ADMIN_REGISTER_SUCCESS, "注册成功");
        Admin tmpAdmin = mapper.getAdminByName(admin.getName());
        String tokenStr = tmpAdmin.getToken();
        int adminId = tmpAdmin.getId();
        UserInfo userInfo = new UserInfo(tokenStr, adminId);
        response.setInfo(info);
        response.setData(userInfo);
        return response;
    }
}
