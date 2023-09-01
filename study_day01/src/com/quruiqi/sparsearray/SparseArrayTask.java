package com.quruiqi.sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 该练习之前的思路一样 不过我们需要将稀疏数组保存到磁盘 再从磁盘读取出来
 * @Author Lenovo
 * @Date 2023/8/31 9:51
 **/
public class SparseArrayTask {

    public static void main(String[] args) throws IOException {

        //初始化数组
        int[][] chessArray = new int[10][10];
        chessArray[2][4] = 2;
        chessArray[3][5] = 5;
        chessArray[4][2] = 8;
        chessArray[5][9] = 1;
        chessArray[6][7] = 10;

        //统计不为的0的数量
        int num = 0;
        for (int[] arr : chessArray) {
            for (int i : arr) {
                if (i != 0){
                    num++;
                }
            }
        }

        //初始化稀疏数组
        int[][] sparseArray = new int[num + 1][num + 1];
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = num;

        //拿到不为0的数据装入到稀疏数组
        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }

        //稀疏数组已准备好，放入磁盘当中
        File file = new File("D:\\datastructure\\map.data");
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < sparseArray.length; i++) {
            fileWriter.write(sparseArray[i][0] + " " + sparseArray[i][1] + " " + sparseArray[i][2]);
            fileWriter.write("\r\n");
        }
        fileWriter.close();

        //读取该数组内容还原稀疏数组
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        List<String> list = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null){
            list.add(line);
        }

        //拿出对应数据
        for (String s : list) {
            String[] arr = s.split(" ");
            System.out.printf("%s\t%s\t%s\t\n", arr[0], arr[1], arr[2]);
        }

        //关闭流
        bufferedReader.close();
    }

}
