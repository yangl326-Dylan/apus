package com.dylan326.basic;

import java.util.Stack;
import java.util.EmptyStackException;

public class StackExample {
    public static void main(String[] args) {
        // 1. 创建Stack
        Stack<String> stack = new Stack<>();
        
        // 2. 基本操作
        // 压入元素
        stack.push("第一个元素");
        stack.push("第二个元素");
        stack.push("第三个元素");
        stack.push("第四个元素");
        
        System.out.println("栈中元素个数: " + stack.size());
        
        // 3. 访问操作
        // 查看栈顶元素但不移除
        String topElement = stack.peek();
        System.out.println("栈顶元素: " + topElement);
        System.out.println("查看后栈中元素个数: " + stack.size());
        
        // 4. 删除操作
        // 弹出栈顶元素
        String poppedElement = stack.pop();
        System.out.println("弹出的元素: " + poppedElement);
        System.out.println("弹出后栈中元素个数: " + stack.size());
        
        // 5. 查找操作
        // 查找元素在栈中的位置（从1开始计数，栈顶为1）
        int position = stack.search("第二个元素");
        System.out.println("第二个元素在栈中的位置: " + position);
        
        int notFound = stack.search("不存在的元素");
        System.out.println("不存在元素的查找结果: " + notFound); // 返回-1表示未找到
        
        // 6. 遍历Stack
        System.out.println("\n遍历栈中所有元素（从栈顶到栈底）:");
        // 注意：Stack继承自Vector，因此支持随机访问，但作为栈使用时应只使用栈操作
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println("位置" + (i+1) + ": " + stack.get(i));
        }
        
        // 7. 其他常用方法
        System.out.println("\n栈是否为空: " + stack.isEmpty());
        
        // 清空栈
        while (!stack.isEmpty()) {
            String element = stack.pop();
            System.out.println("弹出元素: " + element);
        }
        System.out.println("清空后栈是否为空: " + stack.isEmpty());
        
        // 8. 异常处理示例
        System.out.println("\n异常处理示例:");
        try {
            // 对空栈执行pop操作会抛出EmptyStackException
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("捕获到EmptyStackException: 栈为空时执行pop操作");
        }
        
        try {
            // 对空栈执行peek操作会抛出EmptyStackException
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println("捕获到EmptyStackException: 栈为空时执行peek操作");
        }
        
        // 9. Stack的重要特性说明
        /*
         * Stack的重要特性：
         * 1. 继承自Vector类，因此是线程安全的
         * 2. 遵循后进先出（LIFO）原则
         * 3. 提供了栈特有的操作：push、pop、peek
         * 4. 提供了search方法用于查找元素
         * 
         * 时间复杂度：
         * - push操作时间复杂度为O(1)
         * - pop操作时间复杂度为O(1)
         * - peek操作时间复杂度为O(1)
         * - search操作时间复杂度为O(n)
         * 
         * 使用场景：
         * - 函数调用栈的模拟
         * - 表达式求值
         * - 括号匹配检查
         * - 浏览器历史记录（后退功能）
         * - 撤销操作（Undo）
         * 
         * 注意事项：
         * - Stack类已被官方标记为遗留类，推荐使用ArrayDeque代替
         * - 作为栈使用时，应避免使用Vector的其他方法（如add、remove等）
         */
         
        // 10. 推荐的替代方案：使用ArrayDeque作为栈
        System.out.println("\n推荐的替代方案：使用ArrayDeque作为栈:");
        java.util.ArrayDeque<String> deque = new java.util.ArrayDeque<>();
        
        // 压入元素（相当于Stack的push）
        deque.push("元素1");
        deque.push("元素2");
        deque.push("元素3");
        
        // 查看栈顶元素（相当于Stack的peek）
        System.out.println("栈顶元素: " + deque.peek());
        
        // 弹出栈顶元素（相当于Stack的pop）
        System.out.println("弹出元素: " + deque.pop());
        System.out.println("弹出元素: " + deque.pop());
        System.out.println("弹出元素: " + deque.pop());
    }
}