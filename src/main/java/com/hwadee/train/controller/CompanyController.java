package com.hwadee.train.controller;

import com.hwadee.train.entity.Company;
import com.hwadee.train.entity.CompanyInfo;
import com.hwadee.train.entity.User;
import com.hwadee.train.service.ICompanyService;
import com.hwadee.train.sessionpram.CompanySessionParam;
import com.hwadee.train.sessionpram.UserSessionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("company")
public class CompanyController {

    @Autowired
    public ICompanyService iCompanyService;

    @RequestMapping("regist")
    public String register(){
        return "company/register";
    }


    @RequestMapping("doregist")
    public String doRegister(HttpServletRequest request, HttpServletResponse response, HttpSession session, MultipartFile uploadFile) throws IOException, ServletException {
        HttpSession session1 = request.getSession();

//        图片
        //存放上传文件的路径,应用的真实路径
        String dirPath=request.getServletContext().getRealPath("");
        dirPath += "static"+ File.separator+"company_ph";
        String path ="/"+ "static"+"/"+"company_ph";
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

        String user = request.getParameter("account");
        System.out.println(user);
        String name = request.getParameter("name");
        System.out.println(name);
        String pwd = request.getParameter("password");
        System.out.println(pwd);
        String num = "1";







        Company company = new Company();
        company .setAccount(user);
        company .setName(name);
        company .setPassword(pwd);
        company .setSrc(img);

        iCompanyService.createUser(company);

        return "redirect:login.ad";

    }

    @RequestMapping("/login.ad")
    public String login(){
        return "company/login";
    }


    @RequestMapping("/dologin.ad")
    public String doLogin(Company company,HttpSession httpSession){


        System.out.println(company.getAccount());
        String Pwd = iCompanyService.selectPwd(company);
        System.out.println(Pwd);

//        判断是否注册

//        判断用户密码是否正确
//            登陆成功到管理页面
//            用户登陆成功后将用户信息存储在session中

        if (Pwd.equals(company.getPassword())){
            String src = iCompanyService.selectSrc(company);
            company.setSrc(src);
            String name = iCompanyService.selectName(company);


            Company company1 = new Company();
            company1.setAccount(company.getAccount());
            company1.setPassword(company.getPassword());
            company1.setName(name);
            company1.setSrc(src);

            System.out.println(company1.getAccount());
            System.out.println(company1.getPassword());
            System.out.println(company1.getName());

            System.out.println(company1.getSrc());
            httpSession.setAttribute(CompanySessionParam.COMPANY_INFO,company1);

            return "redirect:companyinfo.ad";
        }
        else {
            return "redirect:login.ad";
        }


    }

    @RequestMapping("/companyinfo.ad")
    public ModelAndView viewcompany(HttpSession httpSession, ModelAndView modelAndView){
//        其他页面从session中获得用户信息
        Object attribute = httpSession.getAttribute(CompanySessionParam.COMPANY_INFO);
        if (attribute==null){
//            没有用户返回到登录页面
            modelAndView.setViewName("company/login");

        }



        Company company= (Company) attribute;

        modelAndView.addObject("company",company);

        modelAndView.setViewName("company/companyinfo");

        return modelAndView;


    }

    @RequestMapping("news.ad")
    public String news(){
        return "company/news";
    }

    @RequestMapping("donews")
    public ModelAndView donews(HttpServletRequest request, HttpServletResponse response, HttpSession session,ModelAndView modelAndView){

        Object attribute = session.getAttribute(CompanySessionParam.COMPANY_INFO);

        Company company = (Company)attribute;

        String account = company.getAccount();
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String job = request.getParameter("job");
        String job_type = request.getParameter("job_type");
        String job_salary = request.getParameter("job_salary");
        String job_location = request.getParameter("job_location");

        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setAccount(account);
        companyInfo.setName(name);
        companyInfo.setLocation(location);
        companyInfo.setJob(job);
        companyInfo.setJob_type(job_type);
        companyInfo.setJob_salary(job_salary);
        companyInfo.setJob_location(job_location);
        companyInfo.setSta(0);
        System.out.println(account+","+name);

        iCompanyService.insertNews(companyInfo);

        modelAndView.addObject("company",company);

        modelAndView.setViewName("company/companyinfo");

        return modelAndView;



    }

    @RequestMapping("search")
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response, HttpSession session,ModelAndView modelAndView){

        Object attribute = session.getAttribute(CompanySessionParam.COMPANY_INFO);

        Company company = (Company) attribute;

//      应聘人员


        modelAndView.addObject("searchList",iCompanyService.selectSearch(company.getAccount()));

        modelAndView.setViewName("company/search");

        return modelAndView;

    }

    @RequestMapping("sign")
    public ModelAndView sign(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView ,HttpSession session){



        Object attribute = session.getAttribute(CompanySessionParam.COMPANY_INFO);

        Company company = (Company)attribute;

        String account = request.getParameter("account");

        iCompanyService.updateSta(account);

        modelAndView.addObject("company",company);

        modelAndView.setViewName("company/companyinfo");

        return modelAndView;


    }


    @RequestMapping("zhaopin")
    public ModelAndView zhaopin(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView ,HttpSession session){



        Object attribute = session.getAttribute(CompanySessionParam.COMPANY_INFO);

        Company company = (Company)attribute;

        String account = request.getParameter("account");

        iCompanyService.updateSta2(account);

        modelAndView.addObject("company",company);

        modelAndView.setViewName("company/companyinfo");

        return modelAndView;


    }

}
