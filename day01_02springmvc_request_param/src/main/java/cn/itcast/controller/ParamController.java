package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.Account1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username, int age){
        System.out.println(username + ":" + age);
        return "success";
    }


    @RequestMapping("/testParam1")
    public String testParam1(Account account){
        System.out.println(account.toString());
        return "success";
    }

    @RequestMapping("/testParam2")
    public String testParam2(Account1 account){
        System.out.println(account.toString());
        return "success";
    }
}
