package com.blb.upload.controller;

import com.blb.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("upload")
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){
        //调用service上传文件，返回图片的访问地址
            String url  =  uploadService.uploadImage(file);

            if(null!=url){
                // 返回200，并且携带url路径
                return ResponseEntity.ok(url);
            }
                  // url为空，证明上传失败
                return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
