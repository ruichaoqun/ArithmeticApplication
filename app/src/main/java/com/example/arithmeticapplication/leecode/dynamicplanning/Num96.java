package com.example.arithmeticapplication.leecode.dynamicplanning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/12/3 8:37
 * description:给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class Num96 {

    //动态规划
    //设G（n）为长度为n的二叉搜索树个数
    //设F（n）为以n为顶点的不同二叉搜索树个数

    //G（n） = F（1）+F（2）+...+F（n）；
    //F（n） = G（0）*G（n-1）+G(1)*G(n-2)+...+G(n-1)*G(0)
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
