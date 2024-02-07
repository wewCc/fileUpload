package com.cc.fileupload.util;

/**
 * @author CC
 * @date Created in 2024/2/7 11:46
 */
public class ResultFormat<T> {
    private T data;
    private String msg;
    private Integer code;

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResultFormat(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public ResultFormat(Integer code) {
        this.code = code;
    }

    public ResultFormat(T data, Integer code) {
        this.data = data;
        this.code = code;
    }

    public ResultFormat(T data, String msg, Integer code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }
}
