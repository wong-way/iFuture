package service;

import dao.entity.SchRoll;
import dao.mapper.SchRollMapper;
import dao.mapper.UserMapper;
import dto.response.Info;
import dto.response.Response;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DELL on 2017-08-21.
 */
@Service("schRollService")
public class SchRollServiceImpl implements SchRollService {

    @Autowired
    SchRollMapper mapper;
    @Autowired
    UserMapper userMapper;

    /**
     *
     * @param roll 学籍信息
     * @return response
     */
    public Response insert(SchRoll roll) {
        Response response = new Response();
        try {
            if (userMapper.getUserById(roll.getUsrId()) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户不存在"));
            }else{
                mapper.insert(roll);
                Info info = new Info(Constant.ROLL_INSERT_SUCCESS, "学历添加成功");
                response.setInfo(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.ROLL_INSERT_ERROR, "学历添加异常，请稍后重试"));
        }

        return response;
    }

    /**
     *
     * @param roll 学籍信息
     * @return response
     */

    public Response update(SchRoll roll) {
        Response response = new Response();
        try {
            if (userMapper.getUserById(roll.getUsrId()) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户不存在"));
            }else {
                mapper.update(roll);
                Info info = new Info(Constant.ROLL_UPDATE_SUCCESS, "学历修改成功");
                response.setInfo(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.ROLL_UPDATE_ERROR, "学历修改异常，请稍后重试"));
        }
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @return response
     */

    public Response delete(int usrId) {
        Response response = new Response();
        try {
            if (userMapper.getUserById(usrId) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户不存在"));
            } else {
                mapper.delete(usrId);
                response.setInfo(new Info(Constant.ROLL_DELETE_SUCCESS, "学历删除成功"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.ROLL_DELETE_ERROR, "学历删除异常，请稍后重试"));
        }
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @return response
     */

    public Response getUserSchRoll(int usrId) {
        Response response = new Response();
        SchRoll roll;
        try {
            if (userMapper.getUserById(usrId) == null) {
                response.setInfo(new Info(Constant.USER_NOT_EXIST, "用户不存在"));
            } else {
                roll = mapper.getRollById(usrId);
                response.setInfo(new Info(Constant.ROLL_GET_SUCCESS,"学历获取成功"));
                response.setData(roll);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.ROLL_GET_ERROR, "学历获取异常，请稍后重试"));
        }
        return response;
    }
}
