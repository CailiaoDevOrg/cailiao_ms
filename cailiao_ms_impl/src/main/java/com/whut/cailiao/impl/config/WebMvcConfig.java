package com.whut.cailiao.impl.config;

import com.whut.cailiao.impl.interceptor.LoginIntercepter;
import com.whut.cailiao.impl.interceptor.PrivilegeIntercepter;
import com.whut.cailiao.impl.interceptor.ThreadLocalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by niuyang on 16/1/31.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ThreadLocalInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/wjt/**", "/news/**", "/main/**");
        registry.addInterceptor(new PrivilegeIntercepter()).addPathPatterns("/wjt/**", "/news/**", "/main/**", "/user/**", "/role/**", "/privilege/**");
        super.addInterceptors(registry);
    }
}
