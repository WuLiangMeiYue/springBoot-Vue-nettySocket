package com.test;

import com.test.base.utils.ServletInterptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class ServletConfiugrations extends WebMvcConfigurationSupport{

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ServletInterptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/toLogin","/admin/login");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        super.addResourceHandlers(registry);
    }

//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
//    }
}
