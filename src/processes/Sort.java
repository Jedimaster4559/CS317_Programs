package processes;

import data.DataHandler;
import data.SortAverage;
import data.SortResult;

public class Sort {
    private static boolean complete = false;
    public static void Run(){
        configure();
        DataHandler.start();

        if(complete){

        } else {
            for(int i = 1; i <= DataHandler.getLength(); i++){
                System.out.println(i);
                SortAverage average = new SortAverage(i);
                int[] list = DataHandler.getValues(i);
                for(int j = 0; j < i; j++){
                    SortResult result = new SortResult(list);
                    InsertionSort.search(list, list[j], result);
                    QuickSort.search(list, list[j], result);
                    average.addResult(result);
                }
                DataHandler.writeSort(average.toString());
                DataHandler.writeWorstSort(average.printWorstCase());
            }
        }
    }

    private static void configure(){

    }
}
