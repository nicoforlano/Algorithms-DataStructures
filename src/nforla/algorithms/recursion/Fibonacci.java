package recursion;

public class Fibonacci {
    /**
     * Given a number N return the index value of the Fibonacci sequence, where the sequence is:
     *
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
     * the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3
     * For example: fibonacciRecursive(6) should return 8
     * */

    //O(2 ^ n) - Size of recursive tree grows exponentially grows
    public int fibonacciRecursive(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // O(n)
    public int fibonacciIterative(int n) {
        int lastElement = 1;
        int penultimate = 0;
        int result = 0;
        for(int i = 2; i <= n; i++) {
            result = lastElement + penultimate;
            penultimate = lastElement;
            lastElement = result;
        }
        return result;
    }

    public static void main(String[] args) {
        var fibonacci = new Fibonacci();
        var result = fibonacci.fibonacciRecursive(14);
        System.out.println("Recursive result: " + result);
        result = fibonacci.fibonacciIterative(14);
        System.out.println("Iterative result: " + result);
    }
}
