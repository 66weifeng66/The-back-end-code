package com.system.manage.config.mybatisconfig;

import com.system.manage.dao.mapper.ScanMapperConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by lq
 * @version jdk1.8
 * @description
 * @date 2021/4/26 8:54
 */
@Configuration
@MapperScan(basePackageClasses = ScanMapperConfig.class)
public class MybatisConfig {
}
