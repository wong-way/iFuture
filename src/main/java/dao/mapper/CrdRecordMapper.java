package dao.mapper;

import dao.entity.CrdRecord;

/**
 * Created by DELL on 2017-08-11.
 */
public interface CrdRecordMapper {
    public void insert(CrdRecord record);

    public void update(CrdRecord record);

    public void delete(int id);

    public CrdRecord getUsrRecord(int usrId);

}
