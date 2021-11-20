package com.system.manage.controller;


//import com.system.manage.config.security.JwtTokenUtil;
import com.system.manage.constant.ResponseResult;
import com.system.manage.po.UserEntity;
import com.system.manage.service.impl.UserEntityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Created by lq
 * @version jdk1.8
 * @description
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class LoginController {

//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserEntityServiceImpl userEntityService;

    /**
     * 用户登录
     * @param user
     * @return
     */
//    @PostMapping("/login")
//    public ResponseResult<String> login(@RequestBody UserEntity user) {
//        /* 在这里验证用户名和密码，验证成功则生成token返回 */
//        if (user != null) {
//           boolean isLogin =  userEntityService.loginUser(user);
//           if (isLogin) {
//               return ResponseResult.HANDLE_SUCCESS(jwtTokenUtil.generateToken(user.getUsername()));
//           }
//        }
//        return ResponseResult.LOGIN_AUTH_FAILED();
//    }

    /**
     * 用户注册
     * @param user
     * @return
     */
//    @PostMapping("/register")
//    public ResponseResult<String> register(@RequestBody UserEntity user) {
//        log.info("用户注册：{}", user.toString());
//        boolean isRegister = userEntityService.registerUserEntity(user);
//        if (isRegister){
//            return ResponseResult.HANDLE_SUCCESS(jwtTokenUtil.generateToken(user.getUsername()));
//        }
//        return ResponseResult.HANDLE_FAILED();
//    }

    /**
     * 用户退出
     * @param request
     * @param request
     * @return
     */
//    @PostMapping("/logout")
//    public void logout(HttpServletRequest request) {
//        // 记录用户退出时间
//        userEntityService.recordLogoutTime(request);
//    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
//    @GetMapping("/getUserInfo")
//    public ResponseResult<UserEntity> getUserInfo(HttpServletRequest request) {
//        UserEntity userEntity = userEntityService.getUserInfo(request);
//        if (userEntity == null){
//           return ResponseResult.HANDLE_FAILED();
//        }
//        return ResponseResult.HANDLE_SUCCESS(userEntity);
//    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/updateUserInfo")
    public ResponseResult<String> updateUserInfo(@RequestBody UserEntity user) {
        log.info("用户更新信息：{}", user.toString());
        boolean isUpdate = userEntityService.updateUserInfo(user);
        if (isUpdate){
            return ResponseResult.HANDLE_SUCCESS();
        }
        return ResponseResult.HANDLE_FAILED();
    }

    /**
     * 删除用户信息
     * @param user
     * @return
     */
    @DeleteMapping("/deleteUser")
    public ResponseResult<String> deleteUser(@RequestBody UserEntity user) {
        log.info("删除用户信息：{}", user.toString());
        boolean isUpdate = userEntityService.deleteUser(user);
        if (isUpdate){
            return ResponseResult.HANDLE_SUCCESS();
        }
        return ResponseResult.HANDLE_FAILED();
    }


}

