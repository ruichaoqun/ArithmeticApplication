package com.example.arithmeticapplication.leecode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Num45 {

    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }

    public static int jump(int[] nums) {
        int i = 0;
        int step = 0;
        int length = nums.length;
        while (i < length - 1) {
            if (nums[i] >= (length - 1 - i)) {
                step++;
                return step;
            }

            if(nums[i] == 1){
                step++;
                i++;
                continue;
            }
            int nextStep = 1;
            for (int j = 2; j <= nums[i]; j++) {
                if (nums[nextStep + i] - (nums[i] - nextStep) < nums[i + j] - (nums[i] - j)) {
                    nextStep = j;
                }
            }
            i += nextStep;
            step++;
        }
        return step;
    }
}
