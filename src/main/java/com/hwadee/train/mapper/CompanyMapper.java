package com.hwadee.train.mapper;

import com.hwadee.train.entity.Company;
import com.hwadee.train.entity.CompanyInfo;
import com.hwadee.train.entity.Info;
import com.hwadee.train.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

public interface CompanyMapper {


    //    添加用户
    @Insert("insert into company_user (account,password,name,src) values(#{account},#{password},#{name},#{src})")
    public void createUser(Company company);

    //    验证用户
    @Select("select password from company_user where account=#{account}")
//    @Select("select * from student where id=#{id}")
    public String selectPwd(Company company);
    @Select("select src from company_user where account=#{account}")
    public String selectSrc(Company company);
    @Select("select name from company_user where account=#{account}")
    public String selectName(Company company);
    @Select("select is_student from company_user where account=#{account}")
    public String selectStatus(Company company);

//    填写招聘信息
    @Insert("insert into company_info (account,name,location,job,job_type,job_salary,job_location,sta) values(#{account},#{name},#{location},#{job},#{job_type},#{job_salary},#{job_location},#{sta})")
    public void insertNews(CompanyInfo companyInfo);

//    搜索
    @Select("select student_account from send_resume where company_account = ${company_account}")
    public String search(String company_account);

    @Select("select * from send_resume where company_account = ${company_account}")
    public ArrayList<Info> selectSearch(String company_account);

//    签约
    @Update("update graduate_info set status = 1 where account = #{account}")
    public void updateSta(String account);

//    招聘
    @Update("update graduate_info set status = 2 where account = #{account}")
    public void updateSta2(String account);
}
