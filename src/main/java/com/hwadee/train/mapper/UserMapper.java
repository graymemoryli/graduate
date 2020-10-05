package com.hwadee.train.mapper;

import com.hwadee.train.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface UserMapper {
    //查找
    @Select("select * from student where id=#{id}")  //使用注解sql,就不能在xml里面添加相同的方法
    public User findById(int id);

//    添加用户
    @Insert("insert into student_user (account,password,name,is_student,src) values(#{account},#{password},#{name},#{is_student},#{src})")
    public void createUser(User user);

    //    验证用户
    @Select("select password from student_user where account=#{account}")
//    @Select("select * from student where id=#{id}")
    public String selectPwd(User user);
    @Select("select src from student_user where account=#{account}")
    public String selectSrc(User user);
    @Select("select name from student_user where account=#{account}")
    public String selectName(User user);

    @Select("select account from student_user where account=#{account}")
    public boolean selectAccount(User user);

    @Select("select is_student from student_user where account=#{account}")
    public String selectStatus(User user);
//简历填写
    @Insert("insert into resume(account,name,job,self) values(#{account},#{name},#{job},#{self})")
    public void insertResume(Resume resume);
//    删除简历
    @Delete("delete from resume where account =#{account}")
    public void deleteResume(String account);
//    填写离校申请表
    @Insert("insert into apply(amount,name,employment,census) values (#{amount},#{name},#{employment},#{census})")
    public void insertAplly(Apply apply);


//    填写学生基本信息
    @Insert("insert into graduate_info (account, name, sex, college, major, status) values (#{account} ,#{name} ,#{sex},#{college} ,#{major} ,#{sta})")
    public void inserteInfo(Info info);
//    修改学生基本信息
    @Delete("delete  from graduate_info where account =#{account}")
    public void deleteInfo(String account);


    @Select("select * from company_info where sta = 1")
    public ArrayList<CompanyInfo> selectNews();

//    投递简历

    @Insert("insert into send_resume (account,company_account, name, sex, college, major) values (#{account} ,#{company_account},#{name} ,#{sex},#{college} ,#{major})")
    public void insertSend(SendResume sendResume);
}
