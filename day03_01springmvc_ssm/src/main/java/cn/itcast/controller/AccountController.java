package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("AccountController findAll");
        List<Account> accountList = accountService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allAccount", accountList);
        modelAndView.setViewName("listAccount");

        return modelAndView;
    }

    @RequestMapping("/saveAccount")
    public ModelAndView saveAccount(Account account){
        System.out.println("AccountController saveAccount: " + account);
        accountService.saveAccount(account);

        List<Account> accountList = accountService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allAccount", accountList);
        modelAndView.setViewName("listAccount");

        return modelAndView;
    }
}
