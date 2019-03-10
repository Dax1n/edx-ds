package com.javartisan.tsinghua.ds.tree;

import java.util.ArrayList;

/**
 * @author:javartisan
 * @mail:javartisan@163.com
 */
public class BinTree<T> {

    private int size;
    private int height;
    private Node<T> root;

    public void setRoot(Node<T> root) {
        this.root = root;
        sizeInternal();
        heightInternal();
    }

    public void insertAsLeftChild(T e) {
        root.insertAsLeftChild(e);
        size++;
        heightInternal();
    }

    public void insertAsRightChild(T e) {
        insertAsRightChild(e);
        size++;
        heightInternal();
    }

    /**
     * 通过二叉树属性获取树的大小
     *
     * @return
     */
    public int size() {
        return size;
    }

    public int height() {
        return height;
    }

    /**
     * 通过节点计算获取二叉树的大小
     *
     * @return
     */
    private void sizeInternal() {
        int sizeValue = 0;
        if (root != null) {
            sizeValue = root.size();
        }
        size = sizeValue;
    }

    /**
     * 注意：单个节点树高度为0，空树的高度为-1
     *
     * @return
     */
    private void heightInternal() {
        // 默认值为树空
        int heightValue = -1;
        if (root != null) {
            heightValue = root.height();
        }
        height = heightValue;
    }

    private boolean isEmpty() {
        return root == null;
    }

    /**
     * 先序递归：先遍历当前节点，之后遍历左节点，最后遍历右节点的顺序为先序遍历；
     * 所以先中后序遍历的决定因素是：是由遍历当前节点的次序决定。
     */
    public void preRecursiveOrder() {
        if (isEmpty())
            return;
        root.preRecursiveOrder();
    }

    /**
     * 中序递归
     */
    public void inRecursiveOrder() {
        if (isEmpty())
            return;
        root.inRecursiveOrder();
    }

    /**
     * 后序递归
     */
    public void postRecursiveOrder() {
        if (!isEmpty())
            root.postRecursiveOrder();
    }

    /**
     * 先序非递归
     */
    public void preOrder() {
        if (!isEmpty())
            root.preOrder();
    }

    /**
     * 中序非递归
     */
    public void inOrder() {
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
