import com.sun.javafx.collections.VetoableListDecorator;
import dao.entity.Product;
import dao.entity.VldOrder;
import dao.mapper.ProductMapper;
import dao.mapper.VldOrderMapper;
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
public class VldOrderTest {
    @Autowired
    private VldOrderMapper mapper;
    @Test
    public void testInsert(){
        VldOrder order = new VldOrder();
        order.setUsrId(1001);
        java.util.Date date=new java.util.Date();
        order.setGenDate(new Date(date.getTime()));
        order.setToPay(1000);
        order.setHasPay(100);
        order.setOrdId(2);
        mapper.insert(order);
    }

    @Test
    public void testUpdate() {
        VldOrder order = new VldOrder();
        order.setUsrId(1002);
        java.util.Date date=new java.util.Date();
        order.setGenDate(new Date(date.getTime()));
        order.setToPay(1000);
        order.setHasPay(400);

        order.setOrdId(1);
        mapper.update(order);
    }

    @Test
    public void testGet(){
        List<VldOrder> list = mapper.getOrderByUsrId(1001);
        for (VldOrder o : list) {
            System.out.println(o.getOrdId());
        }
    }
    @Test
    public void testDelete(){
        mapper.delete(2);
    }

}
