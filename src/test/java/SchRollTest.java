import dao.entity.Product;
import dao.entity.SchRoll;
import dao.mapper.ProductMapper;
import dao.mapper.SchRollMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by DELL on 2017-08-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml"})
public class SchRollTest {
    @Autowired
    private SchRollMapper mapper;
    @Test
    public void testInsert(){
        SchRoll roll = new SchRoll();

        roll.setUsrId(1001);
        roll.setSchool("scu");
        roll.setCollege("sw");
        roll.setMail("scu@edu.com");
        roll.setMajor("se");
        roll.setStuNo("2015141463001");
        roll.setAim("考研");
        roll.setIdNo("510503199703070101");
        mapper.insert(roll);
    }

    @Test
    public void testUpdate() {
        SchRoll roll = new SchRoll();
        roll.setUsrId(1001);
        roll.setSchool("scu");
        roll.setCollege("sw");
        roll.setMail("scu@edu.com");
        roll.setMajor("se");
        roll.setAim("工作");
        roll.setStuNo("2015141463001");
        roll.setIdNo("510503199703079999");
        mapper.update(roll);
    }

    @Test
    public void testGet() {
        SchRoll roll = mapper.getRollById(1001);
        System.out.println(roll.getSchool());
    }

    @Test
    public void testDelete(){
        mapper.delete(1001);
    }

}
