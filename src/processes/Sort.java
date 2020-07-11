package processes;

import data.DataHandler;
import data.SortAverage;
import data.SortResult;
import sorting.InsertionSort;
import sorting.QuickSort;

import java.util.*;

public class Sort {
    private static boolean averaged = false;
    public static void Run(){
        System.out.println("Please enter a number of times to perform the experiment. Note: the higher the number, the better the data will be, however larger numbers take more time to process:");
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();

        DataHandler.start();

        double totalTests = (double)DataHandler.getLength() * numTests;
        double testsRun = 0;
        for (int i = 1; i <= DataHandler.getLength(); i++) {
            //System.out.println(i);
            SortAverage average = new SortAverage(i);
            int[] list = DataHandler.getValues(i);
            for(int j = 0; j < numTests; j++) {
                int[] randomList = randomize(list);
                int[] insertionSortList = randomList.clone();
                int[] quickSortList = randomList.clone();
                SortResult result = new SortResult(randomList);
                InsertionSort.sort(insertionSortList, result);
                QuickSort.sort(quickSortList, result);
                average.addResult(result);
                testsRun++;
                double percentage = Math.round((testsRun/totalTests) * 10000) / 100.0;
                System.out.println(percentage + "% Complete");
            }
            DataHandler.writeSort(average.toString());

            // Demonstrate Worst Case Situations
        }
    }

    public static int[] randomize(int[] input){
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : input){
            list.add(num);
        }

        Random r = new Random();
        int[] newList = new int[input.length];
        int counter = 0;
        while(list.size() > 0){
            int index = r.nextInt(list.size());
            newList[counter] = list.get(index);
            list.remove(index);
            counter++;
        }

        return newList;
    }

}
