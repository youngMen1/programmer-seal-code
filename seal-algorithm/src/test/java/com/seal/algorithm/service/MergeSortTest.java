package com.seal.algorithm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/17 16:59
 * @description 归并排序
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MergeSortTest {

    @Autowired
    MergeSortService mergeSortService;

    @Test
    public void contextLoads() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSortService.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
