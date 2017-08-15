import dao.entity.ExeClaims;
import dao.mapper.ExeClaimsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

/**
 * Created by DELL on 2017-08-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml"})
public class ExeClaimsTest {

    @Autowired
    private ExeClaimsMapper mapper;
    @Test
    public void testInsert() throws Exception {
        ExeClaims claims = new ExeClaims();
        claims.setUsrId(1001);
        java.util.Date date=new java.util.Date();

        claims.setGenDate(new Date(date.getTime()));
        claims.setProgress(1);
        claims.setClmId(101);
        claims.setToOff(500);
        claims.setHasOff(1000);
        mapper.insert(claims);

    }

    @Test
    public void testUpdate() {
        ExeClaims claims = new ExeClaims();
        claims.setClmId(101);
        claims.setProgress(2);
        claims.setToOff(700);
        claims.setHasOff(1000);
        mapper.update(claims);
    }
    @Test
    public void testGet(){
        ExeClaims claims =mapper.getClaimByUsrId(1001);
        System.out.println(claims.getProgress());
    }
    @Test
    public void testDelete(){
        mapper.delete(101);
    }


}
