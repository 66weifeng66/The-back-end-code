//package com.system.manage.config.security;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author Created by lq
// * @version jdk1.8
// * @description
// * @date 2021/4/12 19:59
// */
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
//            throws IOException {
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "凭证无效");
//    }
//}
//
