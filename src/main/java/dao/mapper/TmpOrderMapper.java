package dao.mapper;

import dao.entity.TmpOrder;

import java.util.List;

/**
 * Created by DELL on 2017-08-14.
 */
public interface TmpOrderMapper {
    void insert(TmpOrder order);

    void update(TmpOrder order);

    void delete(int id);

    List<TmpOrder> getOrderByUsrId(int usrId);


}
