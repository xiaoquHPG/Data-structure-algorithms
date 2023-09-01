package com.quruiqi.sparsearray;

/**
 * 稀疏数组
 * @Author Lenovo
 * @Date 2023/8/30 20:52
 **/
public class SparseArray {

    public static void main(String[] args) {

        //原始二维数组
        int[][] chessArray = new int[10][10];
        chessArray[2][1] = 2;
        chessArray[4][6] = 10;
        chessArray[7][2] = 4;
        chessArray[8][3] = 5;

        int m = 0;
        for (int[] arrs : chessArray) {
            for (int arr : arrs) {
                if (arr != 0){
                  m++;
                }
            }
        }

        //初始化稀疏数组
        int[][] sparseArr = new int[m + 1][3];
        sparseArr[0][0] = chessArray.length;
        sparseArr[0][1] = chessArray[0].length;
        sparseArr[0][2] = m;

        //将原始数组值保留到里面
        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray[i][j];
                }
            }
        }

        //拿到系数数组了
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //将稀疏数组还原为原始数组
        int[][] chessArray1 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArray1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("还原二维数组");
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                System.out.printf("%d\t", chessArray1[i][j]);
            }
            System.out.println();
        }

    }

}
