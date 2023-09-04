package com.quruiqi.hash;

import java.util.Scanner;

/**
 * 哈希表
 * @Author Bill
 * @Date 2023/9/4 13:38
 **/
public class HashTable {

    private EmployeeLinkedList[] employeeLinkedLists;
    private int size;

    HashTable(int size){
        this.size = size;
        employeeLinkedLists = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
    }

    //添加
    void add(Employee emp){
        int index = emp.id % size;
        employeeLinkedLists[index].addEmp(emp);
    }

    //遍历
    void list(){
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i].list(i);
        }
    }

    //寻找id
    void findById(int id){
        int index = id % size;
        employeeLinkedLists[index].findById(id);
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(5);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("add:添加员工");
        System.out.println("list:显示员工");
        System.out.println("find:查找员工");
        System.out.println("exit:退出系统");

        while(true){
            System.out.println("请选择操作：");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入 id");
                    int id = scanner.nextInt();
                    System.out.println("输入 姓名");
                    String name = scanner.next();
                    Employee emp = new Employee(id,name);
                    table.add(emp);
                    break;
                case "list":
                    table.list();
                    break;
                case "find":
                    System.out.println("输入查找id");
                    id = scanner.nextInt();
                    table.findById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }

    }

}
