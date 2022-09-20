package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public List<Integer> sort(List<Integer> elements) {
        if(elements.size() == 1) {
            return elements;
        }

        var middle = elements.size() / 2;
        List<Integer> left = elements.subList(0, middle);
        List<Integer> right = elements.subList(middle, elements.size());

        return merge(
                sort(left),
                sort(right)
        );
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < left.size() && rightIndex < right.size()) {
            if(left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(List.of(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        MergeSort mergeSort = new MergeSort();
        System.out.println("Merge SORTED LIST: " + mergeSort.sort(elements));
        elements = new ArrayList<>(List.of(9, 444, 46, 72, 11, 5, 3263, 187, 283, 4, 10, 3, 6, 35, 5235, 32, 64, 14, 414));
        System.out.println("Merge SORTED LIST: " + mergeSort.sort(elements));
    }
}
