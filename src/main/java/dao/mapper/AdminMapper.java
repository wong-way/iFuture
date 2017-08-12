package dao.mapper;

import dao.entity.Admin;

/**
 * Created by DELL on 2017-08-11.
 */
public interface AdminMapper {
    public void insert(Admin admin);

    public void delete(int id);

    public void update(Admin admin);

    public Admin getAdminById(int id);

}
