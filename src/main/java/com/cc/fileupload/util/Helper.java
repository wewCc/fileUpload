package com.cc.fileupload.util;

/**
 * @author CC
 * @date Created in 2024/2/7 10:49
 */
public class Helper {
    /**
     * 构建切片文件名
     *
     * @param baseName 基础文件名
     * @param index    文件索引
     * @return 返回切片文件名
     */
    public static String buildChunkName(String baseName, Integer index) {
        int i = baseName.lastIndexOf(".");
        String prefix = baseName.substring(0, i).replaceAll("\\.", "_");
        return prefix + "_part_" + index;
    }

    public static <T> ResultFormat<T> getReturnMsg(Integer code, T data, String msg) {
        return new ResultFormat<T>(data, msg, code);
    }

    public static <T> ResultFormat<T> getReturnMsg(Integer code, T data) {
        return new ResultFormat<T>(data, code);
    }

    public static ResultFormat<String> getReturnMsg(Integer code, String msg) {
        return new ResultFormat<>(msg, code);
    }
    public static ResultFormat<Integer> getReturnMsg(Integer code){
        return new ResultFormat<>(code);
    }
//
//    public static void main(String[] args) {
//        String s = buildChunkName("test.xx.txt", 1);
//        System.out.println(s);
//    }
}
