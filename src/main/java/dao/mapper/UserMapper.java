package dao.mapper;

import dao.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jaho on 2017/5/8.
 */
@Component
public interface UserMapper {

    public User getUserById(int id);

    public void insert(User user);

    public void delete(int id);

    public void update(User user);

    public List<User> getAllUser();

}
