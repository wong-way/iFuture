package controller;

import dao.entity.SchRoll;
import dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.SchRollService;

/**
 * Created by DELL on 2017-08-20.
 */
@RestController
@RequestMapping(value = "/")
public class SchRollController {
    @Autowired
    SchRollService service;

    /**
     *
     * @param usrId 用户id
     * @return response
     */
    @RequestMapping(value = "adminApi/roll/get", method = RequestMethod.POST)
    public Response getSchRollById(int usrId) {
        Response response = service.getUserSchRoll(usrId);
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @param school 学校
     * @param college 学院
     * @param major 专业
     * @param aim 目标
     * @param mail 邮箱
     * @param stuNo 学生证号
     * @param idNo 身份证号
     * @return response
     */
    @RequestMapping(value = "adminApi/roll/insert", method = RequestMethod.POST)
    public Response insertRoll(int usrId, String school, String college, String major,
                                   String aim, String mail, String stuNo, String idNo) {

        SchRoll roll = new SchRoll(usrId, school, college, major, aim, mail, stuNo, idNo);
        Response response = service.insert(roll);
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @param school 学校
     * @param college 学院
     * @param major 专业
     * @param aim 目标
     * @param mail 邮箱
     * @param stuNo 学生证号
     * @param idNo 身份证号
     * @return response
     */
    @RequestMapping(value = "adminApi/roll/update", method = RequestMethod.POST)
    public Response updateRoll(int usrId, String school, String college, String major,
                                   String aim, String mail, String stuNo, String idNo) {

        SchRoll roll = new SchRoll(usrId, school, college, major, aim, mail, stuNo, idNo);
        Response response = service.update(roll);
        return response;
    }

    /**
     *
     * @param usrId 用户id
     * @return response
     */
    @RequestMapping(value = "adminApi/roll/delete", method = RequestMethod.POST)
    public Response deleteRoll(int usrId) {
        Response response = service.delete(usrId);
        return response;
    }
}

