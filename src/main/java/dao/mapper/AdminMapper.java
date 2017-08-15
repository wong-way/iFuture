package dao.mapper;

import dao.entity.Admin;
import org.springframework.stereotype.Component;

/**
 * Created by DELL on 2017-08-11.
 */
@Component
public interface AdminMapper {
    void insert(Admin admin);

    void delete(int id);

    void update(Admin admin);

    Admin getAdminById(int id);

}
