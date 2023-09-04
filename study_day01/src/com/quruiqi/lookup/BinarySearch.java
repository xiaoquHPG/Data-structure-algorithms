package com.quruiqi.lookup;

/**
 * 二分查找
 * @Author Bill
 * @Date 2023/9/4 9:33
 **/
public class BinarySearch {


    /**
     * 出现数字的次数
     * @param target
     */
    public void appearCountNumber(int[] data, int target){

        int min = 0;
        int max = data.length - 1;

        int mid = 0;
        while (min <= max){
            mid = min + ((max - min) >> 1);
            if (data[mid] == target){
                break;
            }else if (data[mid] < target){
                min = mid + 1;
            }else if (data[mid] > target){
                max = mid - 1;
            }
        }

        if (min > max){
            System.out.println("这数字不存在");
            return;
        }

        int count = 1;
        int left = mid - 1;
        int right = mid + 1;
        //max是目标数
        System.out.printf("%d\t", mid);
        while (left > 0 && data[left] == target){
            System.out.printf("%d\t", left);
            left--;
            count++;
        }
        while (right < data.length - 1 && data[right] == target){
            System.out.printf("%d\t", right);
            right++;
            count++;
        }

        System.out.println();
        System.out.println("------------------------");
        System.out.println("出现了:" + count + "次");
    }

    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.appearCountNumber(new int[]{1,4,6,6,6,8,9,10,11,14,14,14,14,15,15,15,40,45},1);

    }

}
