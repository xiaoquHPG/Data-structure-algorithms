package com.quruiqi.sort;

/**
 * 希尔排序
 * @Author Bill
 * @Date 2023/9/3 20:26
 **/
public class ShellSort {

    /**
     * 希尔排序 不断去分组  一组 一组去排序 最终到达一个排序的效果 如果
     * @param data
     */
    public void shellSort(int[] data){

        //该算法我加入注释
        //我不断去分组 该组内进行排序
        for (int i = data.length / 2;i >= 1;i /=2){
            for (int j = i; j < data.length; j++) {
                //记录当前值 不断往前找符合条件的值
                int temp = data[j];
                int k = j - i;
                while (k >= 0 && data[k] > temp){
                    //找到后 继续往前找
                    data[j] = data[k];
                    k -= i;
                }
                //最终就是合适的位置 放入记录的temp
                data[k + i] = temp;
            }
        }

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d\t", data[i]);
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(new int[]{8,1,2,4,3,6,7,9});
    }

}
