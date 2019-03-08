package com.javartisan.tsinghua.ds.stack;


/**
 * 实现一个任意进制到任意进制的转换的算法
 *
 * @param <T>
 */
public class Stack<T> {


    private Object[] data;

    private int size = 0;
    private int capacity = DEFAULT_SIZE;
    private final static int DEFAULT_SIZE = 10;

    public Stack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public Stack() {
        this(DEFAULT_SIZE);
    }


    public T pop() {
        if (size < 1) {
            throw new IllegalArgumentException("Stack Empty.");
        }
        T e = (T) data[size - 1];
        data[size - 1] = null;
        size--;
        return e;
    }

    public void push(T e) {
        expand();
        data[size++] = e;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return (T) data[size - 1];
    }

    private void expand() {
        if (size == capacity) {
            capacity = capacity + (capacity >> 1);
            Object[] newData = new Object[capacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }


    public String transform() {
        //TODO 实现一个任意进制到任意进制的转换的算法
        return "";
    }

    public String transformToRadix(int num, int radix) {
        char[] digt = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        Stack<Character> stack = new Stack<>();
        while (num != 0) {
            int val = num % radix;
            stack.push(digt[val]);
            num = num / radix;
        }
        StringBuilder builder = new StringBuilder(stack.size);
        while (stack.size() > 0) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
