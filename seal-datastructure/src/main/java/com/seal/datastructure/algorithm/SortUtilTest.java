package com.seal.datastructure.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 18:14
 * @description 排序工具
 **/
public class SortUtilTest {

    public static void main(String[] args) {
        CollectionsSort();
    }


    /**
     * Collections.sort方法底层就是调用的array.sort方法
     * 不论是Collections.sort方法或者是Arrays.sort方法，底层实现都是TimSort实现的，这是jdk1.7新增的，以前是归并排序。
     * TimSort算法就是找到已经排好序数据的子序列，然后对剩余部分排序，然后合并起来
     */
    private static void CollectionsSort() {
        List<String> strings = Arrays.asList("6", "1", "3", "1", "2");
        // sort方法在这里
        Collections.sort(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }


}
