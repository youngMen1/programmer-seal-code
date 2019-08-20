package com.seal.datastructure.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 17:27
 * @description 桶排序
 * 桶排序（bucket sort）假设输入数据服从均匀分布。平均情况下他的时间代价是O(n)。计数排序假设输入数据分布于一个小区间的整数，
 * 而桶排序则假设输入是一个随机过程产生的，该过程将元素均匀独立地分布于[0,1)区间上
 **/
public class BucketSortTest {

    public static void main(String args[]) {
//        //总数小，范围小
//        int test1[] = com.sunpro.java.RandomGenerator.randGenerator(10, 10);
//        //总数小，范围大
//        int test2[] = com.sunpro.java.RandomGenerator.randGenerator(10, 1000);
//        //总数大，范围小
//        int test3[] = com.sunpro.java.RandomGenerator.randGenerator(100, 10);
//        //总数大，范围大
//        int test4[] = com.sunpro.java.RandomGenerator.randGenerator(100, 1000);
//        System.out.println("总数小，范围小：方案二：");
//        bucketSort2(test1);
//        System.out.println("方案一：");
//        bucketSort(test1);
//        System.out.println("总数小，范围大：方案二：");
//        bucketSort2(test2);
//        System.out.println("方案一：");
//        bucketSort(test2);
//        System.out.println("总数大，范围小：方案二：");
//        bucketSort2(test3);
//        System.out.println("方案一：");
//        bucketSort(test3);
//        System.out.println("总数大，范围大：方案二：");
//        bucketSort2(test4);
//        System.out.println("方案一：");
//        bucketSort(test4);
    }


    /**
     * 方案一
     *
     * @param A
     */
    public static void bucketSort(int[] A) {
        //1. 构造桶
        //1.1 确定桶的个数n
        int n = A.length;
        //1.2 声明并初始化一个List，存放链表；
        List<ArrayList<Integer>> Blist = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            Blist.add(new ArrayList<Integer>(5));
        //2.将数组中的元素放到桶中
        //2.1 确定元素的最值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : A) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        //2.2 确定每个元素放入桶的编号并放进去
        for (int i : A) {
            //2.2.1 确定桶的编号
            int len = A.length;
            //加1是为了保证inde< A.length，防止程序抛出IndexOutofBoundsEx;
            int index = (int) ((i - min) / (max - min + 1.0) * A.length);
            //2.2.2 放入对应的桶中
            Blist.get(index).add(i);
        }
        //3.桶内排序
        for (int i = 0; i < Blist.size(); i++) {
            java.util.Collections.sort(Blist.get(i));
        }
        //4.合并数据
        int j = 0;
        for (ArrayList<Integer> arr : Blist) {
            for (int i : arr) {
                A[j++] = i;
            }
        }
    }

    /**
     * 方案二
     *
     * @param arr
     */
    public static void bucketSort2(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        System.out.println(bucketArr.toString());

    }


}

