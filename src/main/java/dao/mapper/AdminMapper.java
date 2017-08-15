package dao.mapper;

import dao.entity.Admin;
import org.springframework.stereotype.Component;

/**
 * Created by DELL on 2017-08-11.
 */
@Component
public interface AdminMapper {
    public void insert(Admin admin);

    public void delete(int id);

    public void update(Admin admin);

    public Admin getAdminById(int id);

}
