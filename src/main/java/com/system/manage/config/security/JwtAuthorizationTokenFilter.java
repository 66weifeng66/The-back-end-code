//package com.system.manage.config.security;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Created by lq
// * @version jdk1.8
// * @description
// * @date 2021/4/12 20:01
// */
//@Component
//public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Value("${jwt.token-start-with}")
//    private String tokenStartWith;
//    @Value("${jwt.header}")
//    private String tokenHeader;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        // 从header 中获取token
//        final String requestHeader = request.getHeader(this.tokenHeader);
//        String username = null;
//        String authToken = null;
//        // token 以 Bearer 为前缀，表示 Bearer Token ，区别于MAC Token
//        if (requestHeader != null && requestHeader.startsWith(tokenStartWith)) {
//            authToken = requestHeader.substring(7);
//            try {
//                // 从token中解析出 username
//                username = jwtTokenUtil.getUsernameFromToken(authToken);
//            } catch (ExpiredJwtException e) {
//            }
//        }
//
//        // 验证token
//        if (username != null && jwtTokenUtil.validateToken(authToken, username)) {
//            // 查询UserDetails
//            UserDetails userDetails = this.loadUserByUsername(username);
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//            // 在上下文中记录UserDetails
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//        chain.doFilter(request, response);
//    }
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        /* 此处查询数据库得到角色权限列表，这里可以用Redis缓存以增加查询速度 */
//        // 角色 需要以 ROLE_ 开头
//        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return new org.springframework.security.core.userdetails.User(username,  "", true, true,
//                true, true, authorityList);
//    }
//}
//
