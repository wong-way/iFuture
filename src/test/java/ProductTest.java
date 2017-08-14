import dao.entity.Product;
import dao.mapper.ProductMapper;
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
public class ProductTest {
    @Autowired
    private ProductMapper mapper;
    @Test
    public void testInsert(){
        Product product = new Product();
        product.setName("product1");
        product.setPayMthd(1);
        product.setPayAmnt(1000);
        product.setOffAmnt(1000);
        product.setType(1);
        product.setRisk(2);
        product.setCaption("This is Product 1");
        mapper.insert(product);
    }

    @Test
    public void testUpdate() {
        Product product = new Product();
        product.setName("product2");
        product.setPayMthd(1);
        product.setPayAmnt(1000);
        product.setOffAmnt(1000);
        product.setType(1);
        product.setRisk(2);
        product.setCaption("This is Product2");
        product.setId(1);
        mapper.update(product);
    }

    @Test
    public void testGetAll() {
        List<Product> list = mapper.getAllProduct();
        for (Product p : list) {
            System.out.println(p.getName());
        }
    }
    @Test
    public void testGet(){
        Product p = mapper.getProductById(1);
        System.out.println(p.getName());
    }
    @Test
    public void testDelete(){
        mapper.delete(2);
    }

}
