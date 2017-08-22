package dao.mapper;

import dao.entity.CrdRecord;
import org.springframework.stereotype.Component;

/**
 * Created by DELL on 2017-08-11.
 */
@Component
public interface CrdRecordMapper {
    void insert(CrdRecord record);

    void update(CrdRecord record);

    void delete(int id);

    CrdRecord getUsrRecord(int usrId);

}
