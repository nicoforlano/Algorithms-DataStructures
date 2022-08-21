package sorting;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public List<Integer> sort(List<Integer> elements) {
        for(int i = 0; i < elements.size(); i++) {
            var minElementIndex = i;
            for (int j = i + 1; j < elements.size(); j++) {
                if(elements.get(minElementIndex) > elements.get(j)) {
                    minElementIndex = j;
                }
            }
            var tempElement = elements.get(i);
            elements.set(i, elements.get(minElementIndex));
            elements.set(minElementIndex, tempElement);
        }
        return elements;
    }

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(List.of(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        SelectionSort selectionSort = new SelectionSort();
        System.out.println("SORTED LIST: " + selectionSort.sort(elements));
        elements = new ArrayList<>(List.of(9, 444, 46, 72, 11, 5, 3263, 187, 283, 4, 10, 3, 6, 35, 5235, 32, 64, 14, 414));
        System.out.println("SORTED LIST: " + selectionSort.sort(elements));
    }
}
