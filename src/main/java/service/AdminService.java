package service;

import dao.entity.Admin;
import dto.response.Response;

/**
 * Created by DELL on 2017-08-20.
 */
public interface AdminService {

    Admin getAdminById(int id);

    Admin getAdminByName(String name);

    Response login(String name, String psw);

    Response register(Admin admin);

}
