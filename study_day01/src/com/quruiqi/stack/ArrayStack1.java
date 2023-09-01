package com.quruiqi.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 计算器
 * @Author Lenovo
 * @Date 2023/9/1 14:04
 **/
public class ArrayStack1 {

    //这里不写栈了直接用leetcode的题来

    /**
     *给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，
     * 这道题 之前已经写过， 这次写直接按照之前写的方式写了
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int result = 0;
        int n = s.length();
        int sign = 1;
        int i = 0;
        while(i < n){
            if(s.charAt(i) == ' '){
                i++;
            }else if(s.charAt(i) == '+'){
                sign = stack.peek();
                i++;
            }else if(s.charAt(i) == '-'){
                sign = -stack.peek();
                i++;
            }else if(s.charAt(i) == '('){
                stack.push(sign);
                i++;
            }else if(s.charAt(i) == ')'){
                stack.pop();
                i++;
            }else{
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }

    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     *
     * 整数除法仅保留整数部分。 之前leetcode已经写过  直接按照思路写
     * @param s
     * @return
     */
    public int calculate1(String s) {

        Stack<Integer> stack = new Stack<>();
        char a = '+';
        int n = s.length();
        int num = 0;
        int result = 0;
        for(int i = 0;i < n;i++){
            if(i <n && Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1){
                switch(a){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                a = s.charAt(i);
                num = 0;
            }
        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;

    }

    /**
     * 逆波兰表达式
     * leetcode原题  直接按照原思路 书写
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < tokens.length;i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i].equals("-")){
                int two = stack.pop();
                int first = stack.pop();
                stack.push(first - two);
            }else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(tokens[i].equals("/")){
                int two = stack.pop();
                int first = stack.pop();
                stack.push(first / two);
            }else{
                //其次是数字
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }
        return stack.pop();
    }

}
