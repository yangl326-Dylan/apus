package com.dylan326.apus;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dylan on 2018/3/26.
 * 栈结构来处理配对问题
 */
public class A20ValidParentheses {

    public boolean valid(String s) {
        Map<Character, Character> characterMap = new HashMap<Character, Character>();
        characterMap.put('{', '}');
        characterMap.put('[', ']');
        characterMap.put('(', ')');

        Deque<Character> stack = new ArrayDeque<Character>();
        for (char tmp : s.toCharArray()) {
            Character top = stack.peek();
            if (top != null && characterMap.get(top) != null && tmp == characterMap.get(top)) {
                stack.pop();
            } else {
                stack.push(tmp);
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        A20ValidParentheses a20ValidParentheses = new A20ValidParentheses();
        System.out.println(a20ValidParentheses.valid("{}[][(])]"));

    }
}
