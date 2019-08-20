package com.seal.datastructure.algorithm;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 16:25
 * @description 选择排序
 * 每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
 **/
public class SelectionSortTest {
    public static void main(String[] args) {
        selectionSort();
    }

    private static void selectionSort() {
        int[] arr = {5, 9, 6, 7, 3, 1, 2, 4, 8};
        System.out.println("排序之前:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // 选择排序的优化
        for (int i = 0; i < arr.length - 1; i++) {
            // 做第i趟排序
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {
                // 选最小的记录
                if (arr[j] < arr[k]) {
                    // 记下目前找到的最小值所在的位置
                    k = j;
                }
            }
            // 在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {
                // 交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println();
        System.out.println("排序之后:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
