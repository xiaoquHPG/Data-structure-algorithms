package com.quruiqi.conventionalalgorithm;

/**
 * 二分查找
 * @Author Bill
 * @Date 2023/9/6 17:19
 **/
public class BinarySearch {

    //递归
    public int recursionBinarySearch(int[] data, int min, int max, int target){

        if (min > max){
            return -1;
        }

        int mid = min + ((max - min) >> 2);
        if (data[mid] == target){
            return mid;
        }else if (data[mid] > target){
            return recursionBinarySearch(data, min, mid - 1, target);
        }else{
            return recursionBinarySearch(data, mid + 1, max, target);
        }

    }

    //非递归
    public int noRecursionBinarySearch(int[] data, int target){

        int min = 0;
        int max = data.length - 1;
        while (min <= max){

            int mid = min + ((max - min) >> 1);
            if (data[mid] == target){
                return mid;
            }else if (data[mid] > target){
                max = mid - 1;
            }else{
                min = mid + 1;
            }

        }

        return -1;
    }

    //测试
    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        int data[] = {1,3,4,5,7,9,10,14,28,34,55,68};
        //非递归测试
        System.out.println(binarySearch.noRecursionBinarySearch(data, 5));
        //递归
        System.out.println(binarySearch.recursionBinarySearch(data, 0, data.length - 1, 5));

    }

}
