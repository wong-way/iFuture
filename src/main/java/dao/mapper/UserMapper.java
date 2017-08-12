package dao.mapper;

import dao.entity.User;

/**
 * Created by Jaho on 2017/5/8.
 */

public interface UserMapper {

    public User getUserById(int id);

    public void insert(User user);

    public void delete(int id);

    public void update(User user);

}
