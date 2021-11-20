package com.system.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.system.manage.constant.ResponseResult;
import com.system.manage.dao.mapper.TieBaCommentsMapper;
import com.system.manage.dao.mapper.TieBaEntityMapper;
import com.system.manage.po.TieBaEntity;
import com.system.manage.po.TiebaComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Created by lq
 * @version jdk1.8
 * @description
 * @date 2021/11/9 21:57
 */
@RestController
public class TieBaController {

    @Autowired
    private TieBaEntityMapper tieBaEntityMapper;
    @Autowired
    private TieBaCommentsMapper tieBaCommentsMapper;

    /**
     * 新建贴吧
     * @param tieBaEntity
     * @return
     */
    @PostMapping("/addTieBa")
    public ResponseResult<String> addTieBa(@RequestBody TieBaEntity tieBaEntity){
        tieBaEntity.setCreateTime(new Date());
        tieBaEntityMapper.insert(tieBaEntity);
        return ResponseResult.HANDLE_SUCCESS("添加成功");
    }

    /**
     * 获取所有贴吧
     * @return
     */
    @GetMapping("/getAllTieBa")
    public ResponseResult<List<TieBaEntity>> getAllTieBa(){
        return ResponseResult.HANDLE_SUCCESS(tieBaEntityMapper.selectList(null));
    }

    /**
     * 查询指定贴吧所有评论
     * @param id
     * @return
     */
    @GetMapping("/getTieBaCommentsById")
    public ResponseResult<List<TiebaComments>> getTieBaCommentsById(@RequestParam("id") Integer id){
        QueryWrapper<TiebaComments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tieba_id",id);
        return ResponseResult.HANDLE_SUCCESS(tieBaCommentsMapper.selectList(queryWrapper));
    }

    /**
     * 新建贴吧评论
     * @param tiebaComments
     * @return
     */
    @PostMapping("/addTieBaComments")
    public ResponseResult<String> addTieBaComments(@RequestBody TiebaComments tiebaComments){
        tiebaComments.setCreateTime(new Date());
        tieBaCommentsMapper.insert(tiebaComments);
        return ResponseResult.HANDLE_SUCCESS("添加成功");
    }

}
