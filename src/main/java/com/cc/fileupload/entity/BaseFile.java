package com.cc.fileupload.entity;

/**
 * @author CC
 * @date Created in 2024/2/7 12:15
 */
public class BaseFile {
    /**
     * 文件hash
     */
    private String fileHash;

    public BaseFile() {
    }

    public BaseFile(String fileHash, String filename) {
        this.fileHash = fileHash;
        this.filename = filename;
    }

    /**
     * 文件名
     */
    private String filename;

    @Override
    public String toString() {
        return "BaseFile{" +
                "fileHash='" + fileHash + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
