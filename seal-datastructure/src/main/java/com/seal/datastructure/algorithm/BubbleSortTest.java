package com.seal.datastructure.algorithm;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 16:37
 * @description 冒泡排序
 * 相邻元素前后交换、把最大的排到最后。
 * 时间复杂度 O(n²)
 **/
public class BubbleSortTest {

    public static void main(String[] args) {
        bubbleSort();
        bubbleSortTwo();
    }

    /**
     * score[j] 和 score[j+1] 比较 如果 前者比后者小，
     * 把前者和后者调换顺序，两两调换后一轮下来 最小的会被排到最后去。
     * 每一轮j都从0开始，当i轮排序，就有最后面的i个数字因为他是最小的，
     * 所以后面的每轮都不用理他了，也就是 score.length-1-i  
     * 往后的数不用管了，如上，第一轮有4个数字 i为0 ，
     * 那么score.length-1-i  
     * 为3，也就是下标是3以后的可以不用管，3往后没有数字，
     * 所以第一轮所有的数字都要参加比较
     * 第二轮I=1  score.length-1-i  为2 也就是说 下标2后面的 下标为3的数字不用比了，
     * 因为两两比较厚，67会到 score[3],实现代码如下：
     */
    private static void bubbleSort() {
        int[] score = {100, 10, 6, 75, 30, 2, 0, 1};
        for (int i = 0; i < score.length - 1; i++) {
            // j开始等于0，
            for (int j = 0; j < score.length - 1 - i; j++) {
                if (score[j] < score[j + 1]) {
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
        }
        System.out.println("第一种:");
        for (int num : score) {
            System.out.print(num + " ");
        }
    }

    /**
     * 第二种思路，用88 和 75 比较，在和69 比较 在和 67 比较，发
     * 现88是最大的，吧他排到第一位(index=0的位置)，
     * 然后i=1,也就是第二轮，就不用看下标为0的88了因为他是老大，然后接着比较。；
     */
    private static void bubbleSortTwo() {
        int[] score = {100, 10, 6, 75, 30, 2, 0, 1};
        for (int i = 0; i < score.length - 1; i++) {
            for (int j = (score.length - 2); j >= i; j--) {
                if (score[j] < score[j + 1]) {
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("第二种:");
        for (int num : score) {
            System.out.print(num + " ");
        }
    }

}
