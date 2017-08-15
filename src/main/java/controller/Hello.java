package controller;

import dao.entity.User;
import dto.response.Info;
import dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HWAY on 2017/7/19.
 */
@RestController
@RequestMapping(value = "/Hello")
public class Hello {
    @Autowired
    private UserService service;
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "hello llx this is a test";
    }

    @ResponseBody
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        return "hello llx this is another test";
    }

    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public Map<String ,String> json(){
        Map<String ,String> name = new HashMap<String, String>();
        name.put("llx","2015141463001");
        name.put("jjh","2015141463002");
        name.put("hw", "2015141463003");
        return name;
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Response get(){

        List<User> list=null;
        try {
            Info info = new Info(1, "查找成功");
            list = service.getAllUser();
            Response<List<User>> response = new Response(info,list);
            return response;
        } catch (Exception e) {
            Info info = new Info(1, "查找失败");
            Response<List<User>> response = new Response(info,list);
            e.printStackTrace();
            return response;
        }
    }
}
