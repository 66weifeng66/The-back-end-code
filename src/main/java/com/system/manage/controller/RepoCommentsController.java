package com.system.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.system.manage.constant.ResponseResult;
import com.system.manage.po.RepoComments;
import com.system.manage.service.impl.RepoCommentsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Created by lq
 * @version jdk1.8
 * @description
 * @date 2021/11/8 21:09
 */
@RestController
@Slf4j
public class RepoCommentsController {
    @Autowired
    private RepoCommentsServiceImpl repoCommentsService;

    @GetMapping("/getRepoCommentById")
    public ResponseEntity<List<RepoComments>> getRepoComments(@RequestParam("id") String repoId){
        QueryWrapper<RepoComments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("repo_id", repoId);
        return ResponseEntity.ok(repoCommentsService.list(queryWrapper));
    }

    @PostMapping("/addRepoComment")
    public ResponseResult postRepoComment(@RequestBody RepoComments repoComments){
        repoComments.setCreateTime(new Date());
        repoCommentsService.save(repoComments);
        return ResponseResult.HANDLE_SUCCESS();
    }


}
