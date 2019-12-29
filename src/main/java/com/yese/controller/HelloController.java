package com.yese.controller;

import com.yese.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiOperation("获取用户")
    @GetMapping("/user")
    public User user() {
        return new User(1, "张三");
    }

    @ApiOperation("获取用户名")
    @GetMapping("/username")
    public String username(@ApiParam("用户名") String username) {
        return "用户名是:" + username;
    }

    //只要接口中返回值中存在实体类,就会被扫描到swagger中
    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public User addUser(@ApiParam("用户") User user) {
        return user;
    }

}
