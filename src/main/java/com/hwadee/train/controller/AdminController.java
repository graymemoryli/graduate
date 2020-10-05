package com.hwadee.train.controller;

import com.hwadee.train.entity.*;
import com.hwadee.train.service.IAdminSevice;
import com.hwadee.train.sessionpram.AdminSessionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public IAdminSevice iAdminSevice;
    //    @RequestMapping("/register")
//    public String register(){
//        return "register";
//    }
//    @RequestMapping("/register")
//    public String register() {
//        return "admin/register";
//    }

//    @RequestMapping(value = "req1", method = RequestMethod.GET)
//    public void testRequest1() {
//        System.out.println("get");
//    }
//
//    @RequestMapping(value = "req2", method = RequestMethod.POST)
//    public void testRequest2() {
//        System.out.println("post");
//    }
//
//    @RequestMapping("req3")
//    public void testRequest3(String name, int age) {
//        System.out.println("name = " + name + " age = " + age);
//    }
//
//    @RequestMapping("req4")
//    public void testRequest4(String[] ids) {
//        System.out.println(Arrays.asList(ids));
//    }
//
//    @RequestMapping("req5")
//    public void testRequest5(Admin admin) {
//        System.out.println(admin.getName());
//    }
//
//    //接收参数名称与方法参数不一致。使用@RequesrParam绑定
//    @RequestMapping("req6")
//    public void testRequest6(@RequestParam("name") String adminName, int age) {
//        System.out.println("name = " + adminName + ",age = " + age);
//    }


    //        测试7：接收对象和封装类对象的参数
//    @RequestMapping("/req7")
//    public void testRequest7(Admin admin) {
//        System.out.println("name=" + admin.getName()
//                + ",pwd=" + admin.getPwd() + ",place=" + admin.getAdress().getPlace() + ",birthday " + admin.getBirthDay());
//    }

//    自定义日期转换器
//    1.定义一个转换类,并实现converter接口
//    2.在主配置文件声明转换器
//    3.引用转换器

    //    测试8
    @RequestMapping("req8")
    public void testRequest8(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        HttpSession session1 = request.getSession();
        String name = request.getParameter("name");
        System.out.println(name);
        String age = request.getParameter("age");
        System.out.println(age);
    }


    //对对话请求进行响应
//    1.相应字符串
    @RequestMapping("/resp1")
    @ResponseBody//响应一个字符串
    public String testResponse1() {
        return "helloworld";
    }

    //    响应json格式
//    步骤一添加包
//    @RequestMapping("/resp2")
//    @ResponseBody//响应一个或多个对象的json字符串
//    public Admin testResponse2() {
//        Admin admin = new Admin();
//        admin.setName("lkx");
//        admin.setPwd("123");
//        return admin;
//    }

    //    测试三
//    响应页面：并且填充数据
//    @RequestMapping("/resp3")
//    public String testResponse3(Map<String,Object> map) {
//        Admin admin = new Admin();
//        admin.setName("lkx");
//        admin.setPwd("123");
//
//        Adress address = new Adress();
//        address.setPlace("成都");
////        admin.setAdress(address);
//        map.put("admin",admin);
//        return "admin/admininfo";
//    }
//    @RequestMapping("/resp4")
//    public String testResponse4(Model model) {
//        Admin admin = new Admin();
//        admin.setName("lkx");
//        admin.setPwd("123");
//
//        Adress address = new Adress();
//        address.setPlace("成都");
////        admin.setAdress(address);
//        model.addAttribute("admin2",admin);
//        return "admin/admininfo";
//    }

//    //    测试3-1：
////    响应页面：默认转发
//    @RequestMapping("/resp5")
////    @ResponseBody 不添加@ResponseBody 注解，就是响应到一个页面
//    public String testResponse5(){
//        return "admin/register";
//    }

    @RequestMapping("/regist")
    public String register(){
        return "admin/register";
    }

    //    9.8
