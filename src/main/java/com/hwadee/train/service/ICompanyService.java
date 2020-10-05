package com.hwadee.train.service;

import com.hwadee.train.entity.Company;
import com.hwadee.train.entity.CompanyInfo;
import com.hwadee.train.entity.Info;
import com.hwadee.train.entity.User;

import java.util.ArrayList;

public interface ICompanyService {

    public  void createUser(Company company);
    public String selectPwd(Company company);
    public String selectSrc(Company company);
    public String selectName(Company company);

    public void insertNews(CompanyInfo companyInfo);

    public String search(String company_account);
    public ArrayList<Info> selectSearch(String company_account);
    public void updateSta(String account);
    public void updateSta2(String account);
}
