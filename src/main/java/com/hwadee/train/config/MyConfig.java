package com.hwadee.train.config;

import com.hwadee.train.converter.MyDateConverter;
import com.hwadee.train.interceptor.AdminAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//步骤一 添加一个配置类，并实现webmvcconfigurer
@Configuration //将一个普通类声明为配置类
public class MyConfig implements WebMvcConfigurer {

//    步骤二注册自定义拦截器
//// @Bean 的作用：声明这个方法返回一个bean实例，并把这个bean交给spring容器管理
   @Bean
    public AdminAuthInterceptor adminAuthInterceptor(){
        return new AdminAuthInterceptor();

    }

//    把自定义的拦截器添加到springmvc的拦截链中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminAuthInterceptor()).addPathPatterns("/admin/**.ad");
//        registry.addInterceptor(adminAuthInterceptor()).excludePathPatterns("/static");
    }

//注册自定义转换器
    @Bean
    public MyDateConverter findMyDateConverter(){
       return  new MyDateConverter();
    }

//添加自定义转换器
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(findMyDateConverter());
    }
}
