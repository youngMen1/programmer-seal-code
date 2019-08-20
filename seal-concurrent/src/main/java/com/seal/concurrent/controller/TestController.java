package com.seal.concurrent.controller;

import com.seal.concurrent.service.AsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 14:03
 * @description
 **/
@Slf4j
@RestController
@Api(value = "TestController", tags = "测试管理")
public class TestController {

    @Autowired
    private AsyncService asyncService;

    @PostMapping("/submit")
    @ApiOperation(value = "添加任务详情", notes = "添加任务详情")
    public String submit() {
        log.info("start submit");

        // 调用service层的任务
        asyncService.executeAsync();

        log.info("end submit");

        return "success";
    }
}
