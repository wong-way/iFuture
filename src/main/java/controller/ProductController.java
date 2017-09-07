package controller;

import dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DELL on 2017-08-19.
 */
@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    ProductService service;

    /**
     *
     * @return response
     */
    @RequestMapping(value = "product/getAll", method = RequestMethod.GET)
    public Response getAllProduct(){
        Response response = service.getAllProduct();
        return response;
    }

    /**
     *
     * @param id 产品id
     * @return response
     */
    @RequestMapping(value = "product/get", method = RequestMethod.GET)
    public Response getProductById(int id) {
        Response response = service.getProductById(id);
        return response;
    }
}

