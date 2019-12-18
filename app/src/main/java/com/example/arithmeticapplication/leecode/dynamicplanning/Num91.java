package com.example.arithmeticapplication.leecode.dynamicplanning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/12/10 9:26
 * description:
 */
public class Num91 {


    public static void main(String[] args) {
        Num91 num91 = new Num91();
        int num = num91.numDecodings("12");
        System.out.println("args = [" + num + "]");
    }

    public int numDecodings(String s) {
        return stack(s,0);
    }



    public int stack(String s,int index){
        if(index == s.length()){
            return 1;
        }
        if(index == s.length()-1 ){
            if(s.charAt(index) == '0'){
                return 0;
            }
            return 1;
        }

        char temp1 = s.charAt(index);
        char temp2 = s.charAt(index+1);
        if(temp1 == '0'){
            return 0;
        }
        if(temp1 == '1'){
            return stack(s,index+1) + stack(s,index+2);
        }else if(temp1 == '2'){
            if(temp2 <= '6'){
                return stack(s,index+1) + stack(s,index+2);
            }else{
                return stack(s,index+1);
            }
        }else{
            return stack(s,index+1);
        }
    }
}
