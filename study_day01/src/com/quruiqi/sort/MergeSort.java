package com.quruiqi.sort;

/**
 * 归并排序
 * @Author Bill
 * @Date 2023/9/3 21:38
 **/
public class MergeSort {

    /**
     * 归并排序
     * @param data
     */
    public void mergeSort(int[] data){

        sort(data, 0, data.length - 1);

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d\t", data[i]);
        }
    }

    private void sort(int[] data,int min, int max) {

        if (min >= max){
            return;
        }

        int mid = min + ((max - min) >> 1);
        sort(data, min, mid);
        sort(data, mid + 1, max);
        merge(data, min, mid, max);
    }

    private void merge(int[] data, int min,int mid, int max){

        int[] temp = new int[max - min + 1];
        int i = 0;
        int j = min;
        int k = mid + 1;
        while (j <= mid && k <= max ){
            if (data[j] < data[k]){
                temp[i++] = data[j++];
            }else{
                temp[i++] = data[k++];
            }
        }

        while (j <= mid){
            temp[i++] = data[j++];
        }

        while (k <= max){
            temp[i++] = data[k++];
        }

        for (int l = 0; l < temp.length; l++) {
            data[min + l] = temp[l];
        }

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(new int[]{8,5,4,2,6,7,9,2,1});
    }

}
