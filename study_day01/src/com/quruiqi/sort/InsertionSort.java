package com.quruiqi.sort;

/**
 * 插入排序
 * @Author Bill
 * @Date 2023/9/3 19:56
 **/
public class InsertionSort {

    /**
     * 插入排序
     */
    public void insertionSort(int[] data){

        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]){
                    swap(data,j - 1,j);
                }
            }
        }

        for (int datum : data) {
            System.out.printf("%d\t", datum);
        }

    }

    private void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(new int[]{8,4,2,3,6,5,1,7});
    }

}
