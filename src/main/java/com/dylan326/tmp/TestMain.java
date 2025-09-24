package com.dylan326.tmp;

import java.util.HashMap;

public class TestMain {
    private static boolean isP(String sb){
        HashMap<Character,Integer> bitMap = new HashMap<Character, Integer>();
        for (char tmp:
              sb.toCharArray()) {
            bitMap.merge(tmp, 1, Integer::sum);

        }
        int flag = 0;
        for (Integer i :
                bitMap.values()) {
            if(i%2 != 0){
                flag ++;
            }
        }
        if(flag > 1){
            return false; 
        }else {
            return true;
        }
    }
    public static void main(String[] args) {
        System.out.println(isP("TTacac"));

    }
}
