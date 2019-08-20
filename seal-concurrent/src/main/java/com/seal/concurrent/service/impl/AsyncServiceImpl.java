package com.seal.concurrent.service.impl;

import com.seal.concurrent.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 13:53
 * @description executeAsync方法上增加注解@Async(“asyncServiceExecutor”)，
 * asyncServiceExecutor是前面ExecutorConfig.java中的方法名，
 * 表明executeAsync方法进入的线程池是asyncServiceExecutor方法创建的
 * @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
 **/
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        try {
            Thread.sleep(1000);
            System.out.println("创建线程:" + (int) (Math.random() * 100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
