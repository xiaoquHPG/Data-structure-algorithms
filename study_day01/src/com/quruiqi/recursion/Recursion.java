package com.quruiqi.recursion;

import java.util.*;

/**
 * google编程大赛   球和篮子
 * @Author Lenovo
 * @Date 2023/9/3 12:15
 **/
public class Recursion {

    /**
     * 球归类到篮子里面的情况有多少种
     * 递归写法   好像网上没有
     * @return
     */
    int countWays(int baskets, int capacity, int balls){

        //不符合条件的情况
        if (baskets * capacity < balls){
            return 0;
        }

        if (baskets == 1){
            return 1;
        }

        int result = 0;
        for (int i = 0; i <= capacity; i++) {
            if (balls - i >= 0){
                result+= countWays(baskets - 1, capacity, balls - i);
            }
        }
        return result;
    }


    /**
     * 迷宫回溯
     * @param
     */
    public void labyrinth(){

        //迷宫问题 先绘制地图
        int[][] map = new int[7][8];

        //把临界设限制
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || j == 0 || i == map.length - 1 || j == map[i].length - 1){
                    map[i][j] = 1;
                }
            }
        }

        //从（1，1）开始走迷宫
        boolean b = setWay(map, 1, 1);

        //查询迷宫走
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%d\t", map[i][j]);
            }
            System.out.println();
        }
    }


    //迷宫找路策略
    public static boolean setWay(int[][] map, int i,int j){
        //已经找到路
        if (map[map.length - 2][map[0].length - 2] == 2){
            return true;
        }
        //说明路可以走
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay(map, i + 1, j)) {
                return true;
            } else if (setWay(map, i, j + 1)) {
                return true;
            } else if (setWay(map, i - 1, j)) {
                return true;
            } else if (setWay(map, i, j - 1)) {
                return true;
            } else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * 八皇后问题
     * 这个题目要说一下思路 核心点找不同的方法，其次是不能在同一列， 不能对角线，如下方式 我们去记录已经不能放的列和 对角线 然后依次递归拿到不同结果
     * 就ok了   这个题目之前学的时候 已经写过了 不过当时对算法的理解太浅  现在好很多
     * @param n
     */
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new ArrayList<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> dias1 = new HashSet<>();
        Set<Integer> dias2 = new HashSet<>();
        backtrack(list, result, n, 0, columns, dias1, dias2);
        return list;

    }

    public void backtrack(List<List<String>> list,int[] result, int n,int row,Set<Integer> colu,Set<Integer> dias1,Set<Integer> dias2){
        if(n == row){
            list.add(gen(result,n));
        }else{
            for(int i = 0;i < n;i++){
                if(colu.contains(i)){
                    continue;
                }
                int dias11 = row - i;
                if(dias1.contains(row - i)){
                    continue;
                }

                int dias22 = row + i;
                if(dias2.contains(row + i)){
                    continue;
                }
                result[row] = i;
                colu.add(i);
                dias1.add(dias11);
                dias2.add(dias22);
                backtrack(list, result, n, row + 1,colu, dias1, dias2);
                result[row] = -1;
                colu.remove(i);
                dias1.remove(dias11);
                dias2.remove(dias22);
            }
        }
    }

    public List<String> gen(int[] result,int n){
        List<String> board = new ArrayList<>();
        for(int i = 0;i < n;i++){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[result[i]] = 'Q';
            board.add(new String(String.valueOf(row)));
        }
        return board;
    }

    //测试
    public static void main(String[] args) {

        Recursion ballAndBasket = new Recursion();
//        System.out.println(ballAndBasket.countWays(2, 20, 2));
        ballAndBasket.labyrinth();

        String a = "x";
        char[] chars = a.toCharArray();
    }

}
