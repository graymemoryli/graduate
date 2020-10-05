package com.hwadee.train.controller;

import com.hwadee.train.entity.*;
import com.hwadee.train.service.IUserService;
import com.hwadee.train.sessionpram.AdminSessionParam;
import com.hwadee.train.sessionpram.InfoSessionParam;
import com.hwadee.train.sessionpram.ResumeSessionParam;
import com.hwadee.train.sessionpram.UserSessionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public IUserService userService;



    @RequestMapping("/getuser")
//    @ResponseBody
    public User findUser(int id){
        User user = userService.findById(id);
        return user;
    }
//    public String show(){
//        return "user";
//    }

    @RequestMapping("regist")
    public String register(){
        return "user/register";
    }

    @RequestMapping("doregist")
    public String doRegister(HttpServletRequest request, HttpServletResponse response, HttpSession session, MultipartFile uploadFile) throws IOException, ServletException {
        HttpSession session1 = request.getSession();

//        图片
        //存放上传文件的路径,应用的真实路径
        String dirPath=request.getServletContext().getRealPath("");
        dirPath += "static"+ File.separator+"user_ph";
        String path ="/"+ "static"+"/"+"user_ph";
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

        String user = request.getParameter("user");
        System.out.println(user);
        String name = request.getParameter("name");
        System.out.println(name);
        String pwd = request.getParameter("pwd");
        System.out.println(pwd);
        String num = "1";






        User user1 = new User();
        user1.setAccount(user);
        user1.setName(name);
        user1.setPassword(pwd);
        user1.setIs_student(num);

        user1.setSrc(img);

        userService.createUser(user1);

        return "redirect:login.ad";

    }

    @RequestMapping("/login.ad")
    public String login(){
        return "user/login";
    }


    //用户权限管理
//    后端url,添加一个后缀AD，前端添加后缀ht
    @RequestMapping("/dologin.ad")
    public String doLogin(User user,HttpSession httpSession){


        System.out.println(user.getAccount());
        String Pwd = userService.selectPwd(user);
        System.out.println(Pwd);

//        判断是否注册

//        判断用户密码是否正确
//            登陆成功到管理页面
//            用户登陆成功后将用户信息存储在session中

        if (Pwd.equals(user.getPassword())){
            String src = userService.selectSrc(user);
            user.setSrc(src);
            String name = userService.selectName(user);
            String status = userService.selectStatus(user);

            User user1 = new User();
            user1.setAccount(user.getAccount());
            user1.setPassword(user.getPassword());
            user1.setName(name);
            user1.setIs_student(status);
            user1.setSrc(src);

            System.out.println(user1.getAccount());
            System.out.println(user1.getPassword());
            System.out.println(user1.getName());
            System.out.println(user1.getIs_student());
            System.out.println(user1.getSrc());
            httpSession.setAttribute(UserSessionParam.USER_INFO,user1);

            return "redirect:userinfo.ad";
        }
        else {
            return "redirect:login.ad";
        }


    }


    @RequestMapping("/userinfo.ad")
    public ModelAndView viewAdmin(HttpSession httpSession, ModelAndView modelAndView){
//        其他页面从session中获得用户信息
        Object attribute = httpSession.getAttribute(UserSessionParam.USER_INFO);
        if (attribute==null){
//            没有用户返回到登录页面
            modelAndView.setViewName("user/login");

        }


        User user = (User) attribute;


        modelAndView.addObject("user",user);

        modelAndView.setViewName("user/userinfo");

        return modelAndView;


    }

    @RequestMapping("info.ad")
    public String write_info(){
        return "user/info";
    }

    @RequestMapping("doinfo")
    public ModelAndView doinfo(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
        Object attribute = httpSession.getAttribute(UserSessionParam.USER_INFO);
        if (attribute==null){
//            没有用户返回到登录页面
            modelAndView.setViewName("user/login");
            User user = (User) attribute;

        }
        User user = (User)attribute;
        System.out.println(user.getAccount());


        String name = request.getParameter("name");
        System.out.println(name);
        String sex = request.getParameter("sex");
        System.out.println(sex);
        String college = request.getParameter("college");
        System.out.println(college);
        String major = request.getParameter("major");
        System.out.println(major);
        int sta = Integer.parseInt(request.getParameter("sta"));
        System.out.println(sta);

        Info info = new Info();
        info.setAccount(user.getAccount());
        info.setName(name);
        info.setSex(sex);
        info.setCollege(college);
        info.setMajor(major);
        info.setSta(sta);

//        if(!userService.selectAccount(user)){
//            userService.inserteInfo(info);
//        }
        userService.inserteInfo(info);
        httpSession.setAttribute(InfoSessionParam.INFO,info);

        modelAndView.setViewName("user/userinfo");
        modelAndView.addObject("user",user);
        return modelAndView;


    }


    @RequestMapping("update.ad")
    public String update( HttpSession session){
        Object attribute = session.getAttribute(UserSessionParam.USER_INFO);
//        获取user的session
        User user = (User)attribute;
        String account = user.getAccount();
        userService.deleteInfo(account);
        return "redirect:info.ad";

    }














    @RequestMapping("/resume.ad")
    public String resume(){
        return "user/resume";
    }


