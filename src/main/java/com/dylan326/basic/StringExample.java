package com.dylan326.basic;

import java.util.Arrays;
import java.util.List;

public class StringExample {
    public static void main(String[] args) {
        // 1. 创建String的不同方式
        // 方式一：直接赋值（字符串常量）
        String str1 = "Hello World";
        
        // 方式二：使用new关键字
        String str2 = new String("Hello World");
        
        // 方式三：从字符数组创建
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);
        
        // 方式四：从字节数组创建
        byte[] byteArray = {72, 101, 108, 108, 111}; // "Hello"的ASCII码
        String str4 = new String(byteArray);
        
        // 方式五：使用StringBuilder构建
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        String str5 = sb.toString();
        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);
        System.out.println("str5: " + str5);
        
        // 2. 字符串基本操作
        String text = "Java Programming Language";
        
        // 获取字符串长度
        System.out.println("\n=== 字符串基本操作 ===");
        System.out.println("字符串长度: " + text.length());
        
        // 获取指定位置的字符
        System.out.println("第1个字符: " + text.charAt(0));
        System.out.println("第5个字符: " + text.charAt(4));
        
        // 获取字符首次和最后一次出现的位置
        System.out.println("'a'首次出现的位置: " + text.indexOf('a'));
        System.out.println("'a'最后一次出现的位置: " + text.lastIndexOf('a'));
        System.out.println("'Program'首次出现的位置: " + text.indexOf("Program"));
        
        // 3. 字符串比较操作
        System.out.println("\n=== 字符串比较操作 ===");
        String strA = "Hello";
        String strB = "Hello";
        String strC = new String("Hello");
        String strD = "hello";
        
        // 使用equals方法比较内容
        System.out.println("strA.equals(strB): " + strA.equals(strB)); // true
        System.out.println("strA.equals(strC): " + strA.equals(strC)); // true
        System.out.println("strA.equals(strD): " + strA.equals(strD)); // false
        
        // 使用equalsIgnoreCase忽略大小写比较
        System.out.println("strA.equalsIgnoreCase(strD): " + strA.equalsIgnoreCase(strD)); // true
        
        // 使用compareTo比较字符串大小
        System.out.println("strA.compareTo(strB): " + strA.compareTo(strB)); // 0 (相等)
        System.out.println("strA.compareTo(strD): " + strA.compareTo(strD)); // <0 (strA在strD之前)
        System.out.println("strD.compareTo(strA): " + strD.compareTo(strA)); // >0 (strD在strA之后)
        
        // 使用==比较引用
        System.out.println("strA == strB: " + (strA == strB)); // true (字符串常量池)
        System.out.println("strA == strC: " + (strA == strC)); // false (不同对象)
        
        // 4. 字符串修改操作
        System.out.println("\n=== 字符串修改操作 ===");
        String original = "  Hello World  ";
        
        // 去除首尾空白字符
        System.out.println("去除空白后: '" + original.trim() + "'");
        
        // 转换大小写
        System.out.println("转大写: " + original.toUpperCase());
        System.out.println("转小写: " + original.toLowerCase());
        
        // 替换字符或字符串
        System.out.println("替换'l'为'L': " + original.replace('l', 'L'));
        System.out.println("替换'World'为'Java': " + original.replace("World", "Java"));
        
        // 5. 字符串截取和分割操作
        System.out.println("\n=== 字符串截取和分割操作 ===");
        String sentence = "Java is a powerful programming language";
        
        // 截取子字符串
        System.out.println("从索引5开始截取: " + sentence.substring(5));
        System.out.println("截取索引5到15之间的字符: " + sentence.substring(5, 15));
        
        // 分割字符串
        String[] words = sentence.split(" ");
        System.out.println("分割后的单词:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("  " + (i + 1) + ". " + words[i]);
        }
        
        // 使用正则表达式分割
        String csvData = "apple,banana,orange;grape,kiwi";
        String[] fruits = csvData.split("[,;]");
        System.out.println("使用正则表达式分割:");
        for (String fruit : fruits) {
            System.out.println("  " + fruit.trim());
        }
        
        // 6. 字符串连接操作
        System.out.println("\n=== 字符串连接操作 ===");
        String part1 = "Hello";
        String part2 = "World";
        
        // 使用+连接
        System.out.println("使用+连接: " + part1 + " " + part2);
        
        // 使用concat方法
        System.out.println("使用concat方法: " + part1.concat(" ").concat(part2));
        
        // 使用StringBuilder（推荐用于大量连接操作）
        StringBuilder builder = new StringBuilder();
        builder.append(part1);
        builder.append(" ");
        builder.append(part2);
        builder.append("!");
        System.out.println("使用StringBuilder: " + builder.toString());
        
        // 7. 字符串查找和判断操作
        System.out.println("\n=== 字符串查找和判断操作 ===");
        String checkString = "Java Programming";
        
        // 判断是否以指定字符串开头或结尾
        System.out.println("是否以'Java'开头: " + checkString.startsWith("Java"));
        System.out.println("是否以'ing'结尾: " + checkString.endsWith("ing"));
        
        // 判断是否包含指定字符串
        System.out.println("是否包含'Program': " + checkString.contains("Program"));
        
        // 判断字符串是否为空
        System.out.println("是否为空: " + checkString.isEmpty());
        
        // 8. 字符串格式化操作
        System.out.println("\n=== 字符串格式化操作 ===");
        String name = "张三";
        int age = 25;
        double salary = 8500.50;
        
        // 使用String.format格式化
        String formatted = String.format("姓名: %s, 年龄: %d, 薪资: %.2f", name, age, salary);
        System.out.println(formatted);
        
        // 使用System.out.printf格式化输出
        System.out.printf("姓名: %s, 年龄: %d, 薪资: %.2f%n", name, age, salary);
        
        // 9. 其他常用方法
        System.out.println("\n=== 其他常用方法 ===");
        String testString = "Hello World";
        
        // 获取字节数组
        byte[] bytes = testString.getBytes();
        System.out.println("字节数组长度: " + bytes.length);
        
        // 获取字符数组
        char[] chars = testString.toCharArray();
        System.out.println("字符数组: " + Arrays.toString(chars));
        
        // 判断字符串是否匹配正则表达式
        System.out.println("是否匹配正则表达式'H.*d': " + testString.matches("H.*d"));
        
        // 10. StringBuilder和StringBuffer的使用
        System.out.println("\n=== StringBuilder和StringBuffer的使用 ===");
        // StringBuilder（非线程安全，性能更好）
        StringBuilder sbExample = new StringBuilder("Hello");
        sbExample.append(" World");
        sbExample.insert(5, ",");
        sbExample.replace(0, 5, "Hi");
        sbExample.delete(2, 3); // 删除索引2的字符
        sbExample.reverse(); // 反转字符串
        System.out.println("StringBuilder结果: " + sbExample.toString());
        
        // StringBuffer（线程安全）
        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append(" World");
        System.out.println("StringBuffer结果: " + stringBuffer.toString());
        
        // 11. String的重要特性说明
        /*
         * String的重要特性：
         * 1. 不可变性（Immutable）：String对象一旦创建就不能修改
         * 2. 字符串常量池：相同内容的字符串在常量池中只保存一份
         * 3. 线程安全：由于不可变性，String在多线程环境下是安全的
         * 4. 实现了CharSequence、Comparable、Serializable接口
         * 
         * 性能考虑：
         * - 频繁修改字符串时应使用StringBuilder或StringBuffer
         * - StringBuilder性能优于StringBuffer（非线程安全）
         * - StringBuffer适用于多线程环境
         * 
         * 使用场景：
         * - 存储不需要修改的文本数据
         * - 作为HashMap的键
         * - 字符串字面量的使用
         * 
         * 注意事项：
         * - 使用+连接字符串在循环中性能较差
         * - 字符串比较应使用equals方法而非==
         * - substring方法在Java 7之前会持有原字符串的引用导致内存泄漏
         */
    }
}