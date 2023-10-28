package com.kundan.practice;

public class RecursionTest {

    /*

    print(5)
        val = print(4)
            val = print(3)
                val = print(2)
                    val = print(1)
                        val = print(0) = 0, don't print anything


     */

    static int i=0;

    int print(int num) {
        if (num == 0) {
            return 0;
        }
        else {
            System.out.println("before recursion num="+num+" i="+i);
            i++;
            int val = print(num-1);
            System.out.println("after recursion num="+num+" i="+i);
            return val;
        }
    }

    public static void main(String[] args) {
        new RecursionTest().print(5);
    }

}
