package com.dylan326.apus;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class A32LongestValidPath {
    public int longestValidParentheses(String s) {
        int result = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (result >= (array.length - i)) { // 排除无用情况
                break;
            }
            if (array[i] == '(') { // 仅起始（ 才能进入匹配
                int tmp = maxValidPath(array, i);
                result = result < tmp ? tmp : result;
            }
        }
        return result;
    }

    private int maxValidPath(char[] array, int start) {
        int max = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = start; i < array.length; i++) {
            if (!stack.empty() && stack.peek() == '(' && array[i] == ')') {
                stack.pop();
                if (stack.empty()) { //当前最大匹配字符个数
                    max = i - start + 1 > max ? i - start + 1 : max;
//                    System.out.println(max + "," + Arrays.toString(Arrays.copyOfRange(array, start, i + 1)));
                }
            } else {
                if (stack.empty() && array[i] == ')') { // 排除无用情况
                    break;
                }
                if (stack.size() > array.length - i) { // 排除无用情况
                    break;
                }
                stack.push(array[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()))()()(())";
        A32LongestValidPath a32LongestValidPath = new A32LongestValidPath();
        System.out.println(a32LongestValidPath.longestValidParentheses(s));
    }
}
