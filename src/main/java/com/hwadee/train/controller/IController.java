package com.hwadee.train.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IController {
    @RequestMapping("/index")
//    @ResponseBody//使用 @ResponseBody 那么return返回的为内容 ，否则就是跳转到JSP文件
//    http://localhost:8081/show
    public String index(){
        return "index";
    }
    @RequestMapping("admin_login")
    public String login_ad(){
        return "redirect:admin/login.ad";
    }
    @RequestMapping("student_login")
    public String login_st(){
        return "redirect:user/login.ad";
    }
    @RequestMapping("company_login")
    public String login_cp(){
        return "redirect:company/login.ad";
    }


}

