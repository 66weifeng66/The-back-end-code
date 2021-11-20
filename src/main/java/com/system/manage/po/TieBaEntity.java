package com.system.manage.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Created by lq
 * @version jdk1.8
 * @description
 * @date 2021/11/9 21:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "tieba")
public class TieBaEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String tiebaContents;

    private String reviewers;

    private String respondents;

    private String avatarUrl;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
