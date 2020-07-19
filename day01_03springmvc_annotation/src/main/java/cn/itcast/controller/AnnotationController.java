package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/annotation")
@SessionAttributes(value= {"username","password","age"},types=
        {String.class,Integer.class})//把数据存入到session域对象中
public class AnnotationController {
    /**
     * RequestParam注解
     * 属性:
     * 1. value：请求参数中的名称
     * 2. required：请求参数中是否必须提供此参数，默认值是true，必须提供
     *
     * @param name
     * @return
     */
    @RequestMapping("/requestParam")
    public String testRequestParam(@RequestParam(name = "username", required = true) String name) {
        System.out.println(name);
        return "success";
    }

    /**
     * RequestBody注解
     * 作用:
     * 用于获取请求体的内容（注意：get方法不可以）
     * 属性:
     * 1. required：是否必须有请求体，默认值是true
     *
     * @param body
     * @return
     */
    @RequestMapping(path = "/requestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping(path = "/PathVariable/{sid}")
    public String testPathVariable(@PathVariable("sid") String id) {
        System.out.println(id);
        return "success";
    }

    @RequestMapping(path = "/requestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String accept) {
        System.out.println(accept);
        return "success";
    }

    @RequestMapping(path = "/cookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie) {
        System.out.println(cookie);
        return "success";
    }

    /**
     * ModelAttribute使用方式1
     * @param user
     * @return
     */
//    @RequestMapping(path = "/modelAttribute")
//    public String testModelAttribute(User user) {
//        System.out.println(user);
//        return "success";
//    }
//
//    @ModelAttribute
//    private User getUser(String name, Integer age, Map<String, User> map){
//        User user = new User();
//        user.setName(name);
//        user.setAge(age);
//        user.setDate(new Date());
//        return user;
//    }

    /**
     * ModelAttribute使用方式2
     * @param user
     * @return
     */
    @RequestMapping(path = "/modelAttribute")
    public String testModelAttribute(@ModelAttribute("key") User user) {
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    private void getUser(String name, Integer age, Map<String, User> map){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setDate(new Date());
        map.put("key", user);
    }

    /**
     * SessionAttribute：用于多次执行控制器方法间的参数共享
     * 设置session数据
     * @return
     */
    @RequestMapping(path = "/setSessionAttribute")
    public String save(Model model) {
        System.out.println("向request域中保存数据");
        model.addAttribute("username", "root");
        model.addAttribute("password", "123");
        model.addAttribute("age", 20);
        return "success";
    }

    /**
     * 获取数据
     * @param modelMap
     * @return
     */
    @RequestMapping(path = "/getSessionAttribute")
    public String get(ModelMap modelMap) {
        System.out.println(modelMap.get("username") + ":" + modelMap.get("password") + ":" + modelMap.get("age"));
        return "result";
    }

    /**
     * 移除数据
     * @param status
     * @return
     */
    @RequestMapping(path = "/removeSessionAttribute")
    public String remove(SessionStatus status) {
        status.setComplete();
        return "success";
    }
}
























