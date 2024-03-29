package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @date :2019/11/7 10:53
 * description:给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 */
public class Num75 {

    //多指针排序
    public void sortColors(int[] nums) {
        int m = 0,n = nums.length-1;
        int i = 0;
        while (i <= n){
            if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[n];
                nums[n] = temp;
                n--;
            }else if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[m];
                nums[m] = temp;
                i++;
                m++;
            }else{
                i++;
            }
        }
    }
}
