package com.dylan326.justcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dylan on 2019/10/17.
 */
public class C10StrPattern {

    /**
     * 生成模式串next函数，函数作用为主串对比忽略比较的位置记录
     * 表示的含义当前位置，真前缀和真后缀相同的个数， 正因为相同，所以已经比较过的可以根据这个信息直接跳到比较位置
     * @param pattern 匹配模式串
     * @return
     */
    private static int[] genNextArray(String pattern) {

        if (pattern == null || pattern.length() == 0) {
            return new int[]{};
        }
        int[] result = new int[pattern.length()];
        result[0] = 0;// 一个元素自己，真前、后缀相同个数为0
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(result[i - 1])) { //当前元素和result记录值
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 0;
            }

        }
        return result;
    }

    /**
     * @param str
     * @param pattern
     * @return ["1-4","6-9"]
     */
    public static List<String> findPosition(String str, String pattern) {
        List<String> result = new ArrayList<>();
        if (str == null || pattern == null || str.length() == 0 || pattern.length() == 0) { // 不合理过滤
            return result;
        }
        int[] next = genNextArray(pattern); // 生成next函数， 信息表
        int i = 0, start = 0;
        while (i < str.length()) {
            for (int j = 0; j < pattern.length(); j++) {
                if (i + j > str.length() - 1) { // 如果剩下的长度不符合直接退出后续查找
                    return result;
                }
                if (str.charAt(i + j) == pattern.charAt(j)) {
                    if (j == 0) { // j==0 并且i+j位置和 pattern串j位置相等，可能的起始位置记录
                        start = i;
                    }
                    if (j == pattern.length() - 1) {// 找到并且结束
                        result.add(String.format("%s-%s", start, i + j));
                        i++; // **  注意此处从i+1开始继续，而不是当前找到的模式串结束位置
                        break;
                    }
                } else { // ** 不相等 源串遍历索引i 直接跳到next() 位置。 加不加1 取决于next记录值， 有些实现next值默认-1，所以此处不用加1
                    i = i + next[j] + 1;
                    break;
                }
            }

        }

        return result;
    }


    public static void main(String[] args) {
        //示例
        //abababca  原始串S   pattern串aba
        //01234567  索引值
        //00123401  next() 函数，剪枝跳跃的信息表
        System.out.println(Arrays.toString(findPosition("abababca", "aba").toArray()));
    }
}
