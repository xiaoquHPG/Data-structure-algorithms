package com.quruiqi.linkedList;

import java.util.Objects;
import java.util.Stack;

/**
 * 单链表
 * @Author Lenovo
 * @Date 2023/8/31 16:15
 **/
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, null, null);

    //添加
    public void add(HeroNode addNode){

        HeroNode temp = head;
        while (temp.nextNode != null){
            temp = temp.nextNode;
        }

        temp.nextNode = addNode;
    }

    //添加按照顺序
    public void addOrder(HeroNode addNode){

        HeroNode temp = head;
        //我们借助一个辅助节点
        HeroNode pre = null;
        //正常遍历
        while (temp.nextNode != null){
            //记录前一个节点
            pre = temp;
            temp = temp.nextNode;
            //如果当前节点序号比添加的大我们用辅助节点衔接上
            if (temp.num > addNode.num){
                pre.nextNode = addNode;
                addNode.nextNode = temp;
                return;
            }
        }

        //如果正常编辑完说明序号最大或相等直接加末尾
        temp.nextNode = addNode;


    }

    //遍历
    public void show(){

        if (head.nextNode == null){
            throw new RuntimeException("链表为空");
        }

        HeroNode temp = head.nextNode;
        while (temp != null){
            System.out.println(temp);
            temp = temp.nextNode;
        }
    }

    //修改节点
    public void update(HeroNode updateNode){

        if (Objects.isNull(updateNode)){
            throw new RuntimeException("修改节点不能为空哦");
        }

        HeroNode temp = head;
        HeroNode pre = null;
        while (temp.nextNode != null){
            pre = temp;
            temp = temp.nextNode;
            if (updateNode.num == temp.num){
                //说明是该节点
                pre.nextNode = updateNode;
                updateNode.nextNode = temp.nextNode;
            }
        }

    }

    //删除节点
    public void remove(int num){

        HeroNode temp = head;
        HeroNode pre = null;
        while (temp.nextNode != null){
            pre = temp;
            temp = temp.nextNode;
            if (temp.num == num){
                pre.nextNode = temp.nextNode;
            }
        }

    }

    //获取链表长度
    public int getSize(){

        int count = 0;
        HeroNode temp = head;
        while (temp.nextNode != null){
            count++;
            temp = temp.nextNode;
        }
        return count;

    }

    /**
     * 需求  求单链表的倒数第n个节点 leetcode上面的一道题
     * 多种做法 我们可以利用快慢指针  一个指针比另一个快n步就好
     * 也可以拿到链表长度 求size - n的节点
     * 开干
     */
    public HeroNode findNodeStartLast(int n){

        //求size - n的节点
        //获取到链表长度
        HeroNode temp = head;
        int size = getSize();
        if (size - n < 0){
            throw new RuntimeException("不合法");
        }else if (size == n){
            return head.nextNode;
        }
//
//        for (int i = 0;i <= (size - n);i++){
//            temp = temp.nextNode;
//        }
//        return temp;


        //通过快慢指针解决问题
        HeroNode next = head;
        int  x = n;
        while (x-- != 0){
            next = next.nextNode;
        }

        while (next != null){
            next = next.nextNode;
            temp = temp.nextNode;
        }
        return temp;

    }

    /**
     * 反转链表
     * 这里我不会跟面试题中正规入参方式来写  按照自己的方式
     */
    public void reverse(){

        if (head.nextNode == null) {
            return;
        }

        //反转链表
        HeroNode first = head.nextNode;
        HeroNode pre = null;
        while (first != null){
            HeroNode temp = first.nextNode;
            first.nextNode = pre;
            pre = first;
            first = temp;
        }

        while (pre != null){
            System.out.println(pre);
            pre = pre.nextNode;
        }
    }

    /**
     * 从尾到头打印单链表
     * 压栈
     */
    public void reverseShow(){

        if (head.nextNode == null) {
            return;
        }

        //初始化栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head;
        while (temp.nextNode != null){
            temp = temp.nextNode;
            stack.push(temp);
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    /**
     * 合并有序链表 我去leetcode上面 a后 拿下来  递归实现
     * @param args
     */
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1 == null){
//            return list2;
//        }else if(list2 == null){
//            return list1;
//        }else if(list1.val <= list2.val){
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        }else{
//            list2.next = mergeTwoLists(list1, list2.next);
//            return list2;
//        }
//    }

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(7,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(1,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"林冲","豹子头");
        HeroNode node5 = new HeroNode(5,"xxwa","cec");
        HeroNode node6 = new HeroNode(8,"xxwcwa","ceacacec");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addOrder(node1);
        linkedList.addOrder(node3);
        linkedList.addOrder(node2);
        linkedList.addOrder(node4);
        linkedList.addOrder(node5);
        linkedList.addOrder(node6);
        linkedList.update(new HeroNode(4, "勇士", "瑞琪"));
        linkedList.show();
        System.out.println(linkedList.getSize());
        System.out.println(linkedList.findNodeStartLast(1));
        System.out.println("反转链表");
//        linkedList.reverse();
        linkedList.reverseShow();
    }

}
