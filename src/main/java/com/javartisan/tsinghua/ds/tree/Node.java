package com.javartisan.tsinghua.ds.tree;

import java.util.Map;

class Node<T> {
    T data;
    Node parent;
    Node left;
    Node right;

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }

    public void insertAsLeftChild(T e) {
        Node node = new Node(e);
        node.parent = this;
        this.left = node;
    }

    public void insertAsRightChild(T e) {
        Node node = new Node(e);
        node.parent = this;
        this.right = node;
    }

    public int size() {
        if (this.left == null && this.right == null) {
            // 递归基：此时左右节点为null，当前树大小为当前一个节点，所以是1
            return 1;
        }
        int leftSize = 0;
        if (this.left != null) {
            // 左子树不为空，递归计算
            leftSize = this.left.size();
        }
        int rightSize = 0;
        if (this.right != null) {
            // 右子树不为空，递归计算
            rightSize = this.right.size();
        }
        // 左子树+右子树+当前一个节点
        return leftSize + rightSize + 1;
    }

    public static Node build() {
        Node<Integer> root = new Node(0);
        Node<Integer> n1 = new Node(1);
        Node<Integer> n2 = new Node(2);
        root.left = n1;
        root.right = n2;
        n1.parent = n2.parent = root;
        Node<Integer> n3 = new Node(3);
        Node<Integer> n4 = new Node(4);
        n1.left = n3;
        n1.right = n4;
        // 连续赋值，=赋值操作符返回值是右边的值，例如：a=20的返回值是20,即： System.out.println(a=20);输出是20
        n3.parent = n4.parent = n1;
        Node<Integer> n5 = new Node(5);
        Node<Integer> n6 = new Node(6);
        n2.left = n5;
        n2.right = n6;
        n5.parent = n6.parent = n2;
        return root;
    }

    public int height() {
        if (this.left == this.right && this.right == null) {
            return 0;
        }

        int leftHeight = -1;
        if (this.left != null) {
            leftHeight = this.left.height();
        }
        int rightHeight = -1;
        if (this.right != null) {
            rightHeight = this.right.height();
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
