package com.example.arithmeticapplication.leecode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Num20 {
    public static void main(String[] args){
        System.out.println("-->"+isValid("()"));
    }

    //栈处理
    public static boolean isValid(String s) {
//        HashMap<Character,Character> map = new HashMap<>();
//        map.put('(',')');
//        map.put('[',']');
//        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //如果传入的字符是左边字符
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                //传入的是右边字符
                char c = stack.pop();
                if(!((ch == ')' && c == '(') || (ch == ']' && c =='[') || (ch == '}' && c == '{')))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
