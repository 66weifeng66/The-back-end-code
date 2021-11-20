package com.system.manage.controller;


import com.system.manage.constant.ResponseResult;
import com.system.manage.service.impl.ImagesFileHandleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author Created by long qian
 * @version jdk1.8
 * @Description 图片上传下载接口
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class ImagesController {

    @Autowired
    private ImagesFileHandleServiceImpl imagesFileHandleService;

    /**
      * @author long qian
      * @description 上传图片返回图片名
      * @param request
      * @param file
      * @return com.agricultural.show.constant.Result<java.lang.String>
      */
    @PostMapping("/uploadImageImageName")
    public ResponseResult<String> uploadImageImageName(HttpServletRequest request, @RequestParam("imageName") MultipartFile file) throws IOException {
        return ResponseResult.HANDLE_SUCCESS(imagesFileHandleService.uploadImageName(request,file));
    }

    /**
      * @author long qian
      * @description 根据图片名下载图片
      * @param filename
      * @param request
      * @return org.springframework.http.ResponseEntity<byte[]>
      */
    @GetMapping("/downloadImageByImageName")
    public ResponseEntity<byte[]> downloadImageByImageName(@RequestParam("filename")String filename, HttpServletRequest request) throws IOException {
        return imagesFileHandleService.downloadImageByImageName(filename,request);
    }

}
