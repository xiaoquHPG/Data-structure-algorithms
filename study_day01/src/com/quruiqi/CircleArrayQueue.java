package com.quruiqi;

import java.util.Scanner;

/**
 * 环形队列
 * @Author Lenovo
 * @Date 2023/8/31 10:57
 **/
public class CircleArrayQueue {

    private int rear;

    private int front;

    private int maxSize;

    private Object[] queue;

    CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new Object[maxSize];
        rear = 0;
        front = 0;
    }

    //队满
    private boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //队空
    private boolean isEmpty(){
        return rear == front;
    }

    //往队列添加
    public void addQueue(int data){

        if (isFull()){
            throw new RuntimeException("队满");
        }

        queue[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    //取值
    public int removeQueue(){

        if (isEmpty()){
            throw new RuntimeException("队空");
        }

        int result = (int) queue[front];
        front = (front + 1) % maxSize;
        return result;

    }

    //展示
    public void show(){

        if (isEmpty()){
            throw new RuntimeException("队空");
        }

        for (int i = 0; i < queue.length; i++) {
            System.out.printf("%d\t", queue[i]);
        }
    }

    //拿到首值
    public int getTop(){

        if (isEmpty()){
            throw new RuntimeException("队空");
        }

        return (int) queue[front];

    }

    public static void main(String[] args) {
        //ArrayQueue queue = new ArrayQueue(3);
        //有效空间为3 有一个预留位置
        CircleArrayQueue queue = new CircleArrayQueue(4);
        String index = "";//接收用户字符串

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println("show:显示队列");
        System.out.println("add:添加数据");
        System.out.println("get:获取数据");
        System.out.println("head:显示对头数据");
        System.out.println("exit:退出程序");
        while (loop){
            index = scanner.next();//接收字符串
            switch (index){
                case "show":
                    queue.show();
                    break;
                case "add":
                    System.out.println("输入值：");
                    int i = scanner.nextInt();
                    queue.addQueue(i);
                    break;
                case "get":
                    try{
                        System.out.println("取出的数据为："+queue.removeQueue());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "head":
                    try{
                        System.out.println("对头数据为："+queue.getTop());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("测试完成");
    }

}
