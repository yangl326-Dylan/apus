package com.dylan326.justcode;

import java.util.HashMap;
import java.util.Map;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */
public class Solution13 {
    public int romanToInt(String s) {
        int result = 0;
        char[] arrayS = s.toCharArray();
        Map<Character, Integer> rule = new HashMap<>();
        rule.put('I', 1);
        rule.put('V', 5);
        rule.put('X', 10);
        rule.put('L', 50);
        rule.put('C', 100);
        rule.put('D', 500);
        rule.put('M', 1000);
        for (int i = 0; i < arrayS.length; i++) {
            if (i == arrayS.length - 1) {
                result += rule.get(arrayS[i]);
            } else {
                if(arrayS[i] == 'I' && (arrayS[i+1] =='V' || arrayS[i+1] == 'X' )){
                    result += rule.get(arrayS[i+1]) -1;
                    i++;
                }else if(arrayS[i] == 'X' && (arrayS[i+1] =='L' || arrayS[i+1] == 'C' )){
                    result += rule.get(arrayS[i+1]) -10;
                    i++;
                }else if (arrayS[i] == 'C' && (arrayS[i+1] =='D' || arrayS[i+1] == 'M' )){
                    result += rule.get(arrayS[i+1]) -100;
                    i++;
                }else {
                    result += rule.get(arrayS[i]);
                }
            }
        }
        return result;
    }
}
