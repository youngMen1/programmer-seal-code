package com.seal.concurrent;

import com.seal.common.annotation.EnableSealSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/02/13-11:01
 * @description 并发
 **/
@EnableSealSwagger2
@SpringBootApplication
public class SealConcurrentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SealConcurrentApplication.class, args);
    }

}
