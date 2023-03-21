package com.dylan326.justcode;

import java.util.Scanner;

/**
 * Created by dylan on 2023/3/13.
 * 111222333 -> 121232313 最少修改次数，修改了3次使得没有重复数字
 */
public class C16ModifyNums {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputStr = s.nextLine();
        char[] inputArray = inputStr.toCharArray();
        int counter = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i + 1] == inputArray[i]) {
                counter++;
                i = i + 1;
            }
        }
        System.out.println(counter);
    }
}
