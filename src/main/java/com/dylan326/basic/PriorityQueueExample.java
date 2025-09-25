package com.dylan326.basic;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // 1. 创建PriorityQueue的不同方式
        // 方式一：默认构造函数（最小堆，自然排序）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 方式二：指定初始容量
        PriorityQueue<String> stringQueue = new PriorityQueue<>(10);
        
        // 方式三：指定比较器（最大堆）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        // 方式四：从集合初始化
        PriorityQueue<Integer> heapFromCollection = new PriorityQueue<>(java.util.Arrays.asList(5, 2, 8, 1, 9));
        
        // 2. 基本操作
        // 添加元素
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.offer(9);
        
        System.out.println("最小堆大小: " + minHeap.size());
        
        // 3. 访问操作
        // 查看堆顶元素但不移除
        Integer topElement = minHeap.peek();
        System.out.println("最小堆堆顶元素: " + topElement);
        
        // 4. 删除操作
        // 移除并返回堆顶元素
        Integer removedElement = minHeap.poll();
        System.out.println("移除的堆顶元素: " + removedElement);
        System.out.println("移除后堆顶元素: " + minHeap.peek());
        
        // 5. 自定义对象的优先队列
        System.out.println("\n=== 自定义对象的优先队列 ===");
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.offer(new Task("任务3", 3));
        taskQueue.offer(new Task("任务1", 1));
        taskQueue.offer(new Task("任务2", 2));
        
        System.out.println("按优先级出队:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
        
        // 6. 遍历PriorityQueue
        System.out.println("\n=== 遍历PriorityQueue ===");
        PriorityQueue<Integer> traversalQueue = new PriorityQueue<>();
        traversalQueue.offer(5);
        traversalQueue.offer(2);
        traversalQueue.offer(8);
        traversalQueue.offer(1);
        
        // 注意：直接遍历不保证顺序
        System.out.println("直接遍历（无序）:");
        for (Integer num : traversalQueue) {
            System.out.println(num);
        }
        
        // 按优先级顺序遍历
        System.out.println("按优先级遍历:");
        PriorityQueue<Integer> tempQueue = new PriorityQueue<>(traversalQueue);
        while (!tempQueue.isEmpty()) {
            System.out.println(tempQueue.poll());
        }
        
        // 7. 其他常用方法
        System.out.println("\n=== 其他常用方法 ===");
        PriorityQueue<Integer> utilityQueue = new PriorityQueue<>();
        utilityQueue.offer(1);
        utilityQueue.offer(2);
        utilityQueue.offer(3);
        
        System.out.println("队列大小: " + utilityQueue.size());
        System.out.println("队列是否为空: " + utilityQueue.isEmpty());
        
        // 检查是否包含某个元素
        System.out.println("是否包含元素2: " + utilityQueue.contains(2));
        
        // 移除指定元素
        boolean removed = utilityQueue.remove(2);
        System.out.println("移除元素2: " + removed);
        System.out.println("移除后是否包含元素2: " + utilityQueue.contains(2));
        
        // 清空队列
        utilityQueue.clear();
        System.out.println("清空后队列是否为空: " + utilityQueue.isEmpty());
        
        // 8. PriorityQueue的重要特性说明
        /*
         * PriorityQueue的重要特性：
         * 1. 基于堆实现（默认最小堆）
         * 2. 不允许null元素
         * 3. 线程不安全（多线程环境下需要外部同步）
         * 4. 提供了O(log n)的插入和删除操作
         * 5. 提供了O(1)的查看堆顶元素操作
         * 
         * 时间复杂度：
         * - offer操作时间复杂度为O(log n)
         * - poll操作时间复杂度为O(log n)
         * - peek操作时间复杂度为O(1)
         * - remove操作时间复杂度为O(n)
         * 
         * 使用场景：
         * - 优先级任务调度
         * - Dijkstra算法
         * - 堆排序
         * - Top K问题
         * 
         * 注意事项：
         * - 直接遍历不保证顺序
         * - 需要有序遍历时应创建副本逐个poll
         * - 自定义对象需要实现Comparable接口或提供Comparator
         */
    }
    
    // 自定义任务类，用于演示自定义对象的优先队列
    static class Task implements Comparable<Task> {
        private String name;
        private int priority;
        
        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
        
        public String getName() {
            return name;
        }
        
        public int getPriority() {
            return priority;
        }
        
        @Override
        public int compareTo(Task other) {
            // 按优先级升序排列（数值越小优先级越高）
            return Integer.compare(this.priority, other.priority);
        }
        
        @Override
        public String toString() {
            return "Task{name='" + name + "', priority=" + priority + "}";
        }
    }
}