package com.cc.fileupload.service;

import com.cc.fileupload.entity.BaseFile;
import com.cc.fileupload.entity.MergeFile;
import com.cc.fileupload.entity.UploadFile;
import com.cc.fileupload.util.ResultFormat;

import java.io.File;

/**
 * @author CC
 * @date Created in 2024/2/7 10:46
 */
public interface UploadService {
    /**
     * 上传文件并保存切片的操作
     *
     * @param uploadFile 文件上传实体类
     * @return 返回状态信息
     */
    ResultFormat upload(UploadFile uploadFile);

    /**
     * 合并文件切片
     *
     * @param mergeFile 合并文件实体类
     */
    void merge(MergeFile mergeFile);

    /**
     * 对文件的切片做删除操作
     * @param mergeFile 合并文件实体类
     */
    void deleteChunks(MergeFile mergeFile);

    /**
     *
     * @param baseFile 检查文件是否已经上传
     * @return 返回状态信息
     */
    ResultFormat<Integer> checkHasUpload(BaseFile baseFile);
}
