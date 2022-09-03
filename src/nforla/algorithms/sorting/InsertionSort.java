package sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    public List<Integer> sort(List<Integer> elements) {
        for (int i = 1; i < elements.size(); i++) {
            if(elements.get(i) < elements.get(i - 1)) {
                int j = i;
                while(j > 0 && elements.get(j) < elements.get(j - 1)) {
                    var temp = elements.get(j);
                    elements.set(j, elements.get(j- 1));
                    elements.set(j - 1, temp);
                    j--;
                }
            }
        }
        return elements;
    }

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(List.of(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        InsertionSort insertionSort = new InsertionSort();
        System.out.println("INSERTION SORTED LIST: " + insertionSort.sort(elements));
        elements = new ArrayList<>(List.of(9, 444, 46, 72, 11, 5, 3263, 187, 283, 4, 10, 3, 6, 35, 5235, 32, 64, 14, 414));
        System.out.println("INSERTION SORTED LIST: " + insertionSort.sort(elements));
    }
}