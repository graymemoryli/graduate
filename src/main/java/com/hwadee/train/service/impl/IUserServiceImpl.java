package com.hwadee.train.service.impl;

import com.hwadee.train.entity.*;
import com.hwadee.train.mapper.UserMapper;
import com.hwadee.train.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(int id) {

        return userMapper.findById(id);

    }
    public  void createUser(User user){
        userMapper.createUser(user);
    }

    public String selectPwd(User user){
        return userMapper.selectPwd(user);
    }
    public String selectSrc(User user){
        return userMapper.selectSrc(user);
    }
    public String selectName(User user){
        return userMapper.selectName(user);
    }
    public String selectStatus(User user){
        return userMapper.selectStatus(user);
    }

    public boolean selectAccount(User user){
        return userMapper.selectAccount(user);
    }

    public void insertResume(Resume resume ){
        userMapper.insertResume(resume);
    }
    public void insertAplly(Apply apply){
        userMapper.insertAplly(apply);
    }
    public void deleteResume(String account){
        userMapper.deleteResume(account);
    }

//    个人基本信息
    public void inserteInfo(Info info){
        userMapper.inserteInfo(info);
    }
    public void deleteInfo(String account){
        userMapper.deleteInfo(account);
    }

//    查询招聘信息
    public ArrayList<CompanyInfo> selectNews(){
        return userMapper.selectNews();
    }

//
    public void insertSend(SendResume sendResume){
        userMapper.insertSend(sendResume);
    }

}
