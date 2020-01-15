package com.example.arithmeticapplication.leecode.dynamicplanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2020/1/15 9:34
 * description:给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 */
public class Num140 {
    public static void main(String[] args) {
        Num140 num140 = new Num140();
        List<String> list = num140.wordBreak("aaaaaaa", new ArrayList<String>(Arrays.asList(new String[]{"aaaa","aa","a"})));
        for (int i = 0; i < list.size(); i++) {
            System.out.println("args = [" + list.get(i) + "]");
        }
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            List<String> stringlist = new ArrayList<>();
            String t = s.substring(0,i);
            for (int j = 0; j < wordDict.size(); j++) {
                if(t.endsWith(wordDict.get(j))){
                    if(t.length() == wordDict.get(j).length()){
                        stringlist.add(wordDict.get(j));
                    }else{
                        List<String> list1 = list.get(t.length() - wordDict.get(j).length() - 1);
                        for (int k = 0; k < list1.size(); k++) {
                            stringlist.add(list1.get(k)+" "+wordDict.get(j));
                        }
                    }
                 }
            }
            list.add(stringlist);
        }
        return list.get(list.size()-1);
    }
}