//    填写简历
    @RequestMapping("/doresume")
    public ModelAndView doResume(HttpServletRequest request, HttpServletResponse response, HttpSession session,ModelAndView modelAndView) throws IOException, ServletException {

//        获取session中的信息
        HttpSession session1 = request.getSession();
        String name = request.getParameter("name");
        String job= request.getParameter("job");
        String self= request.getParameter("self");
        Object attribute = session.getAttribute(UserSessionParam.USER_INFO);
//        获取user的session
        User user = (User)attribute;
        String account = user.getAccount();

//        添加简历到指定的账号
        Resume resume = new Resume();
        resume.setAccount(account);
        resume.setName(name);
        resume.setJob(job);
        resume.setSelf(self);
        System.out.println(account+","+name+","+job+","+self);
        userService.insertResume(resume);

        ArrayList<Resume> resumes = new ArrayList<>();


        Resume resume1 = new Resume();
        resume1.setAccount(account);
        resume1.setName(name);;
        resume1.setJob(job);
        resume1.setSelf(self);
        resumes.add(resume1);


        modelAndView.addObject("resumelist",resumes);

        modelAndView.addObject("resume",resume1);

        modelAndView.setViewName("user/resume_list");

        return modelAndView;


//        return "resume_list";

    }
//    清空简历
    @RequestMapping("delet_resume")
    public ModelAndView delect_resume(HttpSession session,ModelAndView modelAndView){
        Object attribute = session.getAttribute(UserSessionParam.USER_INFO);
//        获取user的session
        User user = (User)attribute;
        String account = user.getAccount();
        userService.deleteResume(account);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/resume");
        return modelAndView;

    }
//    返回
    @RequestMapping("exit")
    public ModelAndView exit(HttpSession session,ModelAndView modelAndView){
        Object attribute = session.getAttribute(UserSessionParam.USER_INFO);
//        获取user的session
        User user = (User)attribute;

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/userinfo");
        return modelAndView;
    }

    @RequestMapping("apply.ad")
    public String aplly(){
        return "user/apply";
    }
    @RequestMapping("doapply")
    public ModelAndView doapply(HttpServletRequest request, HttpServletResponse response, HttpSession session,ModelAndView modelAndView){
        Object attribute = session.getAttribute(UserSessionParam.USER_INFO);
        User user = (User)attribute;
        String amount = user.getName();
//        String amount1 = request.getParameter("amount");
        String name = request.getParameter("name");
        int employment = Integer.parseInt(request.getParameter("employment"));
        String census = request.getParameter("census");

        System.out.println(amount+","+name+","+employment+","+census);
        Apply apply = new Apply();
        apply.setAmount(amount);
        apply.setName(name);
        apply.setEmployment(employment);
        apply.setCensus(census);


        System.out.println(apply.getAmount()+","+apply.getName()+","+apply.getEmployment()+","+apply.getCensus());


        userService.insertAplly(apply);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/userinfo");

        return modelAndView;


    }

    @RequestMapping("donews")
    public ModelAndView donew( ModelAndView modelAndView){

        modelAndView.addObject("newsList",userService.selectNews());

        modelAndView.setViewName("user/news");

        return modelAndView;
    }

    @RequestMapping("sendResume")
    public ModelAndView sendResume(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView ,HttpSession session){
        Object attribute = session.getAttribute(UserSessionParam.USER_INFO);
        Object attribute1 = session.getAttribute(InfoSessionParam.INFO);
        User user = (User)attribute;
        Info info = (Info)attribute1;
        String company = request.getParameter("account");
        String student = user.getAccount();
//        填写
        if (info ==null){
            modelAndView.setViewName("user/info");

            return modelAndView;
        }
        else {
            SendResume sendResume = new SendResume();
            sendResume.setAccount(student);
            sendResume.setCompany_account(company);
            sendResume.setName(info.getName());
            sendResume.setSex(info.getSex());
            sendResume.setCollege(info.getCollege());
            sendResume.setMajor(info.getMajor());



            userService.insertSend(sendResume);
            System.out.println(sendResume.getCompany_account()+","+sendResume.getAccount());
            modelAndView.addObject("user",user);
            modelAndView.setViewName("user/userinfo");

            return modelAndView;
        }



    }
}
