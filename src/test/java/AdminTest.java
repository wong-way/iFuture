import dao.entity.Admin;
import dao.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by DELL on 2017-08-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml"})
public class AdminTest {
    @Autowired
    private AdminMapper mapper;
    @Test
    public void testInsert() throws Exception {
        Admin admin = new Admin();
        admin.setName("HWay");
        admin.setPhone("18900000000");
        admin.setGender(1);
        admin.setType(1);
        admin.setMail("HWAY@163.com");
        mapper.insert(admin);
    }

    @Test
    public void testUpdate() {
        Admin admin = new Admin();
        admin.setName("HWay");
        admin.setPhone("18900000001");
        admin.setGender(1);
        admin.setType(1);
        admin.setMail("HWAY@163.com");
        admin.setId(1);
        mapper.update(admin);
    }
    @Test
    public void testDelete(){
        mapper.delete(2);
    }
    @Test
    public void testGet(){
        Admin a =mapper.getAdminByName("Hway");
        System.out.println(a.getName());
    }

}
