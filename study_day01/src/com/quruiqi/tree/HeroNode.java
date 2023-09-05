package com.quruiqi.tree;

/**
 * 树节点
 * @Author Bill
 * @Date 2023/9/4 14:51
 **/
public class HeroNode {

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    HeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //先序遍历
    public void preOrderTraversal(){

        System.out.println(this);
        if (this.left != null){
            this.left.preOrderTraversal();
        }

        if (this.right != null){
            this.right.preOrderTraversal();
        }

    }

    //先序查找
    public HeroNode preOrderSearch(int no){

        if (this.no == no){
            return this;
        }

        HeroNode result = null;
        if (this.left != null){
            result = this.left.preOrderSearch(no);
        }

        if (result != null){
            return result;
        }

        if (this.right != null){
            result = this.right.preOrderSearch(no);
        }

        return result;

    }

    //中序遍历
    public void inOrderTraversal(){
        if (this.left != null){
            this.left.inOrderTraversal();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.inOrderTraversal();
        }
    }

    //中序遍历查找
    public HeroNode inOrderSearch(int no){

        HeroNode result = null;
        if (this.left != null){
            result = this.left.inOrderSearch(no);
        }

        if (result != null){
            return result;
        }

        if (this.no == no){
            return this;
        }

        if (this.right != null){
            result = this.right.inOrderSearch(no);
        }
        return result;
    }

    //后续遍历
    public void postOrderTraversal(){
        if (this.left != null){
            this.left.postOrderTraversal();
        }
        if (this.right != null){
            this.right.postOrderTraversal();
        }
        System.out.println(this);
    }

    //后续遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode result = null;
        if (this.left != null){
            result = this.left.postOrderSearch(no);
        }
        if (result != null){
            return result;
        }
        if (this.right != null){
            result = this.right.postOrderSearch(no);
        }
        if (result != null){
            return  result;
        }
        if (this.no == no){
            return this;
        }
        return result;
    }

    //删除节点 叶子节点单删， 非叶子节点子树都删
    public void delete(int no){

        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if (this.left != null){
            this.left.delete(no);
        }

        if (this.right != null){
            this.right.delete(no);
        }

    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}
