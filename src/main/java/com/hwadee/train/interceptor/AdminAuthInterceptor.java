package com.hwadee.train.interceptor;

import com.hwadee.train.entity.Admin;
import com.hwadee.train.sessionpram.AdminSessionParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AdminAuthInterceptor implements HandlerInterceptor {
//    再拦截目标方法之前执行
//返回值false表示拦截成功，true表示放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AdminAuthInterceptor preHandle......");
        Object object = request.getSession().getAttribute(AdminSessionParam.ADMN_INFO);

        // 白名单：regist，doregist，login.ad，dologin.ad
        String servletPath = request.getServletPath();
        ArrayList<String> whitUrl = new ArrayList<String>();
        whitUrl.add("regist");
        whitUrl.add("doregist");
        whitUrl.add("login.ad");
        whitUrl.add("dologin.ad");
        whitUrl.add("logout.ad");

        for(String url:whitUrl){
            if(servletPath.endsWith(url)){
//                如果拦截的url在白名单中，直接放行
                return true;
            }
        }


        if(object!=null && object instanceof Admin){
            System.out.println("AdminAuthInterceptor preHandle..验证通过...");
            return true;
        }else{
            System.out.println("AdminAuthInterceptor preHandle..验证不通过...");
            response.sendRedirect("login.ad");
            return false;
        }
    }
//拦截方法之后，试图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle .......");
    }
//整个流程执行完之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
