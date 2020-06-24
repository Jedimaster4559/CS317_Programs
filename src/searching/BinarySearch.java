package searching;

import data.SearchResult;

public class BinarySearch {

    public static int search(int[] list, int value, SearchResult results){
        return search(list, value, results, 0, list.length-1);
    }

    private static int search(int[] list, int value, SearchResult results, int left, int right){
        int middleIndex = ((right - left) / 2) + left;
        int middleValue = list[middleIndex];
        results.addBinary();
        if(middleValue == value){
            return middleIndex;
        } else if(value < middleValue) {
            return search(list, value, results, left, middleIndex-1);
        } else {
            return search(list, value, results, middleIndex + 1, right);
        }
    }

}
