package dao.mapper;

import dao.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jaho on 2017/5/8.
 */

@Component
public interface UserMapper {
    User getUserById(int id);

    void insert(User user);

    void delete(int id);

    void update(User user);

    List<User> getAllUser();

    User getUserByName(String name);

    User getUserByToken(String token);

}
