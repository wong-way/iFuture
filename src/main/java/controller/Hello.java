package controller;

import com.sun.javafx.collections.MappingChange;
import dto.response.Info;
import dto.response.Response;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HWAY on 2017/7/19.
 */
@RestController
@RequestMapping(value = "/Hello")
public class Hello {
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
        Info info = new Info(1, "查找成功");

        Map<String ,String> name = new HashMap<String, String>();
        name.put("llx","2015141463001");
        name.put("jjh","2015141463002");
        name.put("hw", "2015141463003");

        Response<Map> response = new Response<Map>(info,name);

        return response;
    }
}
