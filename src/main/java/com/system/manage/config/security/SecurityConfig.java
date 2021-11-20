//package com.system.manage.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * @author Created by lq
// * @version jdk1.8
// * @description 有这个注解 EnableGlobalMethodSecurity， @PreAuthorize 才能有效
// * @date 2021/4/12 20:03
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Autowired
//    JwtAuthorizationTokenFilter authenticationTokenFilter;
//    @Autowired
//    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        // 添加token过滤器
//        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
//                // 凭证无效时的处理
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .accessDeniedHandler(jwtAccessDeniedHandler)
//                // 防止iframe 造成跨域
//                .and()
//                .headers()
//                .frameOptions()
//                .disable()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                // 允许匿名访问
//                .antMatchers(HttpMethod.OPTIONS, "/**").anonymous()
//                // 放行静态资源
//                .antMatchers(
//                        HttpMethod.GET,
//                        "/*.html","/*.jsp","/**/*.jsp",
//                        "/**/*.html",
//                        "/**/*.css","/css/**","/js/**","/images/**","/static/**",
//                        "/**/*.js","/*.ico",
//                        "/webSocket/**"
//                ).permitAll()
//                // 放行swagger
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/swagger-resources/**").permitAll()
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("/*/api-docs").permitAll()
//                // 放行文件访问
//                .antMatchers("/file/**").permitAll()
//                .antMatchers("/front/**").permitAll()
//                // 放行druid
//                .antMatchers("/druid/**").permitAll()
//                .antMatchers("/user/**").permitAll()
//                // 所有请求都需要认证
//                .anyRequest().authenticated()
//                .and()
//                // 禁用 CSRF
//                .csrf().disable()
//                // 不使用session，此策略 使得 每次请求都要自行处理权限问题（往SecurityContextHolder.context中添加和查询Authentication）
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // 禁用缓存
//        httpSecurity.headers().cacheControl();
//        // 允许跨域访问
//        httpSecurity.cors();
//    }
//}
//
