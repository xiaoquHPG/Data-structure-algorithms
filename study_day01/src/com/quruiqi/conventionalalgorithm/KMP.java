package com.quruiqi.conventionalalgorithm;

/**
 * KMP算法
 * @Author Bill
 * @Date 2023/9/7 10:06
 **/
public class KMP {

    //暴力匹配
    public int violenceMatch(String str, String sub){


        int pre = 0;
        int next = 0;
        for (int i = 0;i < str.length();){
            pre = i;
            next = 0;
            while (next < sub.length() && str.charAt(i) == sub.charAt(next)){
                i++;
                next++;
            }
            if (next == sub.length()){
                return pre;
            }
            i = pre + 1;
        }

        return -1;
    }


    //KMP
    public int kmp(String str, String sub){

        int k = 0;
        //先获取一个回溯的数组
        int[] next = getNext(sub);
        for (int i = 0;i < str.length();i++){

            //跟next里面的道理是一样的 这里如果匹配不到了  我们就回到 上一个位置匹配
            while (k > 0 && str.charAt(i) != sub.charAt(k)){
                k = next[k - 1];
            }
            //计数
            if (str.charAt(i) == sub.charAt(k)){
                k++;
            }
            //发现 他等于子串长度了 就是匹配成功了 返回
            if (k == sub.length()){
                return i - k + 1;
            }
        }

        return -1;
    }

    //根据匹配串获取到一个回溯的数组
    private int[] getNext(String sub) {

        int[] next = new int[sub.length()];
        int k = 0;
        for (int i = 1;i < sub.length();i++){
            //如果当前不匹配了 回到上一个（想象下 abctabcw） 匹配到w不行了 回到 c 对应的值 3  也就是 从t开始重新匹配 就是这个道理 想明白就简单了
            while (k > 0 && sub.charAt(k) != sub.charAt(i)){
                k = next[k - 1];
            }
            //累计技术
            if (sub.charAt(k) == sub.charAt(i)){
                k++;
            }
            //当前数组赋值
            next[i] = k;
        }
        return next;

    }

    public static void main(String[] args) {

        KMP kmp = new KMP();
        System.out.println(kmp.violenceMatch("cecaeaqceq","qc"));
        System.out.println(kmp.violenceMatch("cecaeaqceq","ceq"));
        System.out.println(kmp.violenceMatch("cecaeaqceq","rc2"));
        System.out.println(kmp.violenceMatch("ceacaeceaa", "caecae"));

        System.out.println(kmp.kmp("cecaeaqceq","qc"));
        System.out.println(kmp.kmp("cecaeaqceq","ceq"));
        System.out.println(kmp.kmp("cecaeaqceq","rc2"));
        System.out.println(kmp.kmp("ceacaeceaa", "caecae"));



    }

}
