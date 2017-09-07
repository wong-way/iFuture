package service;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import dao.entity.CrdRecord;
import dao.entity.TmpOrder;
import dao.entity.VldOrder;
import dao.mapper.*;
import dto.OrderInfo;
import dto.response.Info;
import dto.response.Response;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderSerivce {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TmpOrderMapper tmpMapper;
    @Autowired
    VldOrderMapper vldMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    SchRollMapper schRollMapper;
    @Autowired
    CrdRecordMapper crdRecordMapper;

    /**
     * @param order 临时订单
     * @return response
     */
    public Response insertTmpOrder(TmpOrder order) {
        System.out.println(order.getUsrId());
        Response response = new Response();
        try {
            if (userMapper.getUserById(order.getUsrId()) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户不存在"));
                return response;
            }
            if (schRollMapper.getRollById(order.getUsrId()) == null) {
                response.setInfo(new Info(Constant.ROOL_NOT_EXIST, "用户资料未完善"));
                return response;
            }
            //TODO 确定信用分数的判定是由人工来做还是以分数来做
            if (productMapper.getProductById(order.getProId()) == null) {
                response.setInfo(new Info(Constant.PRODUCT_NOT_EXIST, "产品不存在"));
                return response;
            }
            tmpMapper.insert(order);
            response.setInfo(new Info(Constant.TMPORDER_INSERT_SUCCESS, "创建临时订单成功"));


        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.TMPORDER_INSERT_ERROR, "创建临时订单异常，请稍后重试"));
        }
        return response;
    }

    /**
     * @param id       订单id
     * @param progress 进度
     * @return response
     */

    public Response updateTmpOrder(int id, int progress) {
        Response response = new Response();
        try {
            TmpOrder tmp = tmpMapper.get(id);
            if (tmp == null) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            tmp.setProgress(progress);
            tmpMapper.update(tmp);
            response.setInfo(new Info(Constant.TMPORDER_UPDATE_SUCCESS, "更新临时订单成功"));

        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.TMPORDER_UPDATE_ERROR, "更新临时订单异常，请稍后重试"));
        }

        return response;
    }

    /**
     * @param ordId 订单id
     * @return response
     */
    public Response setPayed(int ordId) {
        Response response = new Response();
        try {
            TmpOrder tmp = tmpMapper.get(ordId);
            if (tmp == null) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            tmp.setPayed(true);
            tmpMapper.update(tmp);
            response.setInfo(new Info(Constant.TMPORDER_UPDATE_SUCCESS, "更新临时订单成功"));

        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.TMPORDER_UPDATE_ERROR, "更新临时订单异常，请稍后重试"));
        }
        return response;
    }

    /**
     * @param id
     * @return response
     */

    public Response deleteTmpOrder(int id) {
        Response response = new Response();
        try {
            if (tmpMapper.get(id) == null) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            tmpMapper.delete(id);
            response.setInfo(new Info(Constant.TMPORDER_DELETE_SUCCESS, "订单删除成功"));


        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.TMPORDER_DELETE_ERROR, "订单删除异常，请稍后重试"));
        }

        return response;
    }

    /**
     * @param id
     * @return response
     */
    public Response getTmporder(int id) {
        Response response = new Response();
        try {
            if (tmpMapper.get(id) == null) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            response.setData(tmpMapper.get(id));
            response.setInfo(new Info(Constant.TMPORDER_GET_SUCCESS, "获取订单成功"));
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.TMPORDER_GET_ERROR, "获取订单异常，请稍后重试"));
        }

        return response;
    }

    /**
     * @return response
     */

    public Response getAllTmporder() {
        Response response = new Response();
        try {
            response.setData(tmpMapper.getAllOrder());
            response.setInfo(new Info(Constant.TMPORDER_GET_SUCCESS, "获取订单成功"));
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.TMPORDER_GET_ERROR, "获取订单异常，请稍后重试"));
        }
        return response;
    }

    /**
     * @param order 正式订单
     * @return response
     */

    public Response insertVldOrder(VldOrder order) {
        Response response = new Response();
        try {
            if (tmpMapper.get(order.getOrdId()) == null) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            if (!tmpMapper.get(order.getOrdId()).isPayed()) {
                response.setInfo(new Info(Constant.MONEY_NOT_PAYED, "支付尚未完成"));
                return response;
            }
            if (userMapper.getUserById(order.getUsrId()) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            vldMapper.insert(order);
            response.setInfo(new Info(Constant.VLDORDER_INSERT_SUCCESS, "正式订单添加成功"));


        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.VLDORDER_INSERT_ERROR, "订单添加异常，请稍后重试"));
        }

        return response;
    }

    /**
     * @param ordId 订单id
     * @return response
     */
    public Response deleteVldOrder(int ordId) {
        Response response = new Response();
        try {
            if (vldMapper.getOrder(ordId) == null) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            vldMapper.delete(ordId);
            response.setInfo(new Info(Constant.VLDORDER_DELETE_SUCCESS, "订单删除成功"));

        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.VLDORDER_DELETE_ERROR, "订单删除异常，请稍后重试"));
        }

        return response;
    }

    /**
     * @param ordId  订单id
     * @param hasPay 已经支付的金额
     * @return response
     */
    public Response updateVldOrder(int ordId, int hasPay) {
        Response response = new Response();
        try {
            VldOrder tmp = vldMapper.getOrder(ordId);
            if (tmp == null) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            tmp.setHasPay(hasPay);
            vldMapper.update(tmp);
            response.setInfo(new Info(Constant.TMPORDER_UPDATE_SUCCESS, "更新临时订单成功"));

        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.TMPORDER_UPDATE_ERROR, "更新临时订单异常，请稍后重试"));
        }

        return response;
    }


    /**
     *
     * @param ordId 订单id
     * @return response
     */
    public Response getVldorder(int ordId) {
        Response response = new Response();
        try {
            VldOrder order = vldMapper.getOrder(ordId);
            if (order == null) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            response.setData(order);
            response.setInfo(new Info(Constant.VLDORDER_GET_SUCCESS, "订单获取成功"));
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.VLDORDER_GET_ERROR, "订单获取异常，请稍后重试"));
        }

        return response;
    }

    /**
     *
     * @return resposne
     */

    public Response getAllVldOrder() {
        Response response = new Response();
        try {
            List<VldOrder> list = vldMapper.getAllOrder();
            response.setData(list);
            response.setInfo(new Info(Constant.VLDORDER_GET_SUCCESS, "订单获取成功"));

        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.VLDORDER_GET_ERROR, "订单获取异常，请稍后重试"));
        }

        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @return response
     */
    public Response getUserOrder(int usrId) {
        Response response = new Response();
        try {
            Map<String, List> map = new HashMap<String, List>();
            List<VldOrder> vldList = vldMapper.getAllOrder();
            List<TmpOrder> tmpList = tmpMapper.getAllOrder();
            if (vldList.size() + tmpList.size() == 0) {
                response.setInfo(new Info(Constant.ORDER_NOT_EXIST, "没有查到相关订单"));
                return response;
            }
            map.put("临时订单", vldList);
            map.put("正式订单", tmpList);
            response.setInfo(new Info(Constant.VLDORDER_GET_SUCCESS, "订单获取成功"));
            response.setData(map);

        } catch (Exception e) {
            response.setInfo(new Info(Constant.VLDORDER_GET_ERROR, "订单获取异常，请稍后重试"));
            e.printStackTrace();
        }

        return response;
    }
}
