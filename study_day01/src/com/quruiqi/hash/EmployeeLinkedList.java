package com.quruiqi.hash;

/**
 * 员工链表
 * @Author Bill
 * @Date 2023/9/4 13:27
 **/
public class EmployeeLinkedList {

    private Employee head = null;

    //添加员工
    public void addEmp(Employee add){

        if (head == null){
            head = add;
            return;
        }

        Employee temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = add;

    }

    //遍历
    public void list(int no){

        if (head == null){
            System.out.println("第" + no + "链为空");
            return;
        }

        Employee temp = head;
        System.out.println("第" + no + "链数据为:");
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println();
    }

    public void findById(int id){

        if (head == null){
            System.out.println("id为:" + id + " 数据不存在");
            return;
        }

        Employee temp = head;
        while (temp != null){
            if (temp.id == id){
                System.out.print("已找到数据:");
                System.out.println(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("未找到该数据");
    }

}
