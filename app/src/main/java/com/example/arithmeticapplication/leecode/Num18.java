package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num18 {

    public static void main(String[] args){
        int[] nums = new int[]{-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492};
    }

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSumViolence (int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int num1,num2,num3,num4;
        for (int i = 0; i < nums.length; i++) {
            num1 = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                num2 = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    num3 = nums[k];
                    for (int l = k+1; l < nums.length; l++) {
                        num4 = nums[l];
                        if(num1 + num2 + num3 + num4 == target){
                            List<Integer> list = new ArrayList<>();
                            list.add(num1);
                            list.add(num2);
                            list.add(num3);
                            list.add(num4);
                            lists.add(list);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < lists.size(); i++) {
            int j = i+1;
            while (j < lists.size()){
                int l1 = lists.get(i).get(0);
                int l2 = lists.get(i).get(1);
                int l3 = lists.get(i).get(2);
                int l4 = lists.get(i).get(3);
                int r1 = lists.get(j).get(0);
                int r2 = lists.get(j).get(1);
                int r3 = lists.get(j).get(2);
                int r4 = lists.get(j).get(3);
                if(l1 == r1 && l2 == r2 && l3 == r3 && l4 == r4 ){
                    lists.remove(j);
                }else {
                    j++;
                }
            }
        }
        return lists;
    }

    /**
     * 两次循环拿到开始两个数，剩下两个数使用双指针获取
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>  lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            //去除重复以及最开始就大于target的
            if(i == 0 || nums[i] != nums[i-1] && nums[i] + nums[i+1] + nums[i+2]+nums[i+3] <= target){
                for (int j = i+1; j < nums.length - 2; j++) {
                    //去除重复以及最开始就大于target的
                    if(j == i+1 || nums[j] != nums[j-1] && nums[i] + nums[j] + nums[j+1]+nums[j+2] <= target){
                        int l = j+1;
                        int r = nums.length - 1;
                        int sum = target - nums[i] - nums[j];
                        while (l < r){
                            if(sum == nums[l] + nums[r]){
                                List<Integer> list = Arrays.asList(nums[i],nums[j],nums[l],nums[r]);
                                lists.add(list);
                                l++;
                                r--;
                                //去除重复
                                while (l < r && nums[l] == nums[l-1]){
                                    l++;
                                }
                                while (l<r && nums[r] == nums[r+1]){
                                    r--;
                                }
                            }else if(sum > nums[l] + nums[r]){
                                l++;
                            }else {
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }
}
