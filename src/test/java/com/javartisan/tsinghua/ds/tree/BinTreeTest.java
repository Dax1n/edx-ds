package com.javartisan.tsinghua.ds.tree;

import org.junit.Test;

public class BinTreeTest {

    @Test
    public void testBinTree() {
        BinTree tree = new BinTree();
        tree.setRoot(Node.build());
        System.out.println(tree.size());
        System.out.println(tree.height());
    }
}
