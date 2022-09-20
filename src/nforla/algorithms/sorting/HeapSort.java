package sorting;

import java.util.Arrays;

public class HeapSort {
    /**
     * Reorders elements in array to build the Binary Heap in Array respresentation(index mapping), where:
     * parent(i) = i / 2
     * leftChild(i) = 2 * i + 1
     * rightChild(i) = 2 * i + 2
     * */
    private void buildHeap(int[] elements) {
        for(int i = elements.length / 2; i >=0 ; i--) {
            maxHeapify(elements, elements.length, i);
        }
    }
    /**
     * Maintians max-heap property where elements[parent(i)] >= elements[i]
     * */
    private void maxHeapify(int[] elements, int heapSize, int index) {
        int leftNodeIndex = 2 * index + 1;
        int rightNodeIndex = 2 * index + 2;
        int largest = index;

        if(leftNodeIndex < heapSize && elements[leftNodeIndex] > elements[largest]) {
            largest = leftNodeIndex;
        }
        if(rightNodeIndex < heapSize && elements[rightNodeIndex] > elements[largest]) {
            largest = rightNodeIndex;
        }
        if(largest != index) {
            int temp = elements[index];
            elements[index] = elements[largest];
            elements[largest] = temp;
            maxHeapify(elements, heapSize, largest);
        }
    }

    public int[] sort(int[] elements) {
        int heapSize = elements.length;
        buildHeap(elements);
        for(int j = elements.length - 1; j > 0; j--) {
            int temp = elements[0];
            elements[0] = elements[j];
            elements[j] = temp;
            heapSize--;
            maxHeapify(elements, heapSize, 0);
        }
        return elements;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] elements = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 50};
        System.out.println("Heap SORTED LIST: " + Arrays.toString(heapSort.sort(elements)));
        elements = new int[] {9, 444, 46, 72, 11, 5, 3263, 187, 283, 4, 10, 3, 6, 35, 5235, 32, 64, 14, 414};
        System.out.println("Heap SORTED LIST: " + Arrays.toString(heapSort.sort(elements)));
    }
}
