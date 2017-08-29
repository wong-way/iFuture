import dao.entity.Product;
import dao.entity.TmpOrder;
import dao.mapper.ProductMapper;
import dao.mapper.TmpOrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

/**
 * Created by DELL on 2017-08-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml"})
public class TmpOrderTest {
    @Autowired
    private TmpOrderMapper mapper;
    @Test
    public void testInsert(){
        TmpOrder order = new TmpOrder();
        order.setUsrId(1001);
        order.setProId(1);
        order.setPayed(true);
        order.setProgress(2);
        java.util.Date date=new java.util.Date();
        order.setGenDate(new Date(date.getTime()));
        order.setDataUrl("www.baidu.com/photo");
        mapper.insert(order);

    }

    @Test
    public void testUpdate() {
        TmpOrder order = new TmpOrder();

        order.setProId(1);
        order.setId(1);

        order.setDataUrl("www.baidu.com/photo222");
        mapper.update(order);

    }

    @Test
    public void testGetAll() {
        List<TmpOrder> order = mapper.getOrderByUsrId(1001);
        for (TmpOrder o : order) {
            System.out.println(o.getProId());
        }
    }
    @Test
    public void testDelete(){
        mapper.delete(1001);
    }
    @Test
    public void testGet(){
        TmpOrder order = mapper.get(1);

        if(order.isPayed()){
            System.out.println("yes");
        }
    }


}
