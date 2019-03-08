package com.javartisan.tsinghua.ds.list;

/**
 * @param <T>
 */
public class List<T> {
    /**
     * 哨兵节点
     */
    private Node<T> header = new Node<>();
    /**
     * 哨兵节点
     */
    private Node<T> tail = new Node<>();
    private int size = 0;

    {
        header.next = tail;
        tail.before = header;
    }

    public int size() {
        return size;
    }

    /**
     * 尾插法
     *
     * @param e
     */
    public void add(T e) {
        Node node = new Node();
        node.setData(e);

        Node tmpTail = tail.before;
        node.next = tail;
        tail.before = node;
        tmpTail.next = node;
        node.before = tmpTail;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index = " + index + "is an error index.");
        }
    }

    public T remove(int index) {
        checkIndex(index);
        Node targetNode;
        int mid = size >> 1;
        if (index > mid) {
            //尾部向前
            int moveIndex = size - index - 1;
            targetNode = tail;
            while (moveIndex >= 0) {
                moveIndex--;
                targetNode = targetNode.before;
            }
        } else {
            //头部向后
            targetNode = header;
            while (index >= 0) {
                targetNode = targetNode.next;
                index--;
            }
        }
        targetNode.before.next = targetNode.next;
        targetNode.next.before = targetNode.before;
        targetNode.before = null;
        targetNode.next = null;
        size--;
        return (T) targetNode.data;
    }


    private static class Node<T> {
        private T data;
        private Node before;
        private Node next;

        @Override
        public String toString() {
            return data.toString();
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getBefore() {
            return before;
        }

        public void setBefore(Node before) {
            this.before = before;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int count = size;
        Node node = header;
        while (count > 0) {
            node = node.next;
            if (count > 1) {
                builder.append(node.data).append(", ");
            } else {
                builder.append(node.data);
            }
            count--;
        }
        builder.append("]");

        return builder.toString();
    }

    private Node<T> find(T e) {
        int count = size;
        Node h = header;
        Node t = tail;
        while (count > 0 && h != t) {
            h = h.next;
            if (h.data.equals(e)) {
                return h;
            }
            t = t.before;
            if (t.data.equals(e)) {
                return t;
            }
            count = count - 2;
        }
        return null;
    }

    public void sort() {
        int count = size;
        int limit = size;
        for (int i = count; i > 0; i--) {

        }
    }


    public T get(int index) {
        checkIndex(index);
        int mid = size >> 1;
        Node node;
        if (index > mid) {
            // 后向前
            int count = size - 1 - index;
            node = tail;
            while (count >= 0) {
                node = node.before;
                count--;
            }
        } else {
            node = header;
            int count = index;
            while (count >= 0) {
                node = node.next;
                count--;
            }
        }
        return (T) node.data;
    }


    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        System.out.println(list.find(3));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list);
    }

}
