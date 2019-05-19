package com.example.arithmeticapplication.leecode;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 2:abc  3:def 4:ghi 5:jkl 6:mno 7：pqrs 8:tuv 9:wxyz
 */
public class Num17 {

    public static void main(String[] args){
//        letterCombinations("23");
//        System.out.println("args = [" + (Integer.valueOf('2') - 48) + "]");
        System.out.println(letterCombinations1("23"));
    }

    static char[][] comparisonArr = new char[][]{{}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};


    public static List<String> letterCombinations(String digits) {
           List<String> list = new ArrayList<>();
        //遍历字符串
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            //获取当前数字字符对应的字符数组，例如2对应a,b,c字符数组
            char[] chars = comparisonArr[c - 49];
            //如果结果集合大小为0，放入第一次遍历的字符数组，此时i是0
            //例如，此时i=0，c=2，放入后结果集合变成"a","b","c"了
            if(list.size() == 0){
                for (int j = 0; j < chars.length; j++) {
                    list.add(String.valueOf(chars[j]));
                }
                continue;
            }

            //拿到结果集合大小
            int currentLength = list.size();
            //从1开始遍历字符数组"a","b","c"
            //这一步操完完后结果集变成"a","b","c","ae","be","ce","af","bf","cf"了
            for (int j = 1; j < chars.length; j++) {
                //遍历结果集合，新增字符串
                for (int k = 0; k < currentLength; k++) {
                    list.add(list.get(k)+chars[j]);
                }
            }
            //再将开始结果集的前size个重新赋值
            //操作完结果集是"ad","bd","cd","ae","be","ce","af","bf","cf"
            for (int j = 0; j < currentLength; j++) {
                list.set(j,list.get(j)+chars[0]);
            }
        }
        return list;
    }

    /**
     * 使用递归解法
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return list;
        }
        letterCombin(digits,0,list,new StringBuilder(),1);
        System.out.println("buildCount-->"+1);
        return list;
    }

    public static void letterCombin(String digits,int index,List<String> list,StringBuilder builder,int buildCount) {
        if(index == digits.length()){
            list.add(builder.toString());
            builder.delete(0,builder.length());
            return ;
        }

        char c = digits.charAt(index);
        //获取当前数字字符对应的字符数组，例如2对应a,b,c字符数组
        char[] chars = comparisonArr[c - 49];
        for (int i = 0; i < chars.length; i++) {
            letterCombin(digits,index+1,list,new StringBuilder(builder).append(chars[i]),buildCount+1);
            System.out.println("buildCount-->"+buildCount);
        }
    }

}
