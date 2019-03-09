package com.javartisan.tsinghua.ds.queue;

import org.junit.Test;

public class QueueTest {

    @Test
    public void testQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        System.out.println("front = " + queue.front());
        System.out.println("rear = " + queue.rear());
        System.out.println("size = " + queue.size());
        queue.enQueue(3);
        queue.enQueue(4);
        System.out.println("deQueue = " + queue.deQueue());
        System.out.println("deQueue = " + queue.deQueue());
        System.out.println("size = " + queue.size());
        System.out.println("deQueue = " + queue.deQueue());
        System.out.println("deQueue = " + queue.deQueue());
    }

}
