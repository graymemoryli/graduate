package com.hwadee.train.service;

import com.hwadee.train.entity.*;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface IUserService {


    public User findById(int id);
//    登录
    public  void createUser(User user);
    public String selectPwd(User user);
    public String selectSrc(User user);
    public String selectName(User user);
    public String selectStatus(User user);

    public boolean selectAccount(User user);
//    简历
    public void insertResume(Resume resume);
    public void insertAplly(Apply apply);
    public void deleteResume(String account);

//    个人信息
    public void inserteInfo(Info info);
    public void deleteInfo(String account);

//    查询招聘信息
    public ArrayList<CompanyInfo> selectNews();

    public void insertSend(SendResume sendResume);
}
