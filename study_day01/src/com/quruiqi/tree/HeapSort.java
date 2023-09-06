package com.quruiqi.tree;

/**
 * 堆排序
 * @Author Bill
 * @Date 2023/9/5 19:01
 **/
public class HeapSort {

    public static void heapSort(int[] data){

        //每个子树进行旋转
        for (int i = data.length / 2 -1;i >= 0;i--){
            adjustSort(data, i, data.length);
        }

        for (int i = data.length - 1;i > 0;i--){
            int temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            adjustSort(data, 0, i);
        }

    }

    /**
     * 核心方法
     * @param data
     * @param i
     * @param length
     */
    private static void adjustSort(int[] data, int i, int length) {

        int temp = data[i];
        for(int k = i * 2 + 1;k < length;k *= 2 + 1){

            int max = data[k];
            if (k + 1 < length && data[k] < data[k + 1]){
                k++;
            }

            if (temp < data[k]){
                data[i] = data[k];
                i = k;
            }else{
                break;
            }

            data[i] = temp;
        }

    }

    public static void main(String[] args) {

        int[] arr = {4,6,8,5,9};
        //分布调整
        //stepAdjustHeap(arr);

        heapSort(arr);

        for (int i : arr) {
            System.out.printf("%d\t", i);
        }

    }

}
