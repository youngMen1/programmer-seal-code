package com.seal.datastructure.algorithm;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 16:50
 * @description 插入排序
 * 插入排序算法有种递归的思想在里面，它由N-1趟排序组成。初始时，只考虑数组下标0处的元素，只有一个元素，显然是有序的。
 * 然后第一趟 对下标 1 处的元素进行排序，保证数组[0,1]上的元素有序；
 * 第二趟 对下标 2 处的元素进行排序，保证数组[0,2]上的元素有序；
 * 第N-1趟对下标 N-1 处的元素进行排序，保证数组[0,N-1]上的元素有序，也就是整个数组有序了。
 * 它的递归思想就体现在：当对位置 i 处的元素进行排序时，[0,i-1]上的元素一定是已经有序的了。
 **/
public class InsertSortTest {

    public static void main(String[] args) {
        Integer[] arr = {34, 8, 64, 51, 32, 21};
        insertSort(arr);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
    }

    private static <T extends Comparable<? super T>> void insertSort(T[] a) {
        for (int p = 1; p < a.length; p++) {
            // 保存当前位置p的元素，其中[0,p-1]已经有序
            T tmp = a[p];
            int j;
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                // 后移一位
                a[j] = a[j - 1];
            }
            // 插入到合适的位置
            a[j] = tmp;
        }
    }
}
