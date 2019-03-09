package com.javartisan.tsinghua.ds.queue;

/**
 * 可以继承List实现，学习的话自己实现
 * @param <T>
 */
public class Queue<T> {

    private static class Node<T> {
        private T data;
        private Node next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node<T> header = new Node();
    private Node<T> tailer = new Node<>();
    /**
     * 其实使用双向Node的话就不需要记录最后一个节点了
     */
    private Node<T> rear = null;

    {
        header.next = tailer;
    }

    private int size = 0;

    public int size() {
        return size;
    }

    public void enQueue(T e) {
        Node node = new Node();
        tailer.data = e;
        tailer.next = node;
        rear = tailer;
        tailer = node;
        size++;
    }

    public T deQueue() {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        Node node = header.next;
        T e = (T) node.data;
        header.next = node.next;
        node.next = null;
        size--;
        return e;
    }


    public T front() {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return (T) header.next.data;
    }

    public T rear() {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return rear.data;
    }

}
