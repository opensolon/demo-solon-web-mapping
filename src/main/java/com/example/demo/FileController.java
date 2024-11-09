package com.example.demo;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import org.noear.solon.core.handle.DownloadedFile;
import org.noear.solon.core.handle.UploadedFile;

@Mapping("file")
@Controller
public class FileController {
    @Post
    @Mapping("upload")
    public String upload(UploadedFile file) {
        return file.getName();
    }

    @Get
    @Mapping("download")
    public DownloadedFile download() {
        return new DownloadedFile("text/json", "{'name':'world'}".getBytes(), "demo.json");
    }
}