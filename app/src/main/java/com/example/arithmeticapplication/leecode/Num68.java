package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/8/6 19:32
 * description:给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num68 {

    public static void main(String[] args) {
        Num68 num68 = new Num68();
        List<String> list = num68.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain", "to","a","computer.","Art","is","everything","else","we","do"},20);
        System.out.println("args = [" + list.size() + "]");
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = start;
        while (start < words.length){
            //找出一个集合头尾
            int count = words[start].length();
            for (int i = start+1; i < words.length; i++) {
                if(count + 1 + words[i].length() > maxWidth){
                    end = i-1;
                    break;
                }else{
                    count += words[i].length()+1;
                    end = i;
                }
            }
            if(start == end){
                StringBuilder builder = new StringBuilder();
                builder.append(words[start]);
                for (int i = 0; i < maxWidth - words[start].length(); i++) {
                    builder.append(" ");
                }
                list.add(builder.toString());
                start ++;
                end ++;
            }else{
                if(end == words.length-1){
                    StringBuilder builder = new StringBuilder();
                    builder.append(words[start]);
                    for (int i = start+1; i <= end ; i++) {
                        builder.append(" ");
                        builder.append(words[i]);
                    }
                    for (int i = 0; i < maxWidth - count; i++) {
                        builder.append(" ");
                    }
                    list.add(builder.toString());
                    start = end+1;
                    end = end+1;
                    break;
                }
                int c = maxWidth - count;
                int m = c/(end-start);
                int k = c%(end - start);
                StringBuilder builder = new StringBuilder();
                builder.append(words[start]);
                for (int i = start+1; i <= end; i++) {
                    for (int j = 0; j <= m; j++) {
                        builder.append(" ");
                    }
                    if(i - start <= k){
                        builder.append(" ");
                    }
                    builder.append(words[i]);
                }
                list.add(builder.toString());
                start = end+1;
                end = start;

            }

        }
        return list;
    }
}
