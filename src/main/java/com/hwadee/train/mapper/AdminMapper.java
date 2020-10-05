package com.hwadee.train.mapper;

import com.hwadee.train.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;
import java.util.List;

public interface AdminMapper {
    //    添加用户
    @Insert("insert into  super_user (account,password,src) values(#{account},#{password},#{src})")
    public void createAdmin(Admin admin);
//    验证用户
    @Select("select password from super_user where account=#{account}")
//    @Select("select * from student where id=#{id}")
    public String selectPwd(Admin admin);
    @Select("select src from super_user where account =#{account}")
    public String selectSrc(Admin admin);


//    数据分析
//    签约情况
    @Select("select * from graduate_info where status = 1")
    public ArrayList<Info> selectSign();

//    计算人数
    @Select(" select count(*) from graduate_info where status = #{sta}")
    public int selectNum(int sta);
//    就业情况
    @Select("select * from graduate_info where status = 2")
    public ArrayList<Info> selectEmployment();

//    离校管理
    @Select("select * from apply ")
    public ArrayList<Apply> selectApply();

    @Select("select * from graduate_info")
    public ArrayList<Info> selectInfo();

//发布招聘
    @Select("select * from company_info where sta =0")
    public ArrayList<CompanyInfo> selectfabu();

    @Update("update company_info set sta = 1 where account = #{account}")
    public void dofabu(String account);
}