//上传文件
//    步骤
//    1.在jsp中上传文件对话框，并且在from中enctype="multipart/form-data
//    2.编写处理上传文件的代码，使用multipartFile接收上传文件信息
//    3.在web.xml里面DispatcherServlet设置<multipart-config>


    @RequestMapping("doregist")
    public String doRegister(HttpServletRequest request, HttpServletResponse response, HttpSession session,MultipartFile uploadFile) throws IOException, ServletException{
        HttpSession session1 = request.getSession();

//        图片
        //存放上传文件的路径,应用的真实路径
        String dirPath=request.getServletContext().getRealPath("");
        dirPath += "static"+File.separator+"admin_ph";
        String path ="/"+ "static"+"/"+"admin_ph";
        System.out.println("路径"+dirPath);

        File dir= new File(dirPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        //获得上传文件的文件名

        String fileName=uploadFile.getOriginalFilename();
//        保存文件名

        String img = path+"/"+fileName;


        //保存
        if(fileName!=null && fileName.trim()!="" && fileName.trim().length()>0){
            //保存
            uploadFile.transferTo(new File(dir,fileName));

        }

        String admin = request.getParameter("account");
        System.out.println(admin);
        String pwd = request.getParameter("password");
        System.out.println(pwd);



        Admin admin1 = new Admin();
        admin1.setAccount(admin);
        admin1.setPassword(pwd);
        admin1.setSrc(img);
        System.out.println(img);
        iAdminSevice.creatAdmin(admin1);

        return "redirect:login.ad";

    }


    @RequestMapping("/login.ad")
    public String login(){
        return "admin/login";
    }


//用户权限管理
//    后端url,添加一个后缀AD，前端添加后缀ht
    @RequestMapping("/dologin.ad")
    public String doLogin(Admin admin,HttpSession httpSession){


        System.out.println(admin.getAccount());
        String Pwd = iAdminSevice.selectPwd(admin);
        System.out.println(Pwd);

//        判断用户密码是否正确
//            登陆成功到管理页面
//            用户登陆成功后将用户信息存储在session中

            if (Pwd.equals(admin.getPassword())){
                String src = iAdminSevice.selectSrc(admin);
                admin.setSrc(src);
                System.out.println(admin.getAccount());
                System.out.println(admin.getPassword());
                System.out.println(admin.getSrc());

                httpSession.setAttribute(AdminSessionParam.ADMN_INFO,admin);
                return "redirect:admininfo.ad";
            }
            else {
                return "redirect:login.ad";
            }


    }
    @RequestMapping("admininfo.ad")
    public ModelAndView viewAdmin(HttpSession httpSession, ModelAndView modelAndView){
//        其他页面从session中获得用户信息
        Object attribute = httpSession.getAttribute(AdminSessionParam.ADMN_INFO);
        if (attribute==null){
//            没有用户返回到登录页面
            modelAndView.setViewName("admin/login");

            }


        Admin admin = (Admin) attribute;


        modelAndView.addObject("admin",admin);

        modelAndView.setViewName("admin/admininfo");

        return modelAndView;


    }

    @RequestMapping("/logout.ad")
    public String logout(HttpSession session){
        session.removeAttribute(AdminSessionParam.ADMN_INFO);
        return "redirect:login.ad";
    }




//    拦截器，是springMvc的，用于处理器进行预处理和后处理，多个拦截器形成拦截链
//    拦截器只是拦截控制方法，而不会拦截jsp，html，js等页面文件

//    步骤
//    1.添加一个拦截类，并实现拦截器
//    2.在mvc配置文件中配置拦截器


//数据统计
    @RequestMapping("analysis.ad")
    public String analysis(){
        return "admin/analysis/analysis";
    }
//    签约情况
    @RequestMapping("sign.ad")
    public ModelAndView sign(ModelAndView modelAndView){
        int sta = 1;
        int num = iAdminSevice.selectNum(sta);



        modelAndView.addObject("infoList",iAdminSevice.selectSign());

        modelAndView.setViewName("/admin/analysis/sign");

        return modelAndView;


    }
//      就业情况
    @RequestMapping("employment.ad")
    public ModelAndView amployment(ModelAndView modelAndView){
        modelAndView.addObject("infoList",iAdminSevice.selectEmployment());

        modelAndView.setViewName("/admin/analysis/employment");

        return modelAndView;
    }
//    就业率


    @RequestMapping("employ_rate.ad")
    public ModelAndView employRate(ModelAndView modelAndView){
        int num1 = 0;
        int num2 = 2;


        Rate rate = new Rate();
        float unemploy = iAdminSevice.selectNum(num1);
        float employ = iAdminSevice.selectNum(num2);

        float rare = employ/(employ+unemploy);

        rate.setEmploy(employ);
        rate.setUnemploy(unemploy);
        rate.setRare(rare);


        modelAndView.addObject("rate",rate);
        modelAndView.setViewName("/admin/analysis/rate");

        return modelAndView;
    }
//    离校管理
    @RequestMapping("leftSchool.ad")
    public ModelAndView left(ModelAndView modelAndView){
        modelAndView.addObject("leftList",iAdminSevice.selectApply());

        modelAndView.setViewName("admin/left/leftSchool");

        return modelAndView;


    }

//    办公管理
    @RequestMapping("managework.ad")
    public String work(){
        return "admin/manageWork/managework";
    }



//    毕业生管理
    @RequestMapping("managestudent.ad")
    public String student(){
        return "admin/manageStudent/managestudent";
    }


    @RequestMapping("doinfo")
    public ModelAndView doinfo(ModelAndView modelAndView){



        modelAndView.addObject("infoList",iAdminSevice.selectInfo());

        modelAndView.setViewName("admin/manageStudent/info");

        return modelAndView;



    }
    @RequestMapping("fabu")
    public ModelAndView fabu(ModelAndView modelAndView){

        modelAndView.addObject("infoList",iAdminSevice.selectfabu());

        modelAndView.setViewName("admin/manageWork/fabu");

        return modelAndView;

    }
    @RequestMapping("dofabu")
    public ModelAndView dofabu(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView ,HttpSession session){
        String company = request.getParameter("account");

        iAdminSevice.dofabu(company);

        Object attribute = session.getAttribute(AdminSessionParam.ADMN_INFO);
        Admin admin = (Admin) attribute;


        modelAndView.addObject("admin",admin);

        modelAndView.setViewName("admin/admininfo");

        return modelAndView;

    }


}


