package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * @author Rui Chaoqun
 * @date :2020/6/24 9:46
 * description:最小窗口子序列
 * 给定字符串 S and T，找出 S 中最短的（连续）子串 W ，使得 T 是 W 的 子序列 。
 * <p>
 * 如果 S 中没有窗口可以包含 T 中的所有字符，返回空字符串 ""。如果有不止一个最短长度的窗口，返回开始位置最靠左的那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * S = "abcdebdde", T = "bde"
 * 输出："bcde"
 * 解释：
 * "bcde" 是答案，因为它在相同长度的字符串 "bdde" 出现之前。
 * "deb" 不是一个更短的答案，因为在窗口中必须按顺序出现 T 中的元素。
 *  
 * <p>
 * 注：
 * <p>
 * 所有输入的字符串都只包含小写字母。All the strings in the input will only contain lowercase letters.
 * S 长度的范围为 [1, 20000]。
 * T 长度的范围为 [1, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num727 {
    /**
     * 滑动窗口，找到符合条件的子序列后再从后往前排除前面的多余字符
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        if (len1 == 0 || len2 == 0 || len2 > len1) {
            return "";
        }
        int i = 0;
        int j = 0;
        int start = 0;
        int end = len1-1;
        while (i < len1) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
            }
            if(j == len2-1){
                int right = i;
                j--;
                while(j >= 0){
                    if(S.charAt(i) == T.charAt(j)){
                        j--;
                    }
                    i--;
                }
                i++;
                if(right - i + 1 < end - start + 1){
                    start = i;
                    end = right;
                }
                j = 0;
            }
            i++;
        }
        return end -start + 1 == len1 ? "" : S.substring(start,end - start + 1);
    }

    public static void main(String[] args) {
        Num727 num727 = new Num727();
        System.out.printf(num727.minWindow("abcdebdde","bde"));
    }
}

