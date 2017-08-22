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
    @RequestMapping(value = "roll/get", method = RequestMethod.POST)
    public Response getSchRollById(int usrId) {
        Response response = service.getUserSchRoll(usrId);
        return response;
    }

    @RequestMapping(value = "roll/insert", method = RequestMethod.POST)
    public Response insertRoll(int usrId, String school, String college, String major,
                                   String aim, String mail, String stuNo, String idNo) {

        SchRoll roll = new SchRoll(usrId, school, college, major, aim, mail, stuNo, idNo);
        Response response = service.insert(roll);
        return response;
    }
    @RequestMapping(value = "roll/update", method = RequestMethod.POST)
    public Response updateRoll(int usrId, String school, String college, String major,
                                   String aim, String mail, String stuNo, String idNo) {

        SchRoll roll = new SchRoll(usrId, school, college, major, aim, mail, stuNo, idNo);
        Response response = service.update(roll);
        return response;
    }
    @RequestMapping(value = "roll/delete", method = RequestMethod.POST)
    public Response deleteRoll(int usrId) {
        Response response = service.delete(usrId);
        return response;
    }
}

