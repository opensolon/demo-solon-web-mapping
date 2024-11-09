package com.example.demo;

import org.noear.solon.annotation.*;

@Mapping("param")
@Controller
public class ParamController {
    @Get
    @Mapping("path/{name}")
    public String get(@Path("name") String name) {
        return name;
    }

    @Get
    @Mapping("header")
    public String get_header(@Header("name") String name) {
        return name;
    }

    @Get
    @Mapping("cookie")
    public String get_cookie(@Cookie("name") String name) {
        return name;
    }

    @Post
    @Mapping("body")
    public String post(@Body String name) {
        return name;
    }
}
