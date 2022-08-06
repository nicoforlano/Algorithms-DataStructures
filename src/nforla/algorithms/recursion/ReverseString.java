package recursion;

public class ReverseString {

    public String reverseStringRecursive(String string) {
        if(string.length() <= 1) {
            return string;
        }
        return reverseStringRecursive(string.substring(string.length() / 2))
                .concat(
                 reverseStringRecursive(string.substring(0, string.length() / 2))
            );
    }

    public String reverseStringIterative(String string) {
        var result = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            result = result.concat(String.valueOf(string.charAt(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        var reverse = new ReverseString();
        var result = reverse.reverseStringRecursive("yoyo mastery");
        System.out.println("Reversed String: " + result);
        result = reverse.reverseStringIterative("yoyo mastery");
        System.out.println("Reversed String: " + result);
    }
}
