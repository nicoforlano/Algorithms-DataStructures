package sorting;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public List<Integer> sort(List<Integer> elements) {
        for(int i = 0; i < elements.size(); i++) {
            for (int j = 0; j < elements.size() - 1; j++) {
                if(elements.get(j) > elements.get(j+1)) {
                    var elementAux = elements.get(j);
                    elements.set(j, elements.get(j+1));
                    elements.set(j+1, elementAux);
                }
            }
        }
        return elements;
    }

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(List.of(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("SORTED LIST: " + bubbleSort.sort(elements));
        elements = new ArrayList<>(List.of(9, 444, 46, 72, 11, 5, 3263, 187, 283, 4, 10, 3, 6, 35, 5235, 32, 64, 14, 414));
        System.out.println("SORTED LIST: " + bubbleSort.sort(elements));
    }
}
