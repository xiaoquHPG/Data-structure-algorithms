package com.quruiqi.queue;

import java.util.Scanner;

/**
 * 队列
 * @Author Lenovo
 * @Date 2023/8/31 10:27
 **/
public class ArrayQueue {

    private int rear;

    private int front;

    private int maxSize;

    private Object[] queue;

    //初始化
    ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new Object[maxSize];
        rear = -1;
        front = -1;
    }

    //判断是否满队
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断是否队空
    public boolean isEmpty(){
        return rear == front;
    }

    //给队列添加数据
    public void addQueue(int data){

        //判断队满
        if (isFull()){
            throw new RuntimeException("队满");
        }

        rear++;
        queue[rear] = data;
    }

    //出队
    public int removeQueue(){

        //判断队空
        if (isEmpty()){
            throw new RuntimeException("队空");
        }

        front++;
        return (int) queue[front];
    }

    //拿出头一个数据
    public int getTop(){

        //判断对空
        if (isEmpty()){
            throw new RuntimeException("队空");
        }

        return (int) queue[front + 1];
    }

    //展示队列数据
    public void show(){
        if (isEmpty()){
            throw new RuntimeException("队空");
        }

        for (int i = 0; i < queue.length;i++){
            System.out.printf("%d\t", queue[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
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
