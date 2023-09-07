package com.quruiqi.conventionalalgorithm;

/**
 * 分治算法
 * @Author Bill
 * @Date 2023/9/6 17:30
 **/
public class DivideAndConquer {



}
class  DACHannoiTower {

    public static void main(String[] args) {
        hannoiTower(5, "S", "T", "D");
    }

    private static void hannoiTower(int num, String A, String B, String C){
        if (num == 1){
            System.out.println("第" + num + "块移动到从" + A + " 到 " + C);
        }else{

            hannoiTower(num - 1, A, C, B);
            System.out.println("第" + num + "块移动到从" + A + "到" + C);
            hannoiTower(num - 1, B, A, C);
        }
    }

}