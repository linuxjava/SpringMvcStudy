package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class HelloController {
    @RequestMapping(path = "/hello")
    public String saySpringMvc(){
        System.out.println("SpringMvc起步");

        return "success";
    }

    /**
     * 只有一个参数时，可以省略
     * @return
     */
    @RequestMapping("testRequestMapping")
    public String testRequestMapping(){
        System.out.println("test testRequestMapping");
        return "success";
    }

    /**
     * method参数
     * @return
     */
    @RequestMapping(path = "testRequestMapping1", method = RequestMethod.POST)
    public String testRequestMapping1(){
        System.out.println("test testRequestMapping1");
        return "success";
    }

    /**
     * param、headers参数，请求中必须带username参数和Accept头
     * @return
     */
    @RequestMapping(path = "testRequestMapping2", params = {"username"}, headers = {"Accept"})
    public String testRequestMapping2(){
        System.out.println("test testRequestMapping2");
        return "success";
    }

}
