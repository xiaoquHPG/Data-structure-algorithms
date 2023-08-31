package com.quruiqi.LinkedList;

/**
 * 循环单向链表
 * @Author Lenovo
 * @Date 2023/8/31 21:22
 **/
public class CircleSingleLinkedList {

    private Boy first = null;

    //添加n个孩子节点
    public void addBoy(int n){

        if (n < 1){
            throw new RuntimeException("入参非法");
        }

        Boy cur = new Boy(0);
        for (int i = 0; i < n; i++) {
            Boy boy = new Boy(i + 1);
            if (i == 0){
                first = boy;
                cur = first;
                first.next = first;
            }else{
                cur.next = boy;
                cur = boy;
                boy.next = first;
            }
        }
    }

    //遍历环形链表
    public void show(){

        Boy temp = first;
        do{
            System.out.println(temp);
            temp = temp.next;
        }while (temp != first);

    }

    /**
     *
     * @param startNo 起始号
     * @param countNum 数几下
     * @param nums 几个小孩
     */
    public void countBoy(int startNo, int countNum, int nums){

        if (first == null || startNo < 1 || startNo > nums){
            return;
        }

        //定义一个尾指针跟着first
        Boy rear = first;
        //先让rear跟到fist后面
        while (rear.next != first){
            rear = rear.next;
        }
        //先走startNo - 1步
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            rear = rear.next;
        }

        while (true){
            if (rear == first){
                System.out.printf("%d",rear.no);
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                rear = rear.next;
            }
            System.out.printf("%d\t", first.no);
            first = first.next;
            rear.next = first;
        }

    }

    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
//        circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(1, 2, 5);


    }

}
