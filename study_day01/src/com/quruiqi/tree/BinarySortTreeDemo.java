package com.quruiqi.tree;

/**
 * @Author Lenovo
 * @Date 2023/9/6 8:25
 **/
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr ={7,3,10,12,5,1,9,11,13,2};
        BinarySortTree tree = new BinarySortTree();
        for (int i:arr) {
            BinarySortNode node = new BinarySortNode(i);
            tree.add(node);
        }
        tree.midOrder();
        // tree.preOrder();

        // 测试代码
        System.out.println("删除前 中序遍历: ");
        tree.midOrder();
        tree.delete(3);
        tree.delete(9);
        tree.delete(12);
        System.out.println("删除后 中序遍历: ");
        tree.midOrder();
    }

}
