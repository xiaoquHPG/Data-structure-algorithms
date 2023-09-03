package com.quruiqi.sort;

/**
 * 选择排序算法
 * @Author Bill
 * @Date 2023/9/3 19:33
 **/
public class SelectionSort {

    /**
     * 选择排序
     */
    public void selectionSort(int[] data){

        for (int i = data.length - 1; i > 0; i--) {
            int max = Integer.MIN_VALUE;
            int k = -1;
            for (int j = 0;j <= i;j++){
                if (data[j] > max){
                    max = data[j];
                    k = j;
                }
            }
            if (k != -1){
                swap(data,i,k);
            }
        }

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d\t", data[i]);
        }

    }

    private void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(new int[]{8,4,2,6,7,1,6});
    }

}
