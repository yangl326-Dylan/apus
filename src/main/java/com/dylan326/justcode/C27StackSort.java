package com.dylan326.justcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class C27StackSort {

    public static void main(String[] args) {
        Stack<Integer> result = new Stack<>();
        result.push(5);
        result.push(7);
        result.push(10);
        result.push(3);
        result.push(4);
        result.push(1);

        Stack<Integer> tmp = new Stack<>();

        while (result.size() !=0){
            int ldata = result.pop();
            while (true){
                if(tmp.size() == 0){
                    tmp.push(ldata);
                    break;
                }
                Integer rdata= tmp.peek();
                if(rdata> ldata){
                    result.push(tmp.pop());
                }else{
                    tmp.push(ldata);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(new ArrayList(tmp).toArray()));

    }
}
