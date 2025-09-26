package com.dylan326.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        // 1. 创建HashMap的不同方式
        // 方式一：默认构造函数
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // 方式二：指定初始容量
        HashMap<String, Integer> hashMap2 = new HashMap<>(20);
        
        // 方式三：指定初始容量和负载因子
        HashMap<String, Integer> hashMap3 = new HashMap<>(20, 0.75f);
        
        // 2. 基本操作
        // 添加键值对
        hashMap.put("apple", 10);
        hashMap.put("banana", 5);
        hashMap.put("orange", 8);
        hashMap.put("mango", 9);
        
        // 注意：HashMap允许一个null键和多个null值
        hashMap.put(null, 0);
        hashMap.put("grape", null);
        
        // 3. 访问操作
        // 获取值
        Integer appleCount = hashMap.get("apple");
        System.out.println("apple的数量: " + appleCount);
        
        // 获取值（如果键不存在则返回默认值）
        Integer mangoCount = hashMap.getOrDefault("mango", 0);
        System.out.println("mango的数量: " + mangoCount);
        
        // 检查是否包含键或值
        boolean hasApple = hashMap.containsKey("apple");
        boolean hasValue10 = hashMap.containsValue(10);
        System.out.println("是否包含apple键: " + hasApple);
        System.out.println("是否包含值10: " + hasValue10);
        
        // 4. 修改操作
        // 更新已存在的键值对
        hashMap.put("apple", 15); // 将apple的数量从10更新为15
        System.out.println("更新后apple的数量: " + hashMap.get("apple"));
        
        // 只有当键不存在时才添加
        hashMap.putIfAbsent("apple", 20); // apple已存在，不会更新
        hashMap.putIfAbsent("mango", 12); // mango不存在，会添加
        System.out.println("mango的数量: " + hashMap.get("mango"));
        
        // 5. 删除操作
        // 删除指定键的映射
        Integer removedValue = hashMap.remove("banana");
        System.out.println("删除的banana数量: " + removedValue);
        
        // 只有当键值对匹配时才删除
        boolean isRemoved = hashMap.remove("orange", 8); // orange对应的值确实是8，删除成功
        System.out.println("是否成功删除orange: " + isRemoved);
        
        // 6. 遍历HashMap
        System.out.println("\n遍历方式一：遍历键值对");
        // 使用entrySet()遍历
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\n遍历方式二：遍历键");
        // 使用keySet()遍历键
        for (String key : hashMap.keySet()) {
            System.out.println(key + ": " + hashMap.get(key));
        }
        
        System.out.println("\n遍历方式三：遍历值");
        // 使用values()遍历值
        for (Integer value : hashMap.values()) {
            System.out.println("值: " + value);
        }
        
        System.out.println("\n遍历方式四：使用迭代器");
        // 使用迭代器遍历
        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 7. 其他常用方法
        System.out.println("\nHashMap大小: " + hashMap.size());
        System.out.println("HashMap是否为空: " + hashMap.isEmpty());
        
        // 清空HashMap
        HashMap<String, Integer> tempMap = new HashMap<>(hashMap);
        tempMap.clear();
        System.out.println("清空后的HashMap是否为空: " + tempMap.isEmpty());
        
        // 8. HashMap的重要特性说明
        /*
         * HashMap的重要特性：
         * 1. 存储键值对，键唯一，值可以重复
         * 2. 允许一个null键和多个null值
         * 3. 不保证映射的顺序（特别是不保证顺序随时间保持不变）
         * 4. 线程不安全（多线程环境下需要外部同步）
         * 5. 默认初始容量为16，负载因子为0.75
         * 6. 当元素数量超过容量*负载因子时，会自动扩容（容量翻倍）
         * 
         * 时间复杂度：
         * - 基本操作（get/put/remove/contains）平均时间复杂度为O(1)
         * - 遍历操作时间复杂度为O(n)
         * 
         * 使用场景：
         * - 需要根据键快速查找值的场景
         * - 缓存实现
         * - 数据去重统计
         */
    }
}