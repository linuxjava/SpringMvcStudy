package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/response")
public class ResponseController {
    /**
     * 返回String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setName("美美");
        user.setAge(30);
        // model对象(将对象放入request域中)
        model.addAttribute("user",user);
        return "success";
    }


    /**
     * 返回Void
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一种:转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //第二种:重定向,注WEB-INF下的文件是不能通过外部访问的
//        response.sendRedirect(request.getContextPath()+"/response.jsp");
//        //第三种：直接输出数据
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("测试，哈哈哈");

        return ;
    }

    /**
     * 返回ModelAndView，它其实和返回String逻辑差不多
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setName("美美123");
        user.setAge(30);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("success");
       return modelAndView;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        //转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        //(1)这里不需要添加项目名称，springmvc会自动加上
        //(2)重定向不能访问WEB-INF目录下的内容
        return "redirect:/response.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println(user);
        user.setName("肖");
        return user;
    }
}
























