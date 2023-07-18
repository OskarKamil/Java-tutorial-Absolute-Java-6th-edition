package chapter11;

public class Sub1 {
    static void repeat(String string, int times) {
        if (times >= 1) {
            System.out.println(string);
            repeat(string, times - 1);
        }
    }
    /*
     * Recursive method is a method that has its own invocation in the definition.
     */

    static void countUp(int max) {
        if (max >= 1) {
            countUp(max - 1);
            System.out.println(max);
        }
    }
    /*
     * Another recursive method. For a recursive method to be correct, it needs a
     * stopping case. It is a case when iteration of a method doesn't occur, thus,
     * breaking the chain.
     */

    static void countDown(int start) {
        if (start >= 1) {
            System.out.println(start);
            countDown(start - 1);
        }
    }
    /* Another example. */

    static void infiniteCountUp(int start) {
        System.out.println(start);
        infiniteCountUp(start + 1);
    }
    /*
     * This is an infinite recursion. All recursion should have a stopping case.
     * Here each invocation of this method will cause an invocation of itself all
     * over again with no way of stopping it. The program will end with an error
     * StackOverflow.
     */

    public static void main(String[] args) {
        repeat("Hello. Here's Agatha!", 4);

        countUp(25);

        System.out.println("========");

        countDown(60);

        // infiniteCountUp(1);
    }
}
/*
 * Recursions are not mandatory to use. This means, all recursions could be
 * replaced with loop or loops. Sometimes recursions are easier to read and
 * understand. While some cases would be difficult and not written in readable way with
 * loops. However, loops are more desirable because in most cases they have
 * better performance over recursions.
 */