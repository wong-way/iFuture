package service;
import dao.entity.TmpOrder;
import dao.entity.VldOrder;
import dto.response.Response;

public interface OrderSerivce {
    Response insertTmpOrder(TmpOrder order);

    Response updateTmpOrder(int id, int progress);

    Response deleteTmpOrder(int ordId);

    Response getTmporder(int ordId);

    Response getAllTmporder();



    Response insertVldOrder(VldOrder order);

    Response deleteVldOrder(int ordId);

    Response getVldorder(int ordId);

    Response getAllVldOrder();

    Response setPayed(int ordId);

    Response updateVldOrder(int ordId, int hasPay);

    Response getUserOrder(int usrId);

}