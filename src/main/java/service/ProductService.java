package service;

import dto.response.Response;

/**
 * Created by DELL on 2017-08-20.
 */
public interface ProductService {
    Response getAllProduct();
    Response getProductById(int id);
    Response getProductIntro();
}
