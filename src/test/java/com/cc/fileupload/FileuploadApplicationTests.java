package com.cc.fileupload;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;

@SpringBootTest
class FileuploadApplicationTests {

    @Test
    void contextLoads() {
        String x = DigestUtils.md5DigestAsHex("hello".getBytes());
        System.out.println(x);
        //前后端hash一致
        System.out.println("5d41402abc4b2a76b9719d911017c592".equals(x));
        System.out.println(new File("D:\\桌面\\图片", "ls").getPath());
    }

}
