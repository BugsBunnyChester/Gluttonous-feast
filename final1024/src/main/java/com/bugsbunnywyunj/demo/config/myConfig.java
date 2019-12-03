package com.bugsbunnywyunj.demo.config;

import com.bugsbunnywyunj.demo.component.loginHandlerInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@Configuration
public class myConfig implements WebMvcConfigurer {
    //注册视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/wyj").setViewName("/test");
//        registry.addViewController("/confirm_order.html").setViewName("/login");
//
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/article_read.html").setViewName("article_read");
        registry.addViewController("/category.html").setViewName("category");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/detailsp.html").setViewName("detailsp");
        registry.addViewController("/cart.html").setViewName("cart");
        registry.addViewController("/list.html").setViewName("list");
        registry.addViewController("/confirm_order").setViewName("/confirm_order");




    }
    //注册拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new loginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("index.html","/","/user/login");//除了列出的这些全部拦截

    }

//    @Override
//    public  void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/").addResourceLocations("classpath:/");
//    }

}
