package com.quruiqi.conventionalalgorithm;

import java.util.*;

/**
 * 贪心算法
 * @Author Bill
 * @Date 2023/9/7 11:52
 **/
public class Greedy {

    public static void main(String[] args) {

        Map<String, Set<String>> broadcast = new HashMap<>();

        Set<String> k1 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");

        Set<String> k2 = new HashSet<>();
        k2.add("广州");
        k2.add("上海");
        k2.add("深圳");

        Set<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");

        Set<String> k4 = new HashSet<>();
        k4.add("上海");
        k4.add("天津");

        Set<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");

        broadcast.put("k1",k1);
        broadcast.put("k2",k2);
        broadcast.put("k3",k3);
        broadcast.put("k4",k4);
        broadcast.put("k5",k5);

        Set<String> allArea =  new HashSet<>();

        for (Map.Entry<String,Set<String>> entry:broadcast.entrySet()){
            allArea.addAll(entry.getValue());
        }
        System.out.println(allArea);

        List<String> select = new ArrayList<>();
        Set<String> tempArea = new HashSet<>();
        String maxKey = "";
        while (allArea.size() > 0){

            //每轮我们都选择一个最优解 就是如此
            maxKey = "";
            for (String s : broadcast.keySet()) {

                tempArea.clear();
                Set<String> stringSet = broadcast.get(s);
                tempArea.addAll(stringSet);
                tempArea.retainAll(allArea);
                if (tempArea.size() > 0 && ("".equals(maxKey) || tempArea.size() > broadcast.get(s).size())){
                    maxKey = s;
                }
            }
            if (!"".equals(maxKey)){
                select.add(maxKey);
                allArea.removeAll(broadcast.get(maxKey));
            }

        }

        System.out.println(select);

    }

}
