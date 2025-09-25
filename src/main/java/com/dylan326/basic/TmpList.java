package com.dylan326.basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TmpList {
    public static void main(String[] args) {
        // 1. 创建LinkedList的不同方式
        // 方式一：创建空的LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        
        // 方式二：从其他集合初始化
        // LinkedList<String> linkedList2 = new LinkedList<>(Arrays.asList("apple", "banana", "orange"));
        
        // 2. 作为普通List使用（与ArrayList相似的操作）
        // 添加元素
        linkedList.add("apple");      // 在末尾添加元素
        linkedList.add(0, "banana");  // 在指定位置插入元素
        linkedList.addAll(java.util.Arrays.asList("grape", "orange")); // 添加多个元素
        
        // 访问元素
        String firstElement = linkedList.get(0);  // 获取指定位置的元素
        System.out.println("第一个元素: " + firstElement);
        
        // 修改元素
        linkedList.set(0, "kiwi");   // 修改指定位置的元素
        System.out.println("修改后的第一个元素: " + linkedList.get(0));
        
        // 查找操作
        boolean containsApple = linkedList.contains("apple");  // 检查是否包含指定元素
        System.out.println("是否包含apple: " + containsApple);
        
        int indexOfBanana = linkedList.indexOf("banana");      // 查找元素第一次出现的位置
        System.out.println("banana第一次出现的位置: " + indexOfBanana);
        
        // 删除操作
        String removedElement = linkedList.remove(0);          // 删除指定位置的元素并返回
        System.out.println("删除的元素: " + removedElement);
        
        boolean isRemoved = linkedList.remove("banana");       // 删除指定元素的第一个匹配项
        System.out.println("是否成功删除banana: " + isRemoved);
        
        // 遍历LinkedList
        System.out.println("\n遍历方式一：增强for循环");
        for (String item : linkedList) {
            System.out.println(item);
        }
        
        System.out.println("\n遍历方式二：使用迭代器");
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
        
        System.out.println("\n遍历方式三：使用索引");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        
        // 3. LinkedList特有的操作（作为双端队列使用）
        // 在头部操作
        linkedList.addFirst("first");    // 在头部添加元素
        linkedList.offerFirst("offer");  // 在头部添加元素（队列操作）
        String first = linkedList.getFirst();   // 获取但不移除第一个元素
        String pollFirst = linkedList.pollFirst(); // 获取并移除第一个元素
        String removeFirst = linkedList.removeFirst(); // 获取并移除第一个元素
        
        System.out.println("\n头部操作:");
        System.out.println("getFirst: " + first);
        System.out.println("pollFirst: " + pollFirst);
        System.out.println("removeFirst: " + removeFirst);
        
        // 在尾部操作
        linkedList.addLast("last");      // 在尾部添加元素
        linkedList.offerLast("offerLast"); // 在尾部添加元素（队列操作）
        String last = linkedList.getLast();    // 获取但不移除最后一个元素
        String pollLast = linkedList.pollLast();  // 获取并移除最后一个元素
        String removeLast = linkedList.removeLast(); // 获取并移除最后一个元素
        
        System.out.println("\n尾部操作:");
        System.out.println("getLast: " + last);
        System.out.println("pollLast: " + pollLast);
        System.out.println("removeLast: " + removeLast);
        
        // 4. 栈操作（LinkedList可以作为栈使用）
        LinkedList<String> stack = new LinkedList<>();
        stack.push("element1");  // 压入栈
        stack.push("element2");  // 压入栈
        stack.push("element3");  // 压入栈
        
        System.out.println("\n栈操作:");
        System.out.println("栈顶元素: " + stack.peek());  // 查看栈顶元素但不移除
        System.out.println("弹出栈顶: " + stack.pop());   // 弹出栈顶元素
        System.out.println("弹出栈顶: " + stack.pop());   // 弹出栈顶元素
        System.out.println("弹出栈顶: " + stack.pop());   // 弹出栈顶元素
        
        // 5. 其他常用方法
        System.out.println("\n其他操作:");
        System.out.println("列表大小: " + linkedList.size());           // 获取列表大小
        System.out.println("列表是否为空: " + linkedList.isEmpty());     // 检查列表是否为空
        
        // 清空列表
        LinkedList<String> tempList = new LinkedList<>(linkedList);
        tempList.clear();  // 清空所有元素
        System.out.println("清空后的列表是否为空: " + tempList.isEmpty());
        
        // 6. LinkedList与ArrayList的主要区别
        /*
         * LinkedList与ArrayList的区别：
         * 1. 底层实现：
         *    - ArrayList基于动态数组实现
         *    - LinkedList基于双向链表实现
         * 
         * 2. 性能特点：
         *    - ArrayList：
         *      * 随机访问快（get/set操作时间复杂度O(1)）
         *      * 在末尾添加/删除元素快（时间复杂度O(1)）
         *      * 在中间插入/删除元素慢（需要移动元素，时间复杂度O(n)）
         *    - LinkedList：
         *      * 随机访问慢（get/set操作时间复杂度O(n)）
         *      * 在头部/尾部添加/删除元素快（时间复杂度O(1)）
         *      * 在中间插入/删除元素相对较快（找到位置O(n)，插入/删除O(1)）
         * 
         * 3. 内存占用：
         *    - ArrayList只需要存储数据元素
         *    - LinkedList需要存储数据元素和前后节点的引用
         * 
         * 4. 使用场景：
         *    - ArrayList适用于频繁随机访问、较少插入删除的场景
         *    - LinkedList适用于频繁插入删除、较少随机访问的场景
         */
    }
}
