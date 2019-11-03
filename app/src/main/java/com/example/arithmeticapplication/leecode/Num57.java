package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/7/2 8:45
 * description:给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 */
public class Num57 {

    public static void main(String[] args) {
        int[][] arr = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});
        System.out.println("args = [" + args + "]");
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length){
            if(intervals[i][1] < newInterval[0]){
                list.add(intervals[i]);
                i++;
                continue;
            }

            if(intervals[i][0] > newInterval[1]){
                list.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                return list.toArray(new int[0][]);
            }

            if(intervals[i][1] >= newInterval[0]){
                int[] temp = new int[2];
                if(intervals[i][0] >= newInterval[0]){
                    temp[0] = newInterval[0];
                }else{
                    temp[0] = intervals[i][0];
                }

                if(intervals[i][1] >= newInterval[1]){
                    temp[1] = intervals[i][1];
                    list.add(temp);
                    for (int j = i+1; j < intervals.length; j++) {
                        list.add(intervals[j]);
                    }
                    return list.toArray(new int[0][]);
                }else{
                    i++;
                    while (i < intervals.length){
                        if(newInterval[1] < intervals[i][0]){
                            temp[1] = newInterval[1];
                            list.add(temp);
                            for (int j = i; j < intervals.length; j++) {
                                list.add(intervals[j]);
                            }
                            return list.toArray(new int[0][]);
                        }else if(newInterval[1] <= intervals[i][1]){
                            temp[1] = intervals[i][1];
                            list.add(temp);
                            for (int j = i+1; j < intervals.length; j++) {
                                list.add(intervals[j]);
                            }
                            return list.toArray(new int[0][]);
                        }else{
                            i++;
                        }
                    }
                    if(i >= intervals.length){
                        temp[1] = newInterval[1];
                        list.add(temp);
                        return list.toArray(new int[0][]);
                    }
                }

            }
        }
        if(i == intervals.length){
            list.add(newInterval);
        }
        return  list.toArray(new int[0][]);
    }
}
