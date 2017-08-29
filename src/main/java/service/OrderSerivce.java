package service;
import dao.entity.TmpOrder;
import dao.entity.VldOrder;
import dto.response.Response;

public interface OrderSerivce {
    Response insertTmpOrder(TmpOrder order);

    Response updateTmpOrder(TmpOrder order);

    Response deleteTmpOrder(int ordId);

    Response getTmporder(int ordId);

    Response getAllTmporder();



    Response insertVldOrder(VldOrder order);

    Response deleteVldOrder(int ordId);

    Response getVldorder(int ordId);

    Response getAllVldOrder();



    Response getUserOrder(int usrId);

}