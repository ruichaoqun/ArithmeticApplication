package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/6/24 19:26
 * description:给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if(list.size() == 0){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                if(list.get(list.size()-1)[1] >= intervals[i][0]){
                    list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],intervals[i][1]);
                }else{
                    list.add(new int[]{intervals[i][0],intervals[i][1]});
                }
            }
        }
        return list.toArray(new int[0][]);
    }
}
