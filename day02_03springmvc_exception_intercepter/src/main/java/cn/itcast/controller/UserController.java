package cn.itcast.controller;

import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception {

        try {
            int i = 100 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询错误");
        }

        return "success";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor");
        return "interceptor";
    }
}


























