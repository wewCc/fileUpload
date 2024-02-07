package com.cc.fileupload.service.impl;

import com.cc.fileupload.entity.BaseFile;
import com.cc.fileupload.entity.MergeFile;
import com.cc.fileupload.entity.UploadFile;
import com.cc.fileupload.service.UploadService;
import com.cc.fileupload.util.Helper;
import com.cc.fileupload.util.ResultFormat;
import com.cc.fileupload.util.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

/**
 * @author CC
 * @date Created in 2024/2/7 10:46
 */
@Service
public class IUploadService implements UploadService {
    private static final String BASE_PATH = "D:\\桌面\\图片";

    @Override
    public ResultFormat<java.lang.Integer> checkHasUpload(BaseFile mergeFile) {
        String fileHash = mergeFile.getFileHash();
        String filename = mergeFile.getFilename();
        File folder = new File(BASE_PATH, fileHash);
        if (folder.exists()) {
            File file = new File(folder, filename);
            if (file.exists()) {
                return Helper.getReturnMsg(StatusCode.ALREADY_UPLOAD.getCode());
            }
        }
        return Helper.getReturnMsg(StatusCode.NOT_UPLOAD.getCode());
    }

    @Override
    public ResultFormat upload(UploadFile uploadFile) {
        String filename = uploadFile.getFilename();
        String hash = uploadFile.getHash();
        java.lang.Integer currentChunkIndex = uploadFile.getChunkIndex();
        MultipartFile chunkBody = uploadFile.getChunkBody();
        //根据hash来创建文件夹,有助于检测是否上传
        File folder = new File(BASE_PATH, hash);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //这里获取需要写入的文件路径和文件名
        File file1 = new File(folder, Helper.buildChunkName(filename, currentChunkIndex));
        try {
            //文件写入
            chunkBody.transferTo(file1);
            return Helper.getReturnMsg(StatusCode.UPLOAD_SUCCESS.getCode(), "上传成功");
        } catch (IOException e) {
            System.out.println("出现错误");
            e.printStackTrace();
        }
        //对文件进行写入
        return Helper.getReturnMsg(StatusCode.UPLOAD_FAILED.getCode(), "上传失败");
    }

    @Override
    public void deleteChunks(MergeFile mergeFile) {
        File hashFolder = new File(BASE_PATH, mergeFile.getFileHash());
        java.lang.Integer totalChunk = mergeFile.getTotalChunk();
        String filename = mergeFile.getFilename();
        for (int i = 0; i < totalChunk; i++) {
            //获取切片
            File tmpChunkFile = new File(hashFolder, Helper.buildChunkName(filename, i));
            tmpChunkFile.delete();
        }
    }

    @Override
    public void merge(MergeFile mergeFile) {
        String hash = mergeFile.getFileHash();
        String filename = mergeFile.getFilename();
        java.lang.Integer totalChunk = mergeFile.getTotalChunk();
        //文件hash的Folder
        File hashFolder = new File(BASE_PATH, hash);
        OutputStream os = null;
        //检查是否有该hash目录
        try {
            if (hashFolder.exists()) {
                //指定最后输出的文件名
                os = new FileOutputStream(new File(hashFolder, filename));
                for (int i = 0; i < totalChunk; i++) {
                    //获取切片
                    File tmpChunkFile = new File(hashFolder, Helper.buildChunkName(filename, i));
                    //数据读取并写入缓存区
                    byte[] bytes = Files.readAllBytes(tmpChunkFile.toPath());
                    //将每一个切片数据读取写入缓存区
                    os.write(bytes);
                }
                //在将每一个切片的字节全都写入缓冲区后,最后合并输出文件
                os.flush();
                //输出后清理临时文件
                deleteChunks(mergeFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
