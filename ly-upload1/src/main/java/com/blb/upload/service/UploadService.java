package com.blb.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    public String uploadImage(MultipartFile file) {
        //创建file对象
      //     File f  =  new File("G:\\hhhhh");
      //     if(!f.exists()){
        //       //如果没有的话创建文件夹
        //          f.mkdirs();
        //   }
           //保存图片
   //     try {
    //        file.transferTo(new File(f,file.getOriginalFilename()));
   //     } catch (IOException e) {
   //         e.printStackTrace();
  //      }
  //      return "http://image.leyou.com"+file.getOriginalFilename();
        String url = null;
        //获取图片的后缀
        String originalFilename = file.getOriginalFilename();
        String ext = StringUtils.substringAfter(originalFilename,".");//png
        // 上传
        try {
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);
            return "http:image.leyou.com/"+storePath.getFullPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
