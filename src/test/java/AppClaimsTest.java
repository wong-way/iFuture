import dao.entity.AppClaims;
import dao.mapper.AppClaimsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

/**
 * Created by DELL on 2017-08-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml"})
public class AppClaimsTest {
    @Autowired
    AppClaimsMapper mapper ;
    @Test
    public void insertTest(){
        java.util.Date date=new java.util.Date();

        AppClaims appClaims = new AppClaims();
        appClaims.setOrdId(1001);
        appClaims.setDataUrl("www.baidu.com");
        appClaims.setProgress(1);
        appClaims.setUsrId(1001);
        appClaims.setGenDate(new Date( date.getTime()));
        mapper.insert(appClaims);
    }
    @Test
    public void updateTest(){
        java.util.Date date=new java.util.Date();

        AppClaims appClaims = new AppClaims();
        appClaims.setOrdId(1002);
        appClaims.setDataUrl("www.baidu.com");
        appClaims.setProgress(1);
        appClaims.setGenDate(new Date( date.getTime()));
        appClaims.setId(1);
        mapper.update(appClaims);
    }
    @Test
    public void deleteTest(){
        mapper.delete(2);
    }
    @Test
    public void getTest() {
        AppClaims a = mapper.getAppClaimById(1);
        System.out.println(a.getOrdId());
    }
    @Test
    public void getAllTest() {
        List<AppClaims> list = mapper.getAllAppClaims();
        for (AppClaims a : list) {
            System.out.println(a.getOrdId());
        }
    }

    @Test
    public void getByUserId() {
        List<AppClaims> list=mapper.getAppClaimByUsrId(1001);
        for(AppClaims a:list){
            System.out.println(a.getOrdId());
        }
    }
}
