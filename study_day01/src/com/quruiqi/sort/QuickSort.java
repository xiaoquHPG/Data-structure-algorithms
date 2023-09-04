package com.quruiqi.sort;

/**
 * 快速排序
 * @Author Bill
 * @Date 2023/9/3 21:10
 **/
public class QuickSort {

    public void quickSort(int[] data){

        sort(data, data.length - 1, 0);

        for (int datum : data) {
            System.out.printf("%d\t", datum);
        }
    }

    private void sort(int []data, int max, int min){

        if (min >= max){
            return;
        }

        int i = min;
        int j = max;
        int val = data[i];
        while (i < j){

            while (i < j && data[j] >= val){
                j--;
            }
            //这里我得注释下 如上条件感觉像是反的  其实是他while停下来说明  data【j】 < val了
            if (i < j){
                data[i++]  = data[j];
            }
            while (i < j && data[i] < val){
                i++;
            }
            //跟上面同理
            if (i < j){
                data[j--] = data[i];
            }
        }
        //把这个节点的值 重新赋值就欧克了
        data[i] = val;
        //再次循环
        sort(data, i - 1, min);
        sort(data, max, i + 1);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(new int[]{8,2,6,3,4,9,2,5,7});
    }

}
