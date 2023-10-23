package com.dylan326.justcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by dylan on 2023/10/23.
 * []{}()
 */
public class Solution20Valid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        char[] tmpS = s.toCharArray();
        for (char c : tmpS) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character cTmp = stack.peek();
                if (c == map.get(cTmp)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}[()()][]"));
    }
}
