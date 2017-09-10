package controller;

import dao.entity.SchRoll;
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
import service.SchRollService;

import java.sql.Date;
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    OrderSerivce orderSerivce;
    @Autowired
    SchRollService service;

    /**
     *
     * @param usrId 用户id
     * @param proId 产品id
     * @param progress 订单进度
     * @param dataUrl 数据的链接
     * @return response
     */
    @ResponseBody
    @RequestMapping(value = "userApi/order/addTmp",method = RequestMethod.POST)
    public Response insertTmpOrder(int usrId, int proId,
                                   int progress, String dataUrl) {
        Response response;
        Date date = DateHelper.getOutDate(0);
        TmpOrder order = new TmpOrder(usrId, proId, progress, date, dataUrl, false);
        response = orderSerivce.insertTmpOrder(order);
        return response;
    }

    /**
     *
     * @param ordId 订单id
     * @return response
     */
    @ResponseBody
    @RequestMapping(value = "userApi/order/deleteTmp",method = RequestMethod.POST)
    public Response deleteTmpOrder(int ordId) {

        Response response = orderSerivce.deleteTmpOrder(ordId);
        return response;
    }

    /**
     *
     * @param ordId 订单id
     * @param toPay 应支付的价格
     * @param hasPay 已经支付的价格
     * @param usrId 用户id
     * @return response
     */
    @ResponseBody
    @RequestMapping(value = "userApi/order/addVld",method = RequestMethod.POST)
    public Response insertVldOrder(int ordId,int toPay,int hasPay,int usrId){
        Date date = DateHelper.getOutDate(0);
        VldOrder order = new VldOrder(ordId, toPay, hasPay, usrId, date);
        Response response = orderSerivce.insertVldOrder(order);
        return response;

    }

    /**
     *
     * @param ordId 订单id
     * @return response
     */
    @ResponseBody
    @RequestMapping(value = "userApi/order/getTmp",method = RequestMethod.POST)
    public Response getTmp(int ordId){
        Response response = orderSerivce.getTmporder(ordId);
        return  response;
    }

    /**
     *
     * @param ordId 订单id
     * @return response
     */
    @ResponseBody
    @RequestMapping(value = "userApi/order/getVld",method = RequestMethod.POST)
    public Response getVld(int ordId){
        Response response = orderSerivce.getVldorder(ordId);
        return  response;
    }

    /**
     *
     * @param usrId 用户id
     * @param school 学校
     * @param college 学院
     * @param major 专业
     * @param aim 目标
     * @param mail 邮箱
     * @param stuNo 学生号
     * @param idNo 身份证号
     * @return response
     */
    @RequestMapping(value = "userApi/roll/insert", method = RequestMethod.POST)
    public Response insertRoll(int usrId, String school, String college, String major,
                               String aim, String mail, String stuNo, String idNo) {

        SchRoll roll = new SchRoll(usrId, school, college, major, aim, mail, stuNo, idNo);
        Response response = service.insert(roll);
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @param school 学校
     * @param college 学院
     * @param major 专业
     * @param aim 目标
     * @param mail 邮箱
     * @param stuNo 学生号
     * @param idNo 身份证号
     * @return response
     */
    @RequestMapping(value = "userApi/roll/update", method = RequestMethod.POST)
    public Response updateRoll(int usrId, String school, String college, String major,
                               String aim, String mail, String stuNo, String idNo) {

        SchRoll roll = new SchRoll(usrId, school, college, major, aim, mail, stuNo, idNo);
        Response response = service.update(roll);
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @return
     */
    @RequestMapping(value = "userApi/roll/delete", method = RequestMethod.POST)
    public Response deleteRoll(int usrId) {
        Response response = service.delete(usrId);
        return response;
    }

}
