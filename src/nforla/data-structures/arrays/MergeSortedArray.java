package arrays;


import java.util.Arrays;

public class MergeSortedArray {

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        if(array1 == null  || array1.length == 0) {
            return array2;
        }
        if(array2 == null || array2.length == 0) {
            return array1;
        }

        int[] mergedSortedArrays = new int[array1.length + array2.length];
        int k = 0, j = 0;

        for (int i=0; i < mergedSortedArrays.length; i++) {
            if(k != array1.length && (j == array2.length || array1[k] < array2[j])) {
                mergedSortedArrays[i] = array1[k];
                k++;
            } else {
                mergedSortedArrays[i] = array1[j];
                j++;
            }
            System.out.println(Arrays.toString(mergedSortedArrays));
        }

        return mergedSortedArrays;
    }

    public static void main(String[] args) {

        int[] result = MergeSortedArray.mergeSortedArrays(new int[]{1,1,8,9,10}, new int[]{1,2,8,9,11,15,16});
        System.out.println(Arrays.toString(result));
    }
}
