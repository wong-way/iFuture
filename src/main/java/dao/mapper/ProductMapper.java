package dao.mapper;

import dao.entity.Product;

import java.util.List;

/**
 * Created by DELL on 2017-08-12.
 */
public interface ProductMapper {
    public void insert(Product product);

    public void update(Product product);

    public void delete(int id);

    public List<Product> getAllProduct();

    public Product getProductById(int id);

}
