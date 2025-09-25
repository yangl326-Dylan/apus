package com.dylan326.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // 1. 创建HashSet的不同方式
        // 方式一：默认构造函数
        HashSet<String> hashSet = new HashSet<>();
        
        // 方式二：指定初始容量
        HashSet<String> hashSet2 = new HashSet<>(20);
        
        // 方式三：指定初始容量和负载因子
        HashSet<String> hashSet3 = new HashSet<>(20, 0.75f);
        
        // 方式四：从其他集合初始化
        HashSet<String> hashSet4 = new HashSet<>(java.util.Arrays.asList("apple", "banana", "orange"));
        
        // 2. 基本操作
        // 添加元素
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("orange");
        hashSet.add("grape");
        
        // 注意：HashSet不允许重复元素，添加重复元素会返回false
        boolean isAdded = hashSet.add("apple"); // apple已存在，添加失败
        System.out.println("是否成功添加重复的apple: " + isAdded);
        
        // 3. 查找操作
        // 检查是否包含指定元素
        boolean containsApple = hashSet.contains("apple");
        System.out.println("是否包含apple: " + containsApple);
        
        // 4. 删除操作
        // 删除指定元素
        boolean isRemoved = hashSet.remove("banana");
        System.out.println("是否成功删除banana: " + isRemoved);
        
        // 5. 遍历HashSet
        System.out.println("\n遍历方式一：增强for循环");
        for (String item : hashSet) {
            System.out.println(item);
        }
        
        System.out.println("\n遍历方式二：使用迭代器");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
        
        // 6. 其他常用方法
        System.out.println("\nHashSet大小: " + hashSet.size());
        System.out.println("HashSet是否为空: " + hashSet.isEmpty());
        
        // 清空HashSet
        HashSet<String> tempSet = new HashSet<>(hashSet);
        tempSet.clear();
        System.out.println("清空后的HashSet是否为空: " + tempSet.isEmpty());
        
        // 7. HashSet的重要特性说明
        /*
         * HashSet的重要特性：
         * 1. 不允许重复元素
         * 2. 不保证元素的顺序（特别是不保证顺序随时间保持不变）
         * 3. 允许一个null元素
         * 4. 线程不安全（多线程环境下需要外部同步）
         * 5. 底层基于HashMap实现（实际上是一个HashMap实例）
         * 6. 默认初始容量为16，负载因子为0.75
         * 
         * 时间复杂度：
         * - 基本操作（add/remove/contains）平均时间复杂度为O(1)
         * - 遍历操作时间复杂度为O(n)
         * 
         * 使用场景：
         * - 需要去重的场景
         * - 快速查找是否存在某个元素
         * - 集合运算（交集、并集、差集等）
         */
         
        // 8. HashSet与TreeSet的区别示例
        System.out.println("\nHashSet与TreeSet的区别:");
        HashSet<Integer> numberSet = new HashSet<>();
        numberSet.add(5);
        numberSet.add(2);
        numberSet.add(8);
        numberSet.add(1);
        
        System.out.println("HashSet元素顺序（无序）:");
        for (Integer num : numberSet) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // TreeSet会自动排序
        java.util.TreeSet<Integer> treeSet = new java.util.TreeSet<>(numberSet);
        System.out.println("TreeSet元素顺序（有序）:");
        for (Integer num : treeSet) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}