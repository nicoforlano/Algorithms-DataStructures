package recursion;

public class Factorial {

    /** Write two functions that finds the factorial of any number.
     * One should use recursive, the other should just use a for loop
     * */

    public int findFactorialRecursive(int n) {
        if(n == 1) {
            return n;
        }
        return n * findFactorialRecursive(n - 1);
    }

    public int findFactorialIterative(int n) {
        var factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        var factorial = new Factorial();
        var result = factorial.findFactorialRecursive(10);
        System.out.println("Recursive result: " + result);
        result = factorial.findFactorialIterative(5);
        System.out.println("Iterative result: " + result);
    }

}
