package com.system.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.system.manage.config.security.JwtTokenUtil;
import com.system.manage.dao.mapper.UserMapper;
import com.system.manage.po.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Created by lq
 * @version jdk1.8
 * @description
 * @date 2021/4/12 20:39
 */
@Service
@Slf4j
public class UserEntityServiceImpl extends ServiceImpl<UserMapper, UserEntity> {

    @Value("${jwt.header}")
    private String tokenHeader;

//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param userEntity
     * @return
     */
    public Boolean registerUserEntity(UserEntity userEntity){
        boolean flag = true;
        Page<UserEntity> page = new Page<>();
//        page.
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("username", userEntity.getUsername());
        UserEntity userEntityExit = userMapper.selectOne(userEntityQueryWrapper);
        // 用户是否已存在
        if (userEntityExit != null){
            return false;
        }
        try{

            userMapper.insert(userEntity);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 用户登录
     * @param userEntity
     * @return
     */
    public Boolean loginUser(UserEntity userEntity){
        boolean flag = true;
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("username", userEntity.getUsername());
        UserEntity userEntityExit = userMapper.selectOne(userEntityQueryWrapper);
        if (userEntityExit == null){
            return false;
        }
        try{
            userEntityExit.setLoginTime(new Date());
            userMapper.updateById(userEntityExit);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 用户更新信息
     * @param userEntity
     * @return
     */
    public Boolean updateUserInfo(UserEntity userEntity){
        boolean flag = true;
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("username", userEntity.getUsername());
        UserEntity userEntityExit = userMapper.selectOne(userEntityQueryWrapper);
        if (userEntityExit == null){
            return false;
        }
        try{
            userEntityExit.setPassword(userEntity.getPassword());
            userEntityExit.setAddress(userEntity.getAddress());
            userEntityExit.setAge(userEntity.getAge());
            userEntityExit.setPhoneNumber(userEntity.getPhoneNumber());
            userEntityExit.setSex(userEntity.getSex());
            userEntityExit.setAvatar(userEntity.getAvatar());
            userMapper.updateById(userEntity);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 删除用户
     * @param userEntity
     * @return
     */
    public Boolean deleteUser(UserEntity userEntity){
        boolean flag = true;
        try{
           userMapper.deleteById(userEntity.getUserId());
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 用户退出记录退出时间
     * @param request
     * @return
     */
//    public Boolean recordLogoutTime(HttpServletRequest request){
//        boolean flag = true;
//        final String requestHeader = request.getHeader(this.tokenHeader);
//        String authToken = requestHeader.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(authToken);
//        try{
//            QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
//            userEntityQueryWrapper.eq("username", username);
//            UserEntity userEntity = userMapper.selectOne(userEntityQueryWrapper);
//            userEntity.setLoginTime(new Date());
//            userMapper.updateById(userEntity);
//        }catch (Exception e){
//            e.printStackTrace();
//            flag = false;
//        }
//        return flag;
//    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
//    public UserEntity getUserInfo(HttpServletRequest request){
//        final String requestHeader = request.getHeader(this.tokenHeader);
//        String authToken = requestHeader.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(authToken);
//        if (StringUtils.hasText(username)){
//            try{
//                QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
//                userEntityQueryWrapper.eq("username", username);
//                UserEntity userEntity = userMapper.selectOne(userEntityQueryWrapper);
//                userEntity.setLoginTime(null);
//                userEntity.setLogoutTime(null);
//                userEntity.setRegisterTime(null);
//                userEntity.setPassword(null);
//                return userEntity;
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }


}
