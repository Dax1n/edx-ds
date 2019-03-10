package com.javartisan.tsinghua.ds.list;

public class List<T> {


    private static class Node<T> {
        private T data;
        private Node before;
        private Node next;
    }
}
