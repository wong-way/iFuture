/**
 * Created by Jaho on 2017/5/8.
 */

import dao.entity.User;
import dao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml"})
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetUserById() throws Exception {
        int user_id = 1;
        User user = userMapper.getUserById(user_id);
        System.out.println(user.getName());
    }

    @Test
    public void testInsertUser() throws Exception{
        User user = new User();
        user.setName("Green");
        user.setPhone("18900000002");
        user.setGender(1);
        userMapper.insert(user);
    }
    @Test
    public void testUpdateUser() throws Exception{
        User user = new User();
        user.setId(1);
        user.setName("Mozart");
        user.setPhone("18900000002");
        user.setGender(1);
        userMapper.update(user);
    }
    @Test
    public void testDeleteUser() throws Exception{
        userMapper.delete(2);
    }



}
