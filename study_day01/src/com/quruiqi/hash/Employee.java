package com.quruiqi.hash;

/**
 * 员工实体类
 * @Author Bill
 * @Date 2023/9/4 13:21
 **/
public class Employee {

    int id;

    String name;

    Employee next;

    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
