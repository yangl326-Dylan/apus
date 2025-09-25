package com.dylan326.basic;

import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueExample {
    public static void main(String[] args) {
        // 1. 创建Queue的不同方式
        // 方式一：使用LinkedList实现队列
        Queue<String> linkedListQueue = new LinkedList<>();
        
        // 方式二：使用PriorityQueue实现优先队列
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        
        // 方式三：使用PriorityQueue并指定比较器
        Queue<String> priorityQueueWithComparator = new PriorityQueue<>(Comparator.reverseOrder());
        
        // 2. LinkedList实现的队列操作
        System.out.println("=== LinkedList实现的队列 ===");
        // 入队操作
        linkedListQueue.offer("第一个元素");
        linkedListQueue.offer("第二个元素");
        linkedListQueue.offer("第三个元素");
        
        System.out.println("队列大小: " + linkedListQueue.size());
        
        // 查看队首元素但不移除
        String headElement = linkedListQueue.peek();
        System.out.println("队首元素: " + headElement);
        
        // 出队操作
        String removedElement = linkedListQueue.poll();
        System.out.println("出队元素: " + removedElement);
        System.out.println("出队后队列大小: " + linkedListQueue.size());
        
        // 遍历队列
        System.out.println("遍历队列元素:");
        for (String element : linkedListQueue) {
            System.out.println(element);
        }
        
        // 3. PriorityQueue优先队列操作
        System.out.println("\n=== PriorityQueue优先队列 ===");
        // 入队操作
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(8);
        priorityQueue.offer(1);
        priorityQueue.offer(9);
        
        System.out.println("优先队列大小: " + priorityQueue.size());
        System.out.println("队首元素（最小值）: " + priorityQueue.peek());
        
        // 出队操作（按优先级顺序）
        System.out.println("按优先级出队:");
        while (!priorityQueue.isEmpty()) {
            System.out.println("出队元素: " + priorityQueue.poll());
        }
        
        // 4. 带比较器的PriorityQueue
        System.out.println("\n=== 带比较器的PriorityQueue ===");
        priorityQueueWithComparator.offer("apple");
        priorityQueueWithComparator.offer("banana");
        priorityQueueWithComparator.offer("cherry");
        priorityQueueWithComparator.offer("date");
        
        System.out.println("按字母逆序出队:");
        while (!priorityQueueWithComparator.isEmpty()) {
            System.out.println("出队元素: " + priorityQueueWithComparator.poll());
        }
        
        // 5. 异常处理示例
        System.out.println("\n=== 异常处理示例 ===");
        Queue<String> emptyQueue = new LinkedList<>();
        
        // 使用element()和remove()方法处理空队列
        try {
            // element()在队列为空时抛出NoSuchElementException
            emptyQueue.element();
        } catch (NoSuchElementException e) {
            System.out.println("捕获到NoSuchElementException: 队列为空时执行element()操作");
        }
        
        try {
            // remove()在队列为空时抛出NoSuchElementException
            emptyQueue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("捕获到NoSuchElementException: 队列为空时执行remove()操作");
        }
        
        // 6. Queue的重要特性说明
        /*
         * Queue的重要特性：
         * 1. 遵循先进先出（FIFO）原则（特殊队列如优先队列除外）
         * 2. 常见实现类包括LinkedList、PriorityQueue、ArrayDeque等
         * 3. 提供了两套操作方法：
         *    - add/offer: 添加元素
         *    - remove/poll: 移除并返回队首元素
         *    - element/peek: 查看队首元素但不移除
         * 4. 两套方法的区别：
         *    - add/remove/element在异常情况抛出异常
         *    - offer/poll/peek在异常情况返回特殊值（false/null）
         * 
         * 时间复杂度：
         * - LinkedList实现的队列：
         *   * offer操作时间复杂度为O(1)
         *   * poll操作时间复杂度为O(1)
         *   * peek操作时间复杂度为O(1)
         * - PriorityQueue：
         *   * offer操作时间复杂度为O(log n)
         *   * poll操作时间复杂度为O(log n)
         *   * peek操作时间复杂度为O(1)
         * 
         * 使用场景：
         * - 任务调度
         * - 广度优先搜索（BFS）
         * - 缓冲区管理
         * - 优先级任务处理
         * 
         * 注意事项：
         * - PriorityQueue不是FIFO队列，而是按优先级出队
         * - 多线程环境下需要使用并发安全的实现类，如ConcurrentLinkedQueue
         */
         
        // 7. 推荐的队列实现
        System.out.println("\n=== 推荐的队列实现 ===");
        // 对于普通队列，推荐使用ArrayDeque
        java.util.Deque<String> deque = new java.util.ArrayDeque<>();
        deque.offer("元素1");
        deque.offer("元素2");
        System.out.println("ArrayDeque队首元素: " + deque.peek());
        System.out.println("ArrayDeque出队元素: " + deque.poll());
    }
}