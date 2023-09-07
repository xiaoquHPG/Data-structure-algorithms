package com.quruiqi.conventionalalgorithm;

import java.util.Arrays;

/**
 * 动态规划
 * @Author Bill
 * @Date 2023/9/6 19:18
 **/
public class DynamicProgramming {

    public static void main(String[] args) {

        int[] w = {1,4,3};
        int[] val = {1500,3000,2000};
        int c = 4;
        int n = w.length;

        int[][] v = new int[n + 1][c + 1];

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 1;i < v.length;i++){
            for (int j = 1;j < v[i].length;j++){
                if (w[i - 1] > j){
                    //装不下
                    v[i][j] = v[i - 1][j];
                }else{
                    //能装下
                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            System.out.println(Arrays.toString(v[i]));
        }

    }

}
