package com.quruiqi.tree;

import java.util.*;

/**
 * 哈夫曼编码
 * @Author Bill
 * @Date 2023/9/5 21:06
 **/
public class HuffmanCode {

    static Map<Byte, String> huffmanMap = new HashMap<>();

    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {

        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        //构建字节node list
        List<HuffmanCodeNode> list = getNodeList(bytes);
        //System.out.println(list);
        //创建哈夫曼树
        HuffmanCodeNode huffmanTree = createHuffmanTree(list);
        huffmanTree.preOrder(huffmanTree);

    }

    //生成哈夫曼树
    private static HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> list) {

        Collections.sort(list);

        while (list.size() > 1){

            HuffmanCodeNode left = list.get(0);
            HuffmanCodeNode right = list.get(1);

            HuffmanCodeNode huffmanCodeNode = new HuffmanCodeNode(null, left.weight + right.weight);
            huffmanCodeNode.left = left;
            huffmanCodeNode.right = right;

            list.remove(left);
            list.remove(right);
            list.add(huffmanCodeNode);

            Collections.sort(list);
        }

        return list.get(0);

    }

    private static List<HuffmanCodeNode> getNodeList(byte[] bytes) {
        List<HuffmanCodeNode> list = new ArrayList<>();
        Map<Byte,Integer> map = new HashMap<>();
        for (byte b:bytes) {
            Integer count = map.get(b);
            if(count==null){
                map.put(b,1);
            }else{
                map.put(b,++count);
            }
        }
        for (Map.Entry<Byte,Integer> entry:map.entrySet()) {
            list.add(new HuffmanCodeNode(entry.getKey(),entry.getValue()));
        }
        return list;
    }


    //获取哈夫曼编码
    public static Map<Byte, String> getCode(HuffmanCodeNode node){

        if (node == null){
            System.out.println("哈夫曼树为空");
            return huffmanMap;
        }

        getCodes(node.left, "0", stringBuilder);
        getCodes(node.right, "1", stringBuilder);
        return huffmanMap;

    }

    private static void getCodes(HuffmanCodeNode node, String s, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder.append(s);
        if (node != null){

            //为叶子节点有值
            if (node.data == null){
                getCodes(node.left, "0", stringBuilder1);
                getCodes(node.right, "1", stringBuilder1);
            }else{
                huffmanMap.put(node.data, stringBuilder1.toString());
            }

        }

    }


    //拿到哈夫曼编码
    private static byte[] zip(byte[] bytes, Map<Byte, String> map){

        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(map.get(aByte));
        }

        //拿到对应的串
        System.out.println(stringBuilder.toString());

        int num = (stringBuilder.length() + 7) / 8;
        byte[] result = new byte[num];
        int size = 0;
        for (int i = 0;i < stringBuilder.length();i +=8){

            String str;
            if (i + 8 > stringBuilder.length()){
                str = stringBuilder.substring(i);
            }else{
                str = stringBuilder.substring(i + 8);
            }

            result[size++] = (byte) Integer.parseInt(str, 2);
        }

        return result;
    }

    //解码
    private static byte[] decode(byte[] code, Map<Byte, String> map){

        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = 0;i < code.length;i++){

            if (i == code.length - 1){
                flag = true;
            }
            stringBuilder.append(byteToBitString(!flag,code[i]));
        }

        HashMap<String, Byte> stringByteHashMap = new HashMap<>();
        for (Map.Entry<Byte, String> byteStringEntry : map.entrySet()) {
            stringByteHashMap.put(byteStringEntry.getValue(), byteStringEntry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for (int i = 0;i < stringBuilder.length();){

            int count = 0;
            flag = true;
            Byte b = null;
            while (flag){

                String res = stringBuilder.substring(i, i + count);
                b = stringByteHashMap.get(res);

                if (b == null){
                    count++;
                }else{
                    list.add(b);
                }
                i += count;

            }

        }

        byte[] bytes = new byte[list.size()];
        for (int i = 0;i < list.size();i++){
            bytes[i] = list.get(i);
        }

        return bytes;

    }

    private static String byteToBitString(boolean b, byte s) {

        int temp = s;
        if (b){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (b){
            return str.substring(str.length() - 8);
        }else{
            return str;
        }

    }


}
