package service;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import dao.entity.Product;
import dao.mapper.ProductMapper;
import dto.response.Info;
import dto.response.Response;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 2017-08-20.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper mapper;
    public Response getAllProduct() {
        Response response = new Response();
        try {
            List<Product> list = mapper.getAllProduct();
            response.setInfo(new Info(Constant.GET_PRODUCT_SUCCESS, "获取产品成功"));
            response.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.GET_PRODUCT_FAIL, "获取产品失败"));
        }
        return response;
    }

    public Response getProductById(int id) {
        Response response =new Response();
        try {
            Product product = mapper.getProductById(id);
            if (product == null) {
                response.setInfo(new Info(Constant.GET_PRODUCT_SUCCESS, "产品不存在"));
            }else{
                response.setInfo(new Info(Constant.GET_PRODUCT_SUCCESS, "获取产品成功"));
                response.setData(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.GET_PRODUCT_FAIL, "获取产品成功"));
        }
        return response;
    }

    public Response getProductIntro() {
        return null;
    }
}
