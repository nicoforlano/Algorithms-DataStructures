package sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public List<Integer> sort(List<Integer> elements) {

        if(elements.size() <= 1) {
            return elements;
        }

        Integer pivot = elements.get(elements.size() - 1);
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for(Integer element: elements) {
            if(element < pivot) {
                leftArr.add(element);
            } else if(element > pivot) {
                rightArr.add(element);
            }
        }
        var result = sort(leftArr);
        result.add(pivot);
        result.addAll(sort(rightArr));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(List.of(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 50));
        QuickSort quickSort = new QuickSort();
        System.out.println("Quick SORTED LIST: " + quickSort.sort(elements));
        elements = new ArrayList<>(List.of(9, 444, 46, 72, 11, 5, 3263, 187, 283, 4, 10, 3, 6, 35, 5235, 32, 64, 14, 414));
        System.out.println("Quick SORTED LIST: " + quickSort.sort(elements));
    }
}
