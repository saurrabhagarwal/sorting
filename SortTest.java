

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{4, 3, 5, 1, 2})));
        System.out.println(Arrays.toString(insertionSort(new int[]{4, 3, 5, 1, 2})));
        System.out.println(Arrays.toString(merge(new int[]{1, 3, 5}, new int[]{2, 6})));
        System.out.println(Arrays.toString(mergeSort(new int[]{4, 3, 5, 1, 2})));
        System.out.println(Arrays.toString(quickSort(new int[]{4, 3, 5, 1, 2},0,4)));
    }
    static int[] quickSort(int[] arr,int left,int right) {
        if (left<right){
            int pivot= pivot(arr,left, right);
            quickSort(arr,0,pivot-1);
            quickSort(arr,pivot+1,right);
        }
        return arr;
    }

    static int pivot(int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr,swapIndex,pivotIndex);

        return swapIndex;
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[index] = arr1[i];
                i++;
            } else {
                arr[index] = arr2[j];
                j++;
            }
            index++;
        }
        while (i < arr1.length) {
            arr[index] = arr1[i];
            i++;
            index++;
        }
        while (j < arr2.length) {
            arr[index] = arr2[j];
            j++;
            index++;
        }
        return arr;
    }

    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > -1 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
