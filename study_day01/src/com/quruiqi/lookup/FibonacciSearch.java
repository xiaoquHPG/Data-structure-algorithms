package com.quruiqi.lookup;

import java.util.Arrays;

/**
 * 斐波那契查找
 * @Author Bill
 * @Date 2023/9/4 10:50
 **/
public class FibonacciSearch {

    /**
     * 斐波那契数列
     * 查找
     */
    public int fibonacciSearch(int[] data, int target){

        int low = 0;
        int high = data.length - 1;
        int k = 0;
        int fib[] = generFibArray(data.length);

        while (data.length > fib[k] - 1){
            k++;
        }

        int[] temp = Arrays.copyOf(data, fib[k] - 1);
        for (int i = data.length; i < temp.length; i++) {
            temp[i] = data[data.length - 1];
        }

        while (low < high){
            int mid = low + fib[k -1] - 1;
            if (target < temp[mid]){
                high = mid - 1;
                k -= 1;
            }else if (target > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                //这里可能会有看不懂 其实是这样的 我们上面通过temp数组重新分了一个数组 后面多出来的长度 补原数组最后一位
                //如果这里 他是 比data.length -1 位置大的下标 则就是原数组的 最后一位就ok了
                return Math.min(mid, data.length - 1);
            }
        }
        return -1;
    }

    private int[] generFibArray(int length) {
        int[] fib = new int[length];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static void main(String[] args) {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        System.out.println(fibonacciSearch.fibonacciSearch(new int[]{1, 4, 5, 7, 7, 8, 9, 11, 15, 15, 15, 24, 24, 28, 31}, 28));
    }

}
