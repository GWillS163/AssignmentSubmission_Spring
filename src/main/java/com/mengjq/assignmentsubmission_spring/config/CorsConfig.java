package com.mengjq.assignmentsubmission_spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
 // 不添加也ok， 需要在单个路由上进行添加注解即可
//    @Override
//    public void addCors
}
