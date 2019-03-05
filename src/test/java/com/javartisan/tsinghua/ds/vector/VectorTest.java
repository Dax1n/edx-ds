package com.javartisan.tsinghua.ds.vector;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class VectorTest {

    @Test
    public void testAdd() {

        Random random = new Random();
        for (int j = 0; j < 10; j++) {
            Vector<Integer> vector = new Vector<>();
            for (int i = 0; i < 10; i++) {
                vector.add(random.nextInt(10));
            }

            System.out.println(vector);
            vector.bubble();
            System.out.println(vector);
        }


//        vector.sort();
//        System.out.println(vector);
//        System.out.println(vector.binarySearch(-1, 0, 10));
//        System.out.println(vector.binarySearch(2, 0, 10));
//        System.out.println(vector.binarySearch(5, 0, 10));
//        System.out.println(vector.binarySearch(50, 0, 10));

        // Assert.assertTrue("size not equal t0 zero .", vector.size() == 1);

    }

    @Test
    public void test() {
        int val = 2;
        System.out.println(2 << 1);
        System.out.println(val <<= 1);
        System.out.println(val);
    }


    @Test
    public void fabonacciTest() {
        System.out.println(fabonacci(0));
        System.out.println(fabonacci(1));
        System.out.println(fabonacci(2));
        System.out.println(fabonacci(3));
        System.out.println(fabonacci(4));
        System.out.println(fabonacci(5));
    }


    @Test
    public void getMidByFabonacciTest() {
        System.out.println(getMidByFabonacci(5));
        System.out.println(getMidByFabonacci(8));
        System.out.println(getMidByFabonacci(12));
        System.out.println(getMidByFabonacci(16));

    }

    /**
     * 斐波那契数据求黄金划分位置
     *
     * @param size
     * @return
     */
    public int getMidByFabonacci(int size) {
        int i = 1;
        // 计算第一个大于size的斐波那契数
        while (size > fabonacci(i)) i++;
        //前面那个斐波那契数就是黄金划分
        return fabonacci(i - 1);
    }


    public int fabonacci(int i) {
        if (i == 0 || i == 1)
            return 1;
        else
            return fabonacci(i - 2) + fabonacci(i - 1);
    }


}
