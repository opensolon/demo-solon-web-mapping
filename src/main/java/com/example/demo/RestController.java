package com.example.demo;

import org.noear.solon.annotation.*;

@Mapping("rest")
@Controller
public class RestController {
    @Get
    @Mapping
    public String get(String name) {
        return name;
    }

    @Post
    @Mapping
    public String post(String name) {
        return name;
    }

    @Put
    @Mapping
    public String put(String name) {
        return name;
    }


    @Delete
    @Mapping
    public String delete(String name) {
        return name;
    }

    @Patch
    @Mapping
    public String patch(String name) {
        return name;
    }
}
