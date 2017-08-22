package service;

import dto.response.Response;

/**
 * Created by DELL on 2017-08-22.
 */
public interface CrdRecordService {
    Response addRecord(int usrId, String record);

    Response delUsrRecord(int usrId);
    Response getUsrRecord(int usrId);
}
