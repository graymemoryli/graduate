package com.hwadee.train.service;

import com.hwadee.train.entity.Admin;
import com.hwadee.train.entity.Apply;
import com.hwadee.train.entity.CompanyInfo;
import com.hwadee.train.entity.Info;

import java.util.ArrayList;
import java.util.List;

public interface IAdminSevice {
    public void creatAdmin(Admin admin);
    public String selectPwd(Admin admin);
    public String selectSrc(Admin admin);

//    数据分析

    public ArrayList<Info> selectSign();
    public ArrayList<Info> selectEmployment();
    public int selectNum(int sta);
    public ArrayList<Apply> selectApply();

//    学生管理
    public ArrayList<Info> selectInfo();

    public ArrayList<CompanyInfo> selectfabu();
    public void dofabu(String account);
}
