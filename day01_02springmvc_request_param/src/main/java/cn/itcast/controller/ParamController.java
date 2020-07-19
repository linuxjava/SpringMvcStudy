package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.Account1;
import cn.itcast.domain.User;
import cn.itcast.domain.User1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ParamController {
    /**
     * 普通数据绑定
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username, int age){
        System.out.println(username + ":" + age);
        return "success";
    }

    /**
     * JavaBean绑定
     * @param account
     * @return
     */
    @RequestMapping("/testParam1")
    public String testParam1(Account account){
        System.out.println(account.toString());
        return "success";
    }

    /**
     * list和map绑定
     * @param account
     * @return
     */
    @RequestMapping("/testParam2")
    public String testParam2(Account1 account){
        System.out.println(account.toString());
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user1
     * @return
     */
    @RequestMapping("/testParam3")
    public String testParam3(User1 user1){
        System.out.println(user1.toString());
        return "success";
    }

    /**
     * 原生API
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println("session: " + session.toString());
        ServletContext servletContext = session.getServletContext();
        System.out.println("servletContext: " + servletContext.toString());
        return "success";
    }
}
