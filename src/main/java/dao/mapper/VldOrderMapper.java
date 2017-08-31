package dao.mapper;

import dao.entity.VldOrder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DELL on 2017-08-14.
 */
@Component
public interface VldOrderMapper {
    void insert(VldOrder order);

    void update(VldOrder order);

    void delete(int ordId);

    List<VldOrder> getOrderByUsrId(int usrId);

    VldOrder getOrder(int ordId);

    List<VldOrder> getAllOrder();


}
