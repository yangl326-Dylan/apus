package com.dylan326.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TmpArray {
    public static void main(String[] args) {
        // 1. 创建ArrayList的不同方式
        // 方式一：指定初始容量
        List<String> list1 = new ArrayList<>();
        
        // 方式二：指定初始容量（推荐用于大量数据）
        List<String> list2 = new ArrayList<>(20);
        
        // 方式三：从其他集合初始化
        List<String> list3 = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
        
        // 2. 基本操作
        // 添加元素
        list1.add("apple");      // 在末尾添加元素
        list1.add(0, "banana");  // 在指定位置插入元素
        list1.addAll(list3);     // 添加另一个集合的所有元素
        
        // 访问元素
        String firstElement = list1.get(0);  // 获取指定位置的元素
        System.out.println("第一个元素: " + firstElement);
        
        // 修改元素
        list1.set(0, "grape");   // 修改指定位置的元素
        System.out.println("修改后的第一个元素: " + list1.get(0));
        
        // 3. 查找操作
        boolean containsApple = list1.contains("apple");  // 检查是否包含指定元素
        System.out.println("是否包含apple: " + containsApple);
        
        int indexOfBanana = list1.indexOf("banana");      // 查找元素第一次出现的位置
        System.out.println("banana第一次出现的位置: " + indexOfBanana);
        
        int lastIndexOfApple = list1.lastIndexOf("apple"); // 查找元素最后一次出现的位置
        System.out.println("apple最后一次出现的位置: " + lastIndexOfApple);
        
        // 4. 删除操作
        String removedElement = list1.remove(0);          // 删除指定位置的元素并返回
        System.out.println("删除的元素: " + removedElement);
        
        boolean isRemoved = list1.remove("banana");       // 删除指定元素的第一个匹配项
        System.out.println("是否成功删除banana: " + isRemoved);
        
        // 5. 遍历ArrayList
        System.out.println("\n遍历方式一：增强for循环");
        for (String item : list1) {
            System.out.println(item);
        }
        
        System.out.println("\n遍历方式二：使用迭代器");
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
        
        System.out.println("\n遍历方式三：使用索引");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        
        // 6. 其他常用方法
        System.out.println("列表大小: " + list1.size());           // 获取列表大小
        System.out.println("列表是否为空: " + list1.isEmpty());     // 检查列表是否为空
        
        // 清空列表
        List<String> tempList = new ArrayList<>(list1);
        tempList.clear();  // 清空所有元素
        System.out.println("清空后的列表是否为空: " + tempList.isEmpty());
        
        // 转换为数组
        String[] array = list1.toArray(new String[0]);
        System.out.println("转换为数组后的长度: " + array.length);
        
        // 7. 原始代码示例
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("b");
        a.get(1);
        System.out.println(a.get(1));
        System.out.println(a.contains("1 ".trim()));
    }
}
