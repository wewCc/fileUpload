package com.cc.fileupload.util;

/**
 * @author CC
 * @date Created in 2024/2/7 11:46
 */
public enum StatusCode {
    UPLOAD_SUCCESS(200),
    NOT_UPLOAD(202),
    ALREADY_UPLOAD(1000),
    UPLOAD_FAILED(1004);
    private java.lang.Integer code;

    StatusCode(java.lang.Integer code) {
        this.code = code;
    }

    public java.lang.Integer getCode() {
        return code;
    }

    public void setCode(java.lang.Integer code) {
        this.code = code;
    }


}
