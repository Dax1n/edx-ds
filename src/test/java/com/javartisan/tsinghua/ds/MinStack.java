//import java.util.Stack;
//
//public class MinStack {
//
//    Node top = new Node(null);
//    int minValue = Integer.MAX_VALUE;
//    Stack<Integer> minStack = new Stack();
//
//    private static class Node {
//        Integer data;
//        Node next = null;
//
//        public Node(Integer data) {
//            this.data = data;
//        }
//    }
//
//
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack() {
//
//    }
//
//    public void push(int x) {
//        Node e = new Node(x);
//        Node rest = top.next;
//        top.next = e;
//        e.next = rest;
//        if (x <= minValue) {
//            minValue = x;
//            minStack.push(minValue);
//        }
//    }
//
//    public void pop() {
//        if (top.next == null) {
//            throw new IllegalArgumentException("stack empty");
//        }
//        Node rest = top.next.next;
//        Node e = top.next;
//        top.next = rest;
//        e.next = null;
//        if (e.data == minStack.peek()) {
//            minStack.pop();
//        }
//    }
//
//    public int top() {
//        if (this.top.next == null) {
//            throw new IllegalArgumentException("stack empty");
//        }
//        return this.top.next.data;
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }
//}
//
