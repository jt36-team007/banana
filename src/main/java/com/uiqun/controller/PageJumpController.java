package com.uiqun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageJumpController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/forgetpwd")
    public String forgetpwd(){
        return "forgetpwd";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/daypresent")
    public String daypresent(){
        return "daypresent";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
