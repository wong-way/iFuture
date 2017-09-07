package service;

import dao.entity.CrdRecord;
import dao.mapper.CrdRecordMapper;
import dao.mapper.UserMapper;
import dto.response.Info;
import dto.response.Response;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DELL on 2017-08-22.
 */
@Service("crdRecordService")
public class CrdRecordServiceImpl implements CrdRecordService {

    @Autowired
    CrdRecordMapper mapper;
    @Autowired
    UserMapper userMapper;

    /**
     *
     * @param usrId 用户id
     * @param record 信用记录
     * @return response
     */
    public Response addRecord(int usrId, String record) {
        Response response = new Response();
        try {
            if (userMapper.getUserById(usrId) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户不存在"));
                return response;
            }
            CrdRecord tmp = mapper.getUsrRecord(usrId);
            if (tmp == null) {
                mapper.insert(new CrdRecord(usrId, record));
            } else {
                tmp.setRecord(tmp.getRecord() + record);
                mapper.update(tmp);
            }
            response.setInfo(new Info(Constant.RECORD_INSERT_SUCCESS, "添加信用分数成功"));

        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.RECORD_INSERT_ERROR, "添加信用分数异常，请稍后再试"));
        }
        return response;
    }

    /**
     *
     * @param usrId
     * @return response
     */
    public Response delUsrRecord(int usrId) {
        Response response = new Response();
        try {
            if (userMapper.getUserById(usrId) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户不存在"));
                return response;
            }
            CrdRecord record = mapper.getUsrRecord(usrId);
            if (record == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户暂无信用分数记录"));
            } else {
                mapper.delete(usrId);
                response.setInfo(new Info(Constant.RECORD_DELETE_SUCCESS, "删除信用分数成功"));
            }
        } catch (Exception e) {
            response.setInfo(new Info(Constant.RECORD_DELETE_ERROR, "删除信用分数异常，请稍后再试"));
            e.printStackTrace();
        }
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @return response
     */

    public Response getUsrRecord(int usrId) {
        Response response = new Response();
        try {
            if (userMapper.getUserById(usrId) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户不存在"));
                return response;
            }
            CrdRecord record = mapper.getUsrRecord(usrId);
            if (record == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户暂无信用分数记录"));
            } else {
                response.setInfo(new Info(Constant.RECORD_GET_SUCCESS, "获取用户信用分数成功"));
                response.setData(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.RECORD_GET_ERROR, "获取用户信用分数异常，请稍后再试"));
        }
        return response;
    }
}
