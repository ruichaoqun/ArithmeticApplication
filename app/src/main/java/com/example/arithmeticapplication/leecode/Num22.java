package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Num22 {

    /**
     *
     * @param n n对括号
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list,new StringBuilder(),n,n);
        return list;
    }


    /**
     *
     * @param list 结果集合
     * @param builder 当前的已经组合的前面的序列
     * @param l 左括号剩余数
     * @param r 右括号剩余数
     */
    public void generate(List<String> list,StringBuilder builder,int l,int r){
        //如果做括号剩余数是0，直接将剩余的右括号全部加进来
        if(l == 0){
            for (int i = 0; i < r; i++) {
                builder.append(")");
            }
            list.add(builder.toString());
            //得到了一个完整的顺序，退出
            return;
        }
        //如果左==右，此时只能放入一个左括号
        if(l == r){
            generate(list,new StringBuilder(builder).append("("),l-1,r);
        }else {
            //如果左不等于右，实际上这儿左肯定小于右，此时可以放入一个左括号，也可以放入一个右括号
            generate(list,new StringBuilder(builder).append("("),l-1,r);
            generate(list,new StringBuilder(builder).append(")"),l,r-1);
        }
    }
}
