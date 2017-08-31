package dao.mapper;

import dao.entity.TmpOrder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DELL on 2017-08-14.
 */
@Component
public interface TmpOrderMapper {
    void insert(TmpOrder order);

    void update(TmpOrder order);

    void delete(int id);

    List<TmpOrder> getOrderByUsrId(int usrId);

    TmpOrder get(int id);

    List<TmpOrder> getAllOrder();


}
