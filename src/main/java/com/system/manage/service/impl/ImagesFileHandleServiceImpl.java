package com.system.manage.service.impl;


import com.system.manage.utils.UUIDGeneratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.status;

/**
 * @author Created by long qian
 * @version jdk1.8
 * @Description
 * @date 2020/3/19 17:20
 */
@Service
@Slf4j
public class ImagesFileHandleServiceImpl {

    /**
      * @author lq
      * @description 上传图片后返回图片名
      * @param request
      * @param multipartFile
      * @return com.agricultural.show.constant.Result<java.lang.String>
      */
    public String uploadImageName(HttpServletRequest request, MultipartFile multipartFile) {
        log.info("接收上传文件进行保存：{}",multipartFile.getName());
        Map<String, String> map = new HashMap<>();
        try{
            String resourcesPath = System.getProperty("user.dir");
            String imageFunction = "/images/";
            String savePath = resourcesPath + imageFunction;
            String saveFileName = UUIDGeneratorUtils.getId() + multipartFile.getOriginalFilename();
            File saveFile = new File(savePath,  saveFileName);
            System.out.println(saveFile.getParentFile().toString());
            //判断是否存在该目录
            if (!saveFile.getParentFile().exists()){
                saveFile.getParentFile().mkdirs();
            }
            multipartFile.transferTo(new File(savePath + File.separator + saveFileName));
            return saveFileName;
        }catch (IOException e){
            log.info("保存图片出错：{}",e.getMessage());
        }
        return null;
    }
    /**
      * @author lq
      * @description 根据图片名返回图片
      * @param filename
      * @param request
      * @return org.springframework.http.ResponseEntity<byte[]>
      */
    public ResponseEntity<byte[]> downloadImageByImageName(String filename, HttpServletRequest request) {
        //下载文件路径
        log.info("下载指定图片：{}",filename);
        try{
            String resourcesPath = System.getProperty("user.dir");
            String downloadPath = resourcesPath + "/images/";
            //构建File
            File file = new File(downloadPath + File.separator + filename);
            //OK表示http请求状态
            ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
            builder.contentLength(file.length());
            //二进制流下载
            builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
            filename = URLEncoder.encode(filename,"UTF-8");
            builder.header("Content-Disposition","attachment; filename*=UTF8''" + filename);
            return builder.body(FileUtils.readFileToByteArray(file));
        }catch (IOException e){
            log.info("下载文件出错：{}",e.getMessage());
            ResponseEntity.BodyBuilder builder = status(404);
            return builder.build();
        }
    }

    /**
     * 删除文件
     * @param imageName
     * @return
     */
    public Boolean deleteImageByImageName(String imageName){
        boolean flag = true;
        String resourcesPath = System.getProperty("user.dir");
        String downloadPath = resourcesPath + "/images/";
        //构建File
        File file = new File(downloadPath + File.separator + imageName);
        try{
            file.delete();
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

}
