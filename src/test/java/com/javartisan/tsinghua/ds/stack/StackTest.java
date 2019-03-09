package com.javartisan.tsinghua.ds.stack;

import org.junit.Test;

public class StackTest {

    @Test
    public void testStack() {

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 30; i++) {
            s.push(i);
        }
        System.out.println(s.size());
        for (int i = 0; i < 30; i++) {
            System.out.println(s.pop());

        }
        System.out.println(s.size());

        int num = 89;
        while (num != 0) {
            int val = num % 2;
            s.push(val);
            num >>= 1;
        }


        while (s.size() > 0) {
            System.out.print(s.pop());
        }
        System.out.println();
        System.out.println(s.transformToRadix(89, 2));
        System.out.println(s.transformToRadix(175, 2));

        int aa = 031;
        int aaa = 0x31;
        System.out.println(Integer.parseInt("031", 8));
        System.out.println(Integer.parseInt("AF", 16));
        System.out.println(aa);

        System.out.println("========================");
        int af = 0xAF;
        System.out.println(s.transformToRadix(af, 2));
        System.out.println(s.transformToRadix(0xF, 10));
        System.out.println(Integer.parseInt("F", 16));
        System.out.println(Integer.parseInt("1", 16));

    }

    @Test
    public void exprMatch() {
        String expr = "((a+b)*c+d*(e-f))";
        Stack<Character> s = new Stack<>();
        System.out.println(s.exprMatch(expr));
    }

    @Test
    public void exprMatch2() {
        String expr = "((a+b)*c+d*(e-f))";
        Stack<Character> s = new Stack<>();
        System.out.println(s.exprMatch2(expr));
    }


}
