package intercepter;

import com.google.gson.Gson;
import dao.entity.Admin;
import dao.entity.User;
import dao.mapper.AdminMapper;
import dto.response.Info;
import dto.response.Response;
import helper.DateHelper;
import helper.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by DELL on 2017-09-07.
 */
public class AdminIntercepter implements HandlerInterceptor {
    @Autowired
    AdminMapper adminMapper;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers","content-type,token");


        String token = httpServletRequest.getHeader("token");
        if(token == null){
            PrintWriter out = httpServletResponse.getWriter();
            Response res = new Response();
            res.setInfo(new Info(Constant.TOKEN_NOT_EXIST,"token不存在"));
            out.print(new Gson().toJson(res));
            return false;
        }

        Admin admin = adminMapper.getAdminByToken(token);
        // 用户不存在则返回错误信息
        if(admin == null){
            PrintWriter out = httpServletResponse.getWriter();
            Response res = new Response();
            res.setInfo(new Info(Constant.TOKEN_NOT_MATCHED,"管理员不存在"));
            out.print(new Gson().toJson(res));
            return false;
        }

        if(DateHelper.isExpired(admin.getOutDate())){
            PrintWriter out = httpServletResponse.getWriter();
            Response res = new Response();
            res.setInfo(new Info(Constant.TOKEN_EXPIRED_ERROR,"token已经失效"));
            out.print(new Gson().toJson(res));
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
