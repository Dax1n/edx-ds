package com.javartisan.tsinghua.ds.tree;

import java.util.Stack;

/**
 * @author:javartisan
 * @mail:javartisan@163.com
 */
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
        node.left = this.left;
        node.parent = this;
        this.left = node;
    }

    public void insertAsRightChild(T e) {
        Node node = new Node(e);
        node.right = this.right;
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

    /**
     * 先序递归：先序与中序都是尾递归，尾递归很容易改写迭代调用
     */
    public void preRecursiveOrder() {
        System.out.print(this.data + " ");
        if (this.left != null) {
            this.left.preRecursiveOrder();
        }
        if (this.right != null) {
            this.right.preRecursiveOrder();
        }
    }

    /**
     * 先序非递归，根据先序递归调用改写迭代版本
     */
    public void preOrder() {
        // 栈用于模拟递归栈
        Stack<Node> recursiveStack = new Stack<>();
        // 遍历当前节点，将当前节点存储到递归栈中
        recursiveStack.push(this);
        //只有当递归栈中没有数据了则遍历完毕
        while (!recursiveStack.empty()) {
            Node node = recursiveStack.pop();
            //模拟递归中左孩子节点的递归遍历
            //只要左孩子不为空一直遍历
            while (node != null) {
                System.out.print(node.data + " ");
                // 在递归中遍历左节点时候，右节点的递归遍历得不到执行
                // 因此调用栈会将右节点的递归调用放到递归栈中用于记录调用链
                recursiveStack.push(node.right);
                node = node.left;
            }
        }
    }

    public void preOrder2() {
        Stack<Node> recursiveStack = new Stack<>();
        recursiveStack.push(this);
        while (!recursiveStack.empty()) {
            Node node = recursiveStack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                recursiveStack.push(node.right);
            }
            if (node.left != null) {
                recursiveStack.push(node.left);
            }
        }
    }

    /**
     * 中序递归：先序与中序都是尾递归，尾递归很容易改写迭代调用
     */
    public void inRecursiveOrder() {
        if (this.left != null) {
            this.left.inRecursiveOrder();
        }
        System.out.print(this.data + " ");
        if (this.right != null) {
            this.right.inRecursiveOrder();
        }
    }

    /**
     * 中序非递归
     */
    public void inOrder() {
        Stack<Node> recursiveStack = new Stack<>();
        Node node = this;
        recursiveStack.push(node);
        while (!recursiveStack.empty()) {
            while (node != null) {
                recursiveStack.push(node);
                node = node.left;
            }
            node = recursiveStack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                recursiveStack.push(node.right);
            }
            if (recursiveStack.empty()) {
                break;
            }
            node = recursiveStack.pop();
        }
    }

    /**
     * 后序递归：非尾递归
     */
    public void postRecursiveOrder() {
        if (this.left != null) {
            this.left.postRecursiveOrder();
        }
        if (this.right != null) {
            this.right.postRecursiveOrder();
        }
        System.out.print(this.data + " ");
    }

    /**
     * 后序非递归
     */
    public void postOrder() {
    }

    /**
     * 层次递归
     */
    public void levelOrder() {
    }
}
