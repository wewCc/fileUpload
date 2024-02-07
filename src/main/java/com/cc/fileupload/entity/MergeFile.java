package com.cc.fileupload.entity;

/**
 * @author CC
 * @date Created in 2024/2/7 11:27
 */
public class MergeFile {
    /**
     * 文件名
     */
    private String filename;
    /**
     * 文件hash
     */
    private String fileHash;
    /**
     * 切片总数
     */
    private Integer totalChunk;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public Integer getTotalChunk() {
        return totalChunk;
    }

    @Override
    public String toString() {
        return "MergeFile{" +
                "filename='" + filename + '\'' +
                ", fileHash='" + fileHash + '\'' +
                ", totalChunk=" + totalChunk +
                '}';
    }

    public void setTotalChunk(Integer totalChunk) {
        this.totalChunk = totalChunk;
    }

    public MergeFile() {
    }

    public MergeFile(String filename, String fileHash, Integer totalChunk) {
        this.filename = filename;
        this.fileHash = fileHash;
        this.totalChunk = totalChunk;
    }
}
