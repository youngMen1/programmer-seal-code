package com.seal.datastructure.algorithm;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 17:20
 * @description 计数排序
 * 和桶排序过程比较像，差别在于桶的数量。
 * <p>
 * 比较排序：在排序的最终结果中，各元素的次序依赖于他们之间的比较。
 * 　　计数排序基本思想：输入一个数X，确定小于X的元素的个数，这样，就可以把这个数放在输出数组的指定位置上。
 * 　　假设输入数组是A[1...n]，则需要一个辅助数组C[0...K]，一个输出数组B[1...n]。其中k代表输入数组中的最大值，n代表输入数组的长度。
 * 　　其中，输入数组A是需要进行排序的一组数据，输出数组B是需要排序完成后的数据。辅助数组中是按键值存储该键值在输入数组中出现的次数。
 * 　　思路：
 * 　　1、初始化辅助数组。
 * 　　2、循环遍历每一个输入元素，如果一个输入元素为i,则辅助数组中相应的C[i]的值加1。执行完毕之后。数组C中存储的就是各个键值在输入数组中出现的次数。
 * 　　3、再通过加总计算确定对于从1到k，有多少个输入元素是小于等于k的。将结果赋值到数组C中。
 * 　　4、循环将A[J]放到它在输出数组的正确位置上。对于一个值来说，C[A[J]]的值就是它在输出数组B中的正确位置。
 * 　　  当输入数组中的元素都是互异时，就比较好理解。但是当数组中有些元素相同时。
 * 　　  我们每将一个值放入输出数组中，都要将辅助数组中相应的值减1。这样，当存在下一个相同的值时，该元素可直接放在输出数组中相对应的位置上。
 * 　　总结：计数排序的时间复杂度为O(n)，计数排序最重要的特性是稳定。
 **/
public class CountSortTest {

    public static void main(String args[]) {
        int k = 10;
//        int atomic[] = com.sunpro.java.RandomGenerator.randGenerator(10,k);
//        countSort(atomic, k);
    }

    public static void countSort(int[] A, int k) {
        //初始化count数组
        int[] count = new int[k];
        //为输入数组中每个元素计数
        for (int i : A) {
            count[i]++;
        }
        //计算各个数之前元素的总和
        for (int i = 1; i < k; i++) {
            count[i] = count[i] + count[i - 1];
        }
        //初始化一个新的数组存放排序后的元素
        int[] B = new int[A.length];
        for (int j = A.length - 1; j >= 0; j--) {
            //把A[j]放到对应的位置
            B[count[A[j]] - 1] = A[j];
            //计数器减一
            count[A[j]]--;
        }
        System.arraycopy(B, 0, A, 0, A.length);
    }
}
