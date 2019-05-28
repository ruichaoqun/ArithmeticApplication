package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rui Chaoqun
 * @description:
 * @date :2019/5/28 8:42
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */
public class Num30 {

    public static void main(String[] args) {
        String[] words = new String[]{"word","good","best","good"};
        findSubstring("wordgoodgoodgoodbestword", words);
    }

    /**
     *
     * @param s
     * @param words
     * @return
     * 滑动窗口解法：创建一个长度为所有words字符长度和的滑块，在字符串上游动，初始化一个map保存单词words以及每个单词出现的次数，
     * 在窗口滑动的时候，对窗口字符串进行切割成和words等大小的字符数组，分别对比是否包含在words的map中，没有则窗口右移，有则放入我们新建的一个map中，再判断map中
     * 的该word个数是否大于原words的map中该word个数，大于则窗口右移，不大于继续判断下一个字符。如果一个窗口所有切割字符都匹配，返回该窗口的起始位置
     * 窗口右移继续判断
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();

        if (words.length == 0) {
            return results;
        }

        int wordLength = words[0].length();
        //获取滑动窗口大小
        int countLength = words.length*wordLength;
        if (countLength > s.length()) {
            return results;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (wordMap.containsKey(words[i])) {
                wordMap.put(words[i], wordMap.get(words[i]) + 1);
            } else {
                wordMap.put(words[i], 1);
            }
        }


        for (int i = 0; i <= s.length() - countLength; i++) {
            String windowStr = s.substring(i, countLength + i);
            for (int j = 0; j < words.length; j++) {
                String str = windowStr.substring(wordLength * j, wordLength * (j + 1));
                if (!wordMap.containsKey(str)) {
                    map.clear();
                    break;
                }
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
                if (map.get(str) > wordMap.get(str)) {
                    map.clear();
                    break;
                }
                if (j == words.length - 1) {
                    map.clear();
                    results.add(i);

                }
            }
        }
        return results;
    }
}
