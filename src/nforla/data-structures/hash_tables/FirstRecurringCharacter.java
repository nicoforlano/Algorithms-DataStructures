package hash_tables;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {

    /*
    * Given an array of characters, find the first recurring one (first that gets repeated more than once).
    * Time Complexity: O(n)
    * */
    public static Object getFirstRecurringCharacter(Object[] array) {
        if(array == null || array.length == 0) {
            return null;
        }
        Map<Object, Integer> charactersCount = new HashMap<>();
        for (Object element : array) {
            if (charactersCount.containsKey(element)) {
                return element;
            }
            charactersCount.put(element, 1);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("Test Scenario: [2, 5, 1, 2, 3, 5, 1, 2, 4]");
        Object firstRecurringCharacter = FirstRecurringCharacter.getFirstRecurringCharacter(new Object[]{2, 5, 1, 2, 3, 5, 1, 2, 4});
        System.out.println("First Recurring Character: " + firstRecurringCharacter);

        System.out.println("Test Scenario: [2, 1, 1, 2, 3, 5, 1, 2, 4]");
        firstRecurringCharacter = FirstRecurringCharacter.getFirstRecurringCharacter(new Object[]{2, 1, 1, 2, 3, 5, 1, 2, 4});
        System.out.println("First Recurring Character: " + firstRecurringCharacter);

        System.out.println("Test Scenario: [2, 3, 4, 5]");
        firstRecurringCharacter = FirstRecurringCharacter.getFirstRecurringCharacter(new Object[]{2, 3, 4, 5});
        System.out.println("First Recurring Character: " + firstRecurringCharacter);

        System.out.println("Test Scenario: []");
        firstRecurringCharacter = FirstRecurringCharacter.getFirstRecurringCharacter(new Object[]{});
        System.out.println("First Recurring Character: " + firstRecurringCharacter);
    }
}
