package com.seal.concurrent;

import com.seal.commonswagger.annotation.EnableSealSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 并发学习
 * @author zhiqiang.feng
 * @date-time 2019/02/13-11:01
 **/
@EnableSealSwagger2
@SpringBootApplication
public class SealConcurrentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SealConcurrentApplication.class, args);
    }

}
