package com.example.demo;


import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.MethodType;
import org.noear.solon.core.handle.UploadedFile;

/**
 * 有 UploadedFile 参数；或申明 multipart 。。。才会进行 multipart 解码
 * */
@Mapping("multipart")
@Controller
public class MultipartController {
    //有 UploadedFile 自动只别 Multipart
    @Post
    @Mapping("upload")
    public String upload(UploadedFile file) {
        return file.getName();
    }

    //有 UploadedFile 自动只别 Multipart
    @Post
    @Mapping("form")
    public String form(String name, UploadedFile icon) {
        return name + " - " + icon.getName();
    }

    @Multipart
    @Post
    @Mapping("data")
    public String data(String name, String icon) {
        return name + " - " + icon;
    }

    @Mapping(value = "data2", method = MethodType.POST, multipart = true)
    public String data2(String name, String icon) {
        return name + " - " + icon;
    }
}
