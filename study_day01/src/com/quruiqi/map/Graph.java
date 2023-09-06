package com.quruiqi.map;

import java.util.*;

/**
 * 邻接矩阵
 * @Author Bill
 * @Date 2023/9/6 14:51
 **/
public class Graph {

    private ArrayList<String> vertexList;

    private int[][] edges;

    private int edgeNum = 0;

    boolean[] isVisited;

    Graph(int num){
        isVisited = new boolean[num];
        vertexList = new ArrayList<>();
        edges = new int[num][num];

    }

    //返回图的节点个数
    public int getNumberOfVertex(){
        return vertexList.size();
    }

    //返回边个数
    public int getEdgeNum(){
        return edgeNum;
    }

    //返回下标对应的节点
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回对应位置权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //展示
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //插入路线
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeNum++;
    }

    public static void main(String[] args) {
        int num = 5;
        String[] vertexArr = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(8);

        for (String vertex:vertexArr) {
            graph.insertVertex(vertex);
        }
        // A-B A-C  B-C  B-D   E-B
//        graph.insertEdge(0,1,1);//A-B
//        graph.insertEdge(0,2,1);//A-C
//        graph.insertEdge(1,2,1);//B-C
//        graph.insertEdge(1,3,1);//B-D
//        graph.insertEdge(1,4,1);//E-B

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2 ,1);
        graph.insertEdge(1, 3 ,1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);


        graph.showGraph();
        System.out.println("深度优先遍历");
        graph.DFS(0);
        System.out.println();
        System.out.println("广度优先遍历");
        graph.BFS(0);
    }

    //广度优先遍历
    public void BFS(int i){

        for (int j = 0; j < isVisited.length; j++) {
            isVisited[j] = false;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int k = 0; k < vertexList.size(); k++) {
            if (!isVisited[k]){
                //说明没访问过
                isVisited[k] = true;
                System.out.print(vertexList.get(k) + "->");
                queue.add(k);
                while (!queue.isEmpty()){
                    Integer poll = queue.poll();
                    for (int p = 0; p < vertexList.size(); p++) {
                        if (edges[poll][p] == 1 && !isVisited[p]){
                            isVisited[p] = true;
                            System.out.print(vertexList.get(p) + "->");
                            queue.add(p);
                        }
                    }
                }
            }
        }

    }

    //深度优先遍历
    public void DFS(int i){

        System.out.print(vertexList.get(i) + "->");
        isVisited[i] = true;
        for (int j = 0;j < vertexList.size();j++){
            if (!isVisited[j] && edges[i][j] != 0){
                    DFS(j);
            }
        }

    }

}
