package controller;

import dto.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DELL on 2017-08-29.
 */
@RestController
@RequestMapping("/")
public class OrderController {
    //TODO 完善订单控制器的编写
    @ResponseBody
    @RequestMapping("order/add")
    public Response insertTmpOrder() {
        Response response = new Response();
        return response;
    }
}
