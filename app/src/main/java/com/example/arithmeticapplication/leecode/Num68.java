package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/8/6 19:32
 * description:
 */
public class Num68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        int start = 0;
        while (start < words.length){
            int count = words[start].length();
            for (int i = start; i < words.length; i++) {
                if(count + 1 + words[i].length() > maxWidth){

                }
            }
        }
    }
}
