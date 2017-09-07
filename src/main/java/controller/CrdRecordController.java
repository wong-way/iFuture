package controller;

import dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.CrdRecordService;

/**
 * Created by DELL on 2017-08-22.
 */
@RestController
@RequestMapping("/")
public class CrdRecordController {
    @Autowired
    CrdRecordService service;

    /**
     *
     * @param usrId 用户的id
     * @param record 用户的信用分数记录
     * @return response
     */
    @RequestMapping(value = "record/add",method = RequestMethod.POST)
    public Response addRecord(int usrId, String record) {
        Response response = service.addRecord(usrId, record);
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @return response
     */
    @RequestMapping(value = "record/delete", method = RequestMethod.POST)
    public Response delRecord(int usrId) {
        Response response = service.delUsrRecord(usrId);
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @return response
     */
    @RequestMapping(value = "record/get", method = RequestMethod.POST)
    public Response getRecord(int usrId) {
        Response response = service.getUsrRecord(usrId);
        return response;
    }
}
