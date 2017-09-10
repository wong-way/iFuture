package controller;

import dto.response.Info;
import dto.response.Response;
import helper.constant.Constant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

/**
 * Created by DELL on 2017-09-08.
 */
@RestController
@RequestMapping(value = "/")
public class FileController {
    /**
     *
     * @param httpServletRequest http的request
     * @param httpServletResponse http的response
     * @return response
     */
    @RequestMapping(value = "userApi/upload", method = RequestMethod.POST)
    public Response upload(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Integer usrId = (Integer) httpServletRequest.getAttribute("usrId");
        ServletContext context = httpServletRequest.getSession().getServletContext();
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(context);
        String filePath = context.getRealPath("/WEB-INF/UserFile/" + usrId);

        String fullFilePath = new String();
        File dir = new File(filePath);


        Response response = new Response();
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (resolver.isMultipart(httpServletRequest)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) httpServletRequest;
            Iterator<String> iterator = multiRequest.getFileNames();

            while (iterator.hasNext()) {
                MultipartFile file = multiRequest.getFile(iterator.next());
                String fileName = file.getOriginalFilename();
                fullFilePath = filePath + fileName;
                File newFile = new File(fullFilePath);
                try {
                    file.transferTo(newFile);

                } catch (Exception e) {
                    e.printStackTrace();
                    response.setInfo(new Info(Constant.FILE_UP_ERROR, "文件上传异常"));

                    return response;
                }
            }
        } else {
            response.setInfo(new Info(Constant.FILE_TYPE_ERROR, "文件存储错误"));
            return response;
        }
        response.setInfo(new Info(Constant.FILE_UP_SUCCESS, "文件上传成功"));
        return response;

    }

    /**
     *
     * @param httpServletResponse http的response
     * @param fileUrl 文件链接
     * @return resposne
     */

    @RequestMapping(value = "adminApi/download", method = RequestMethod.POST)
    public Response download(HttpServletResponse httpServletResponse, @RequestParam(value = "fileUrl") String fileUrl) {
        Response response = new Response();

        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/JavaScript");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setContentType("multipart/form-data");
        httpServletResponse.setHeader("Content-Disposition", "attachment;fileName=" + fileUrl);
        try {
            FileInputStream in = new FileInputStream(fileUrl);
            OutputStream out = httpServletResponse.getOutputStream();
            byte buffer[] = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
                in.close();
                out.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.FILE_NOT_FOUND, "没有找到文件"));
            return response;

        } catch (IOException e) {
            e.printStackTrace();
            response.setInfo(new Info(Constant.FILE_DOWN_ERROR, "文件下载异常"));
            return response;


        }
        response.setInfo(new Info(Constant.FILE_DOWN_SUCCESS, "文件下载成功"));
        return response;
    }
}
