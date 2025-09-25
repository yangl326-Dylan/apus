package com.dylan326.basic;

import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;

public class TreeMapExample {
    public static void main(String[] args) {
        // 1. 创建TreeMap的不同方式
        // 方式一：默认构造函数
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        
        // 方式二：指定比较器
        TreeMap<String, Integer> treeMap2 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        
        // 方式三：从其他Map初始化
        TreeMap<String, Integer> treeMap3 = new TreeMap<>(treeMap);
        
        // 2. 基本操作
        // 添加键值对
        treeMap.put("banana", 5);
        treeMap.put("apple", 10);
        treeMap.put("orange", 8);
        treeMap.put("grape", 12);
        
        // TreeMap会根据键的自然顺序进行排序
        System.out.println("TreeMap按键的自然顺序排序:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 3. 访问操作
        // 获取值
        Integer appleCount = treeMap.get("apple");
        System.out.println("\napple的数量: " + appleCount);
        
        // 获取第一个和最后一个键值对
        Map.Entry<String, Integer> firstEntry = treeMap.firstEntry();
        Map.Entry<String, Integer> lastEntry = treeMap.lastEntry();
        System.out.println("第一个键值对: " + firstEntry.getKey() + " -> " + firstEntry.getValue());
        System.out.println("最后一个键值对: " + lastEntry.getKey() + " -> " + lastEntry.getValue());
        
        // 获取指定键的前驱和后继
        String lowerKey = treeMap.lowerKey("orange"); // 小于"orange"的最大键
        String higherKey = treeMap.higherKey("orange"); // 大于"orange"的最小键
        System.out.println("orange的前驱键: " + lowerKey);
        System.out.println("orange的后继键: " + higherKey);
        
        // 4. 修改操作
        // 更新已存在的键值对
        treeMap.put("apple", 15); // 将apple的数量从10更新为15
        System.out.println("\n更新后apple的数量: " + treeMap.get("apple"));
        
        // 5. 删除操作
        // 删除指定键的映射
        Integer removedValue = treeMap.remove("banana");
        System.out.println("删除的banana数量: " + removedValue);
        
        System.out.println("\n删除banana后的TreeMap:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 6. 范围操作（TreeMap特有的功能）
        // 获取子Map
        System.out.println("\n键在\"grape\"到\"orange\"之间的键值对:");
        Map<String, Integer> subMap = treeMap.subMap("grape", "orange");
        for (Map.Entry<String, Integer> entry : subMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 获取键小于等于指定键的部分
        System.out.println("\n键小于等于\"grape\"的键值对:");
        Map<String, Integer> headMap = treeMap.headMap("grape");
        for (Map.Entry<String, Integer> entry : headMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 获取键大于等于指定键的部分
        System.out.println("\n键大于等于\"orange\"的键值对:");
        Map<String, Integer> tailMap = treeMap.tailMap("orange");
        for (Map.Entry<String, Integer> entry : tailMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 7. 遍历TreeMap
        System.out.println("\n遍历方式一：按升序遍历");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\n遍历方式二：按降序遍历");
        for (Map.Entry<String, Integer> entry : treeMap.descendingMap().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 8. 其他常用方法
        System.out.println("\nTreeMap大小: " + treeMap.size());
        System.out.println("TreeMap是否为空: " + treeMap.isEmpty());
        
        // 9. TreeMap的重要特性说明
        /*
         * TreeMap的重要特性：
         * 1. 基于红黑树实现
         * 2. 键值对按键的自然顺序排序，或按创建时指定的比较器排序
         * 3. 不允许null键（使用自然排序时），但允许null值
         * 4. 线程不安全（多线程环境下需要外部同步）
         * 5. 提供了丰富的排序相关操作
         * 
         * 时间复杂度：
         * - 基本操作（get/put/remove/contains）时间复杂度为O(log n)
         * - 遍历操作时间复杂度为O(n)
         * 
         * 使用场景：
         * - 需要按键排序的场景
         * - 需要范围查询的场景
         * - 实现优先队列
         */
    }
}