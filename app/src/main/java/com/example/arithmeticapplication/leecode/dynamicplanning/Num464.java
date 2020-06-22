package com.example.arithmeticapplication.leecode.dynamicplanning;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Rui Chaoqun
 * @date :2020/5/28 8:54
 * description:在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。
 *
 * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
 *
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
 *
 * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
 *
 * 示例：
 *
 * 输入：
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * 输出：
 * false
 *
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-i-win
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false; //1,..maxChoosable数列总和都比目标和小
        int[] state = new int[maxChoosableInteger + 1];  //state[1]=1表示1被选了

        return backtraceWitMemo(state, desiredTotal, new HashMap<String, Boolean>());
    }

    private boolean backtraceWitMemo(int[] state, int desiredTotal, HashMap<String, Boolean> map) {
        String key = Arrays.toString(state); //这里比较关键，如何表示这个唯一的状态，例如[2,3]和[3,2]都是"0011"，状态一样
        if (map.containsKey(key)) return map.get(key);  //如果已经记忆了这样下去的输赢结果,记忆是为了防止如[2,3]，[3,2]之后的[1,4,5,..]这个选择区间被重复计算

        for (int i = 1; i < state.length; i++){
            if (state[i] == 0){ //如果这个数字i还没有被选中
                state[i] = 1;
                //如果当前选了i已经赢了或者选了i还没赢但是后面对方选择输了
                if (desiredTotal - i <= 0 || !backtraceWitMemo(state, desiredTotal - i, map)) {
                    map.put(key, true);
                    state[i] = 0; //在返回之前回溯
                    return true;
                }
                //如果不能赢也要记得回溯
                state[i] = 0;
            }
        }
        //如果都赢不了
        map.put(key, false);
        return false;
    }

}
