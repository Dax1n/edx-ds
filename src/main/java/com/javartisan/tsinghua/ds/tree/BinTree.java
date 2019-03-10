package com.javartisan.tsinghua.ds.tree;

public class BinTree<T> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public int size() {
        int size = 0;
        if (root != null) {
            size = root.size();
        }
        return size;
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
        tree.root = Node.build();
        System.out.println(tree.size());
        System.out.println(tree.height());

    }

}
