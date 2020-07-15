package sorting;

import data.SortResult;

public class InsertionSort {
    public static void sort(int[] list, SortResult results){
        for(int i = 1; i < list.length; i++){
            int v = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > v){
                results.addInsertion();
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = v;
        }
    }
}
