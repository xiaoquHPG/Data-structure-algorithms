package com.quruiqi.conventionalalgorithm;

import java.util.Arrays;

/**
 * 普利姆算法
 * @Author Bill
 * @Date 2023/9/7 13:45
 **/
public class Prim {

    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000 这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2}, // A
                {5,10000,10000,9,10000,10000,3}, // B
                {7,10000,10000,10000,8,10000,10000}, // C
                {10000,9,10000,10000,10000,4,10000}, // D
                {10000,10000,8,10000,10000,5,4}, // E
                {10000,10000,10000,4,5,10000,6}, // F
                {2,3,10000,10000,4,6,10000}}; // G

        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);
    }

}
class MinTree{

    //初始化
    public void createGraph(MGraph mGraph, int verxs, char[] data, int[][] weight) {
        for (int i = 0; i < verxs; i++) {
            mGraph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                mGraph.wight[i][j] = weight[i][j];
            }
        }
    }

    //展示图
    public void showGraph(MGraph mGraph) {
        for (int[] ints : mGraph.wight) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //普利姆算法
    public void prim(MGraph mGraph, int i) {

        int[] isVisited = new int[mGraph.verxs];
        isVisited[i] = 1;

        int p1 = -1;
        int p2 = -1;
        int minWight = Integer.MAX_VALUE;

        //找n - 1轮
        for (int j = 1; j < mGraph.verxs; j++) {
            //每一次找一个 优解 在已经点亮过的点
            for (int k = 0; k < mGraph.wight.length; k++) {
                for (int p = 0; p < mGraph.wight[k].length; p++) {
                    if (isVisited[k] == 1 && isVisited[p] != 1 && mGraph.wight[k][p] < minWight){
                        minWight = mGraph.wight[k][p];
                        p1 = k;
                        p2 = p;
                    }
                }
            }
            System.out.print("从" + mGraph.data[p1] + "到" + mGraph.data[p2] + "----->");
            minWight = Integer.MAX_VALUE;
            isVisited[p2] = 1;
        }

    }
}
class MGraph{
    int verxs;
    char[] data;
    int[][] wight;

    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        wight = new int[verxs][verxs];
    }
}
