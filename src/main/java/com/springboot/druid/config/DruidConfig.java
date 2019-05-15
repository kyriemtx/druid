package com.springboot.druid.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: txma
 * @Date: 2019/5/15 20:28
 * @Version: 1.0
 */
@SuppressWarnings("all")
@Configuration
public class DruidConfig {

    /**
     * 返回监控注册的Servlet对象
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServletDemo(){
         ServletRegistrationBean srb = new ServletRegistrationBean(new StatViewServlet(),"/mtx/druid/*");
        //添加白名单
        srb.addInitParameter("allow","127.0.0.1");
        //添加黑名单
        srb.addInitParameter("deny"," 192.168.43.130");
        // 添加控制台管理用户
        srb.addInitParameter("loginUsername", "kyrie");
        srb.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据
        srb.addInitParameter("resetEnable", "false");
        return  srb;
    }

    /**
     * 配置服务过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean statFilterDemo(){
        FilterRegistrationBean frb = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        frb.addUrlPatterns("/*");
        // 忽略过滤格式
        return  frb;
    }

}
