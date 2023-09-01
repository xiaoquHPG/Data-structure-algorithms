package com.quruiqi.stack;

import java.util.Scanner;

/**
 * 栈
 * @Author Lenovo
 * @Date 2023/9/1 11:36
 **/
public class ArrayStack {

    //最大长度
    private int maxSize;

    //指针
    private int top;

    //初始化栈
    private Object[] stack;

    ArrayStack(int maxSize){
        this.maxSize = maxSize;
        this.top = -1;
        stack = new Object[maxSize];
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //栈满
    public boolean isFull(){
        return top == stack.length - 1;
    }

    //入栈
    public void push(int data){

        if (isFull()){
            throw new RuntimeException("栈满");
        }

        top++;
        stack[top] = data;
    }

    //出栈
    public int pop(){

        if (isEmpty()){
            throw new RuntimeException("栈空");
        }

        int result = (int) stack[top];
        top--;
        return result;
    }

    //栈顶值
    public int getTop(){

        if (isEmpty()){
            throw new RuntimeException("栈空");
        }

        return (int) stack[top + 1];
    }

    //遍历栈
    public void show(){

        if (isEmpty()){
            throw new RuntimeException("栈空");
        }

        for (int i = 0; i < stack.length; i++) {
            System.out.printf("%d\t", stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println("list:显示元素");
        System.out.println("push:添加数据");
        System.out.println("pop:获取数据");
        System.out.println("exit:退出程序");
        String index = "";
        while (loop){
            index = scanner.next();
            switch (index){
                case "list":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入：");
                    int i = scanner.nextInt();
                    stack.push(i);
                    break;
                case "pop":
                    Object pop = stack.pop();
                    System.out.println("obj="+pop);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("over~~~");
    }

}
