package com.quruiqi.sort;

import java.util.Arrays;

/**
 * 桶排序
 * @Author Bill
 * @Date 2023/9/3 22:01
 **/
public class BucketSort {

    /**
     * 桶排序
     */
    public int[] bucketSort(int[] data,int bucketSize){

        int[] ints = Arrays.copyOf(data, data.length);

        return sort(ints, bucketSize);
    }

    private int[] sort(int[] data, int bucketSize){

        if (data == null || data.length < 2){
            return data;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min){
                min = data[i];
            }
            if (data[i] > max){
                max = data[i];
            }
        }

        int bucketCount = (int)Math.floor((max - min)/bucketSize) + 1;
        int[][] bucketArray = new int[bucketCount][0];
        for (int i = 0; i < data.length; i++) {
            int index = (int)Math.floor((data[i] - min)/bucketSize);
            bucketArray[index] = arrAppend(bucketArray[index], data[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : bucketArray) {
            if (bucket.length == 0){
                continue;
            }
            Arrays.sort(bucket);
            for (int i : bucket) {
                data[arrIndex++] = i;
            }
        }

        return data;
    }

    //不断给桶扩容
    private int[] arrAppend(int[] ints, int datum) {
        int[] ints1 = Arrays.copyOf(ints, ints.length + 1);
        ints1[ints1.length - 1] = datum;
        return ints1;
    }

    public static void main(String[] args) {

        int[] data = new int[]{8,2,7,3,6,9,1,7};
        BucketSort bucketSort = new BucketSort();
        int[] sort = bucketSort.bucketSort(data, 5);

        for (int datum : data) {
            System.out.printf("%d\t", datum);
        }
        System.out.println();
        System.out.println("-------------------------------");
        for (int i : sort) {
            System.out.printf("%d\t", i);
        }
    }

}
