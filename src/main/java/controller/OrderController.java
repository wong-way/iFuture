package controller;

import com.sun.org.apache.regexp.internal.RE;
import dao.entity.TmpOrder;
import dao.entity.VldOrder;
import dto.response.Response;
import helper.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.OrderSerivce;

import java.sql.Date;

/**
 * Created by DELL on 2017-08-29.
 */
@RestController
@RequestMapping("/")
public class OrderController {
    //TODO 完善订单控制器的编写
    @Autowired
    OrderSerivce orderSerivce;

    @ResponseBody
    @RequestMapping(value = "order/addTmp",method = RequestMethod.POST)
    public Response insertTmpOrder(int usrId, int proId,
                                   int progress, String dataUrl) {
        Response response;
        Date date = DateHelper.getOutDate(0);
        TmpOrder order = new TmpOrder(usrId, proId, progress, date, dataUrl, false);
        response = orderSerivce.insertTmpOrder(order);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "admin/order/updateTmp",method = RequestMethod.POST)
    public Response updateTmpProgress(int ordId, int progress) {
        Response response = orderSerivce.updateTmpOrder(ordId, progress);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "order/setPayed",method = RequestMethod.POST)
    public Response setPayed(int ordId) {

        Response response = orderSerivce.setPayed(ordId);
        return response;
    }
    @ResponseBody
    @RequestMapping(value = "admin/order/deleteTmp",method = RequestMethod.POST)
    public Response deleteTmpOrder(int ordId) {

        Response response = orderSerivce.deleteTmpOrder(ordId);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "admin/order/addVld",method = RequestMethod.POST)
    public Response insertVldOrder(int ordId,int toPay,int hasPay,int usrId){
        Date date = DateHelper.getOutDate(0);
        VldOrder order = new VldOrder(ordId, toPay, hasPay, usrId, date);
        Response response = orderSerivce.insertVldOrder(order);
        return response;

    }
    @ResponseBody
    @RequestMapping(value = "admin/order/updateVld",method = RequestMethod.POST)
    public Response updateVldProgress(int ordId, int hasPay) {
        Response response = orderSerivce.updateVldOrder(ordId, hasPay);
        return response;
    }
    @ResponseBody
    @RequestMapping(value = "admin/order/deleteVld",method = RequestMethod.POST)
    public Response deleteVldOrder(int ordId){
        Response response = orderSerivce.deleteVldOrder(ordId);
        return  response;
    }

    @ResponseBody
    @RequestMapping(value = "admin/order/getAllTmp", method = RequestMethod.GET)
    public Response getAllTmpOrder() {
        Response response = orderSerivce.getAllTmporder();
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "admin/order/getAllVld", method = RequestMethod.GET)
    public Response getAllVldOrder() {
        Response response = orderSerivce.getAllVldOrder();
        return response;
    }
    @ResponseBody
    @RequestMapping(value = "admin/order/getTmp",method = RequestMethod.POST)
    public Response getTmp(int ordId){
        Response response = orderSerivce.getTmporder(ordId);
        return  response;
    }
    @ResponseBody
    @RequestMapping(value = "admin/order/getVld",method = RequestMethod.POST)
    public Response getVld(int ordId){
        Response response = orderSerivce.getVldorder(ordId);
        return  response;
    }

    @ResponseBody
    @RequestMapping(value = "order/getUser", method = RequestMethod.POST)
    public Response getUsrOrder(int usrId) {
        Response response = orderSerivce.getUserOrder(usrId);
        return response;
    }
}
