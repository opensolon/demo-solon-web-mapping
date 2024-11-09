package com.example.demo;

import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.MethodType;

@Mapping("rest2")
@Controller
public class RestController2 {
    /**
     * 与 @Get 的区别；；；原则为：辅助注解优先（当非同有 @Get 时，下面的 method = MethodType.POST 为无效）
     * */
    @Mapping(method = MethodType.GET)
    public String get(String name) {
        return name;
    }

    @Mapping(method = MethodType.POST)
    public String post(String name) {
        return name;
    }

    @Mapping(method = MethodType.PUT)
    public String put(String name) {
        return name;
    }

    @Mapping(method = MethodType.DELETE)
    public String delete(String name) {
        return name;
    }

    @Mapping(method = MethodType.PATCH)
    public String patch(String name) {
        return name;
    }
}
