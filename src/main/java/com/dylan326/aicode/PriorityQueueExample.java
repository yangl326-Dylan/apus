package com.dylan326.aicode;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;

public class PriorityQueueExample {
    
    public static void main(String[] args) {
        // 1. 创建默认的小顶堆（最小堆）
        System.out.println("=== 默认小顶堆示例 ===");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.offer(9);
        
        System.out.println("小顶堆元素按优先级输出:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
        
        // 2. 创建大顶堆（最大堆）
        System.out.println("\n=== 大顶堆示例 ===");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);
        maxHeap.offer(9);
        
        System.out.println("大顶堆元素按优先级输出:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
        
        // 3. 使用Lambda表达式创建大顶堆
        System.out.println("\n=== Lambda表达式创建大顶堆 ===");
        PriorityQueue<Integer> maxHeapLambda = new PriorityQueue<>((a, b) -> b - a);
        maxHeapLambda.offer(5);
        maxHeapLambda.offer(2);
        maxHeapLambda.offer(8);
        maxHeapLambda.offer(1);
        maxHeapLambda.offer(9);
        
        System.out.println("Lambda大顶堆元素按优先级输出:");
        while (!maxHeapLambda.isEmpty()) {
            System.out.print(maxHeapLambda.poll() + " ");
        }
        System.out.println();
        
        // 4. 自定义对象排序示例
        System.out.println("\n=== 自定义对象排序示例 ===");
        PriorityQueue<Person> personQueue = new PriorityQueue<>();
        personQueue.offer(new Person("Alice", 25));
        personQueue.offer(new Person("Bob", 30));
        personQueue.offer(new Person("Charlie", 20));
        personQueue.offer(new Person("David", 35));
        
        System.out.println("按年龄升序输出:");
        while (!personQueue.isEmpty()) {
            Person p = personQueue.poll();
            System.out.println(p.name + " - " + p.age);
        }
        
        // 5. 使用自定义Comparator排序
        System.out.println("\n=== 自定义Comparator按姓名排序 ===");
        PriorityQueue<Person> nameQueue = new PriorityQueue<>(Comparator.comparing(p -> p.name));
        nameQueue.offer(new Person("Alice", 25));
        nameQueue.offer(new Person("Bob", 30));
        nameQueue.offer(new Person("Charlie", 20));
        nameQueue.offer(new Person("David", 35));
        
        System.out.println("按姓名字母顺序输出:");
        while (!nameQueue.isEmpty()) {
            Person p = nameQueue.poll();
            System.out.println(p.name + " - " + p.age);
        }
    }
    
    static class Person implements Comparable<Person> {
        String name;
        int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
    }
}