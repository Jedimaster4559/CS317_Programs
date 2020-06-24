package searching;

import data.SearchResult;

public class SequentialSearch {

    public static int search(int[] list, int value, SearchResult results){
        for(int i = 0; i < list.length; i++){
            results.addSequential();
            if(list[i] == value){
                return i;
            }
        }
        return -1;
    }

}
