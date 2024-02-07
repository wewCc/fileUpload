package com.cc.fileupload.controller;

import com.cc.fileupload.entity.BaseFile;
import com.cc.fileupload.entity.MergeFile;
import com.cc.fileupload.entity.UploadFile;
import com.cc.fileupload.service.UploadService;
import com.cc.fileupload.util.ResultFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author CC
 * @date Created in 2024/2/7 9:46
 */
@RestController
@CrossOrigin
public class UploadController {
    @Resource
    private UploadService uploadService;

    @RequestMapping("/upload")
    public ResultFormat upload(@ModelAttribute UploadFile uploadFile) {
        System.out.println("上传");
        return uploadService.upload(uploadFile);
    }

    @RequestMapping("/merge")
    public void merge(@ModelAttribute MergeFile mergeFile) {
        uploadService.merge(mergeFile);
    }

    @RequestMapping("/check")
    public ResultFormat check(@ModelAttribute BaseFile file) {
        System.out.println("检查");
        return uploadService.checkHasUpload(file);
    }
}
