package com.example.arithmeticapplication.monimianshi;

import java.util.Arrays;
import java.util.Collections;

public class Test3 {
    public int findRotateSteps(String ring, String key) {
        int[][] tab = new int[key.length()][ring.length()];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = 0;
            }
        }
        for (int i = 0; i < key.length(); i++) {
            stack(ring,key.charAt(i),i,tab);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if(tab[key.length() - 1][i] != 0){
                min = Math.min(tab[key.length() - 1][i],min);
            }
        }
        return min;
    }

    private void stack(String ring, char c, int row, int[][] tab) {
        if(row == 0){
            caculateStep(ring,c,0,0,tab[0]);
        }else{
            for (int i = 0; i < tab[0].length; i++) {
                if(tab[row-1][i] != 0){
                    caculateStep(ring,c,i,tab[row-1][i],tab[row]);
                }
            }
        }
    }

    private void caculateStep(String ring, char c,int startIndex,int sum,int[] temp) {
        int step1 = sum+1;
        int step2 = sum+1;
        int i1 = startIndex;
        int i2 = startIndex;
        while (ring.charAt(i1) != c){
            step1++;
            if(i1 == ring.length()-1){
                i1 = 0;
            }else{
                i1++;
            }
        }

        while (ring.charAt(i2) != c){
            step2++;
            if(i2 == 0){
                i2 = ring.length()-1;
            }else{
                i2--;
            }
        }
        if(i1 == i2){
            int step = Math.min(step1,step2);
            if(temp[i1] != 0){
                temp[i1] = Math.min(step,temp[i1]);
            }else{
                temp[i1] = step;
            }
        }else{
            if(temp[i1] != 0){
                temp[i1] = Math.min(step1,temp[i1]);
            }else{
                temp[i1] = step1;
            }

            if(temp[i2] != 0){
                temp[i2] = Math.min(step2,temp[i2]);
            }else{
                temp[i2] = step2;
            }
        }
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int k = test3.findRotateSteps("godding","gd");
        System.out.printf(""+k);
    }
}
