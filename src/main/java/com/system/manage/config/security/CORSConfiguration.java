//package com.system.manage.config.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * @author Created by lq
// * @version jdk1.8
// * @description
// */
//@Configuration
//public class CORSConfiguration extends WebMvcConfigurationSupport {
//
//    /*
//     * 这里主要为了解决跨域问题,所以重写addCorsMappings方法
//     */
//    @Override
//    protected void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
//                .allowedHeaders("*")
//                .exposedHeaders("access-control-allow-headers",
//                        "access-control-allow-methods",
//                        "access-control-allow-origin",
//                        "access-control-max-age",
//                        "X-Frame-Options")
//                .allowCredentials(false).maxAge(3600);
//        super.addCorsMappings(registry);
//    }
//}