package arrays;

public class ReverseString {

    public static String reverseString(String string) {
        if(string == null || string.length() < 2) {
            return null;
        }
        StringBuilder reversedString = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string.charAt(i));
        }
        return reversedString.toString();
    }
    
    public static void main(String[] args) {
        String reversedString = reverseString("Hi my name is nico!");
        System.out.println("Reversed String: " + reversedString);
    }
}
