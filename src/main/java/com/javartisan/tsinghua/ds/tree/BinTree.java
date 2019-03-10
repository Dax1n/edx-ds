package com.javartisan.tsinghua.ds.tree;

public class BinTree<T> {

    private int size;
    private int height;

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

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
    public void heightInternal() {
        // 默认值为树空
        int heightValue = -1;
        if (root != null) {
            heightValue = root.height();
        }
        height = heightValue;
    }

    public static void main(String[] args) {
        BinTree tree = new BinTree();
        tree.setRoot(Node.build());
        System.out.println(tree.size());
        System.out.println(tree.height());

    }

}
