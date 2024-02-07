package com.cc.fileupload.entity;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CC
 * @date Created in 2024/2/7 10:33
 */
public class UploadFile {
    /**
     * 传入的切片文件
     */
    private MultipartFile chunkBody;
    /**
     * 文件hash
     */
    private String hash;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 当前切片的索引号
     */
    private Integer chunkIndex;


    public MultipartFile getChunkBody() {
        return chunkBody;
    }

    public void setChunkBody(MultipartFile chunkBody) {
        this.chunkBody = chunkBody;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(Integer chunkIndex) {
        this.chunkIndex = chunkIndex;
    }


    @Override
    public String toString() {
        return "UploadFile{" +
                "chunkBody=" + chunkBody +
                ", hash='" + hash + '\'' +
                ", filename='" + filename + '\'' +
                ", chunkIndex=" + chunkIndex +
                '}';
    }
}
