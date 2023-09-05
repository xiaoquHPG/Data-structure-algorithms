package com.quruiqi.tree;

/**
 * 二叉树
 * @Author Bill
 * @Date 2023/9/4 19:05
 **/
public class BinaryTree {

    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 先序
     */
    public void preOrder(){
        if (root == null){
            System.out.println("二叉树为空,不能先序遍历");
            return;
        }
        root.preOrderTraversal();
    }

    /**
     * 中序
     */
    public void inOrder(){
        if (root == null){
            System.out.println("二叉树为空,不能中序遍历");
            return;
        }
        root.inOrderTraversal();
    }

    /**
     * 后序
     */
    public void postOrder(){
        if (root == null){
            System.out.println("二叉树为空,不能后序遍历");
            return;
        }
        root.postOrderTraversal();
    }

    //前序查找
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    //中序查找
    public HeroNode inOrderSearch(int no){
        if(root !=null){
            return root.inOrderSearch(no);
        }else{
            return null;
        }
    }
    //后序查找
    public HeroNode postOrderSearch(int no){
        if(root !=null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }

    //删除节点
    public void delete(int no){
        if (root != null){
            root.delete(no);
        }else{
            System.out.println("二叉树为空");
        }
    }

}
