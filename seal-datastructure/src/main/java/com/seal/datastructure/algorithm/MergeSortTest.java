package com.seal.datastructure.algorithm;

import java.util.Arrays;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/17 15:22
 * @description 归并排序
 * 分而治之，分成小份排序，在合并(重建一个新空间进行复制)。
 **/
public class MergeSortTest {
    /**
     * 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。j
     * ava中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。从上文的图中可看出，
     * 每次合并操作的平均时间复杂度为O(n)，
     * 而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)。
     * 而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 左边归并排序，使得左子序列有序
            sort(arr, left, mid, temp);
            // 右边归并排序，使得右子序列有序
            sort(arr, mid + 1, right, temp);
            // 将两个有序子数组合并操作
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左序列指针
        int i = left;
        // 右序列指针
        int j = mid + 1;
        // 临时数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        // 将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        // 将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
