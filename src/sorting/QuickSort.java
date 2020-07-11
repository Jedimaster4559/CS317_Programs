package sorting;

import data.SortResult;

public class QuickSort {
    public static void sort(int[] list, SortResult results){
        sort(list, results, 0, list.length - 1);
    }

    private static void sort(int[] list, SortResult results, int left, int right){
        if(left < right){
            results.addQuick();
            int split = hoarePartition(list, results, left, right);
            sort(list, results, left, split-1);
            sort(list, results, split + 1, right);
        }
    }

    private static int hoarePartition(int[] list, SortResult results, int left, int right){
        int pivot = list[left];
        int leftCounter = left + 1;
        int rightCounter = right;
        while(rightCounter > leftCounter){
            results.addQuick();
            while (rightCounter > left && list[rightCounter] >= pivot){
                results.addQuick();
                results.addQuick();
                rightCounter--;
            }
            while (leftCounter < right && list[leftCounter] <= pivot){
                results.addQuick();
                results.addQuick();
                leftCounter++;
            }
            swap(list, leftCounter, rightCounter);
        }
        swap(list, leftCounter, rightCounter);

        // I was having a strange situation occur where the
        // Partition would not behave correctly if there was one
        // element outside of the partition. This code handles those
        // situations
        results.addQuick();
        if(right - left > 1 ) {
            swap(list, left, rightCounter);
        } else {
            results.addQuick();
            if(list[left] > list[right]){
                swap(list, left, right);
            }
        }
        return rightCounter;
    }

    private static void swap(int[] list, int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
