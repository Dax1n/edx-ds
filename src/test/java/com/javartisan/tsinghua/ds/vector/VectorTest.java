package com.javartisan.tsinghua.ds.vector;

import org.junit.Assert;
import org.junit.Test;

public class VectorTest {

    @Test
    public void testAdd() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        Assert.assertTrue("size not equal t0 zero .", vector.size() == 1);

    }

}
