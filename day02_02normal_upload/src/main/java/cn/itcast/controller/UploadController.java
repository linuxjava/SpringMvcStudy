package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UploadController {

    /**
     * 使用fileupload组件完成文件上传
     *
     * @param request
     * @return
     */
    @RequestMapping("/fileupload")
    public String normalUpload(HttpServletRequest request) throws Exception {
        // 上传的位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }

        // 解析request对象，获取上传文件项
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        // 解析request
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                //普通字段
            } else {
                //文件字段
                String filename = fileItem.getName();
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                // 完成文件上传
                fileItem.write(new File(realPath, filename));
            }
        }

        return "success";
    }

    /**
     * MultipartFile的名字需要与web中的name对应上
     * @param request
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @RequestMapping("/springMvcUpload")
    public String springMvcUpload(HttpServletRequest request, @RequestParam("upload") MultipartFile multipartFile) throws Exception {
        // 上传的位置
        String realPath = request.getSession().getServletContext().getRealPath("/springMvcUploads/");
        File file = new File(realPath);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }

        String filename = multipartFile.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 完成文件上传
        multipartFile.transferTo(new File(realPath, filename));

        return "success";
    }

    /**
     * 注意点
     * 1.需要为文件服务器设置发布的项目名(Application Context)，否则两个项目都会发布到tomcat的ROOT目录下
     * 2.需要在文件服务器上创建文件上传的目录
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @RequestMapping("/springMvcFileServer")
    public String springMvcFileServer(@RequestParam("upload") MultipartFile multipartFile) throws Exception {
        // 定义上传文件服务器路径
        String path = "http://localhost:9090/fileUploadServer/uploads/";

        String filename = multipartFile.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        // 创建客户端的对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        // 上传文件
        webResource.put(multipartFile.getBytes());

        return "success";
    }
}


























