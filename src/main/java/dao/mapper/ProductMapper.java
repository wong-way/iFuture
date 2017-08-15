package dao.mapper;

import dao.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DELL on 2017-08-12.
 */
@Component
public interface ProductMapper {
    public void insert(Product product);

    public void update(Product product);

    public void delete(int id);

    public List<Product> getAllProduct();

    public Product getProductById(int id);

}
