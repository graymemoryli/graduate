package com.hwadee.train.service.impl;

import com.hwadee.train.entity.Admin;
import com.hwadee.train.entity.Apply;
import com.hwadee.train.entity.CompanyInfo;
import com.hwadee.train.entity.Info;
import com.hwadee.train.mapper.AdminMapper;
import com.hwadee.train.service.IAdminSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IAdminServiceImpl implements IAdminSevice {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public void creatAdmin(Admin admin){
        adminMapper.createAdmin(admin);

    }

    public String selectPwd(Admin admin){
        System.out.println("管理员密码"+admin.getAccount());
        return adminMapper.selectPwd(admin);
    }
    public String selectSrc(Admin admin){
        System.out.println("src = "+admin.getSrc());
        return adminMapper.selectSrc(admin);
    }


//    数据分析
        public ArrayList<Info> selectSign(){
        return adminMapper.selectSign();
    }
    public ArrayList<Info> selectEmployment(){
        return adminMapper.selectEmployment();
    }
    public int selectNum(int sta){
        return adminMapper.selectNum(sta);
    }


//    离校管理
    public ArrayList<Apply> selectApply(){
        return adminMapper.selectApply();
    }

//    学生管理
    public ArrayList<Info> selectInfo(){
        return adminMapper.selectInfo();
    }

    public ArrayList<CompanyInfo> selectfabu(){
        return adminMapper.selectfabu();
    }
    public void dofabu(String account){
        adminMapper.dofabu( account);
    }
}
