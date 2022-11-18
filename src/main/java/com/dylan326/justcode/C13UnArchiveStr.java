package com.dylan326.justcode;

import java.util.Scanner;

/**
 * Created by dylan on 2022/11/11.
 * 解压字符串
 * 给出一个仅包含小写字母和‘-’的字符串，按如下规则输出解压后的字符串。
 * 1. 如果‘-’连接了多个相同的字符，则只输出第一个字符，‘-’和之后的相同字符不输出。例如‘a-a-a’替换为‘a’，‘a-aa-a’替换为‘aa’。
 * 2. 如果‘-’连接了两个不同的字符，则将连接符及其前后的字符替换为递增或递减的字符串。例如‘a-c’替换为‘abc’，‘g-c’替换为‘gfedc’，‘a-e-c’替换为‘abcdedc’。
 * 3. 其他字符原样输出。
 */
public class C13UnArchiveStr {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputStr = s.nextLine();
        char[] inputArray = inputStr.toCharArray();
        char[] result = new char[inputArray.length * 5];
        int index = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != '-') {
                result[index++] = inputArray[i];
                continue;
            }

            if (inputArray[i - 1] == inputArray[i + 1]) {
                i++;
                continue;
            } else if (inputArray[i - 1] < inputArray[i + 1]) {
                for (int tmp = inputArray[i - 1]; tmp < inputArray[i + 1] - 1; ) {
                    result[index++] = (char) ++tmp;

                }

            } else {
                for (int tmp = inputArray[i - 1]; tmp > inputArray[i + 1] + 1; ) {
                    result[index++] = (char) --tmp;
                }
            }

        }
        System.out.println(String.valueOf(result, 0, index));
    }
}
