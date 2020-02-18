package com.example.arithmeticapplication.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num128 {
    public int longestConsecutive(int[] nums) {
        //使用hash表
        Set<Integer> set = new HashSet<>();
        for (Integer num :
                nums) {
            set.add(num);
        }

        int longest = 0;
        for (Integer num : nums) {
            if(set.remove(num)){
                int currentLong = 1;
                int current = num-1;
                while (set.remove(current)){
                    currentLong++;
                    current--;
                }
                current = num+1;
                while (set.remove(current)){
                    currentLong++;
                    current++;
                }
                longest = Math.max(longest,currentLong);
            }
        }
        return longest;
    }
}
