package com.quruiqi.sort;

/**
 * 冒泡排序
 * @Author Bill
 * @Date 2023/9/3 16:32
 **/
public class BubbleSort {

    public void bubbleSort(int[] data){
        //做一次优化 如果在某一轮数组没有变动就结束
        boolean flag = false;
        for (int i = 0; i < data.length - 1; i++) {
            //这里就是减少比较次数
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]){
                    swap(data,j,j+1);
                    flag = true;
                }
            }
            if (!flag){
                break;
            }else{
                flag = false;
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
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(new int[]{5,7,8,6,9,2,4,1,3});

    }

}
