package com.javartisan.tsinghua.ds.tree;

public class BinTree<T> {

    private int size;

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
        size = size();
    }

    public void insertAsLeftChild(T e) {
        root.insertAsLeftChild(e);
        size++;
    }

    public void insertAsRightChild(T e) {
        insertAsRightChild(e);
        size++;
    }

    /**
     * 通过二叉树属性获取树的大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 通过节点计算获取二叉树的大小
     *
     * @return
     */
    public int size() {
        int sizeValue = 0;
        if (root != null) {
            sizeValue = root.size();
        }
        return sizeValue;
    }

    /**
     * 注意：单个节点树高度为0，空树的高度为-1
     *
     * @return
     */
    public int height() {
        // 默认值为树空
        int height = -1;
        if (root != null) {
            height = root.height();
        }
        return height;
    }

    public static void main(String[] args) {
        BinTree tree = new BinTree();
        tree.setRoot(Node.build());
        System.out.println(tree.size());
        System.out.println(tree.height());

    }

}
