package com.javartisan.tsinghua.ds.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinTreeTest {

    BinTree tree = null;

    @Before
    public void init() {
        tree = new BinTree();
        tree.setRoot(Node.build());
    }

    @Test
    public void testBinTree() {
        System.out.println(tree.size());
        System.out.println(tree.height());
        System.out.println();
    }

    @Test
    public void preRecursiveOrder() {
        tree.preRecursiveOrder();
        System.out.println();
        tree.preOrder();
        System.out.println();
        tree.preOrder2();
    }

    @Test
    public void inRecursiveOrder() {
        tree.inRecursiveOrder();
        System.out.println();
        tree.inOrder();
    }

    @Test
    public void postRecursiveOrder() {
        tree.postRecursiveOrder();
        System.out.println();
    }

    @After
    public void destory() {
        tree = null;
    }
}
