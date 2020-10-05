package com.hwadee.train.service.impl;

import com.hwadee.train.entity.Company;
import com.hwadee.train.entity.CompanyInfo;
import com.hwadee.train.entity.Info;
import com.hwadee.train.mapper.CompanyMapper;
import com.hwadee.train.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ICompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public  void createUser(Company company){
        companyMapper.createUser(company);
    }

    public String selectPwd(Company company){
        return companyMapper.selectPwd(company);
    }

    public String selectSrc(Company company){
        return companyMapper.selectSrc(company);
    }

    public String selectName(Company company){
        return companyMapper.selectName(company);
    }

    public void insertNews(CompanyInfo companyInfo){
        companyMapper.insertNews(companyInfo);
    }

    public String search(String company_account){
        return companyMapper.search(company_account);
    }

    public ArrayList<Info> selectSearch(String company_account){
        return companyMapper.selectSearch(company_account);
    }

    public void updateSta(String account){
        companyMapper.updateSta(account);
    }
    public void updateSta2(String account){
        companyMapper.updateSta2(account);
    }

}
