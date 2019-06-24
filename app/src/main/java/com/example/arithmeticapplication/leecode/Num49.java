package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num49 {
    //计数法当做key
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap<>();
        int[] num = new int[26];
        for (String s:strs) {
            Arrays.fill(num,0);
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a'] ++;
            }
            String str = Arrays.toString(num);
            if(map.containsKey(str)){
                map.get(str).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(str,list);
            }
        }
        return new ArrayList(map.values());
    }

    //字符串排序后当做key
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key))    map.put(key,new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
