import data.DataHandler;
import data.SearchAverage;
import data.SearchResult;
import searching.BinarySearch;
import searching.SequentialSearch;

public class Program1Main {
    public static void main(String[] args){
        DataHandler.start();

        for(int i = 1; i <= DataHandler.getLength(); i++){
            System.out.println(i);
            SearchAverage average = new SearchAverage(i);
            int[] list = DataHandler.getValues(i);
            for(int j = 0; j < i; j++){
                SearchResult result = new SearchResult();
                BinarySearch.search(list, list[j], result);
                SequentialSearch.search(list, list[j], result);
                average.addResult(result);
            }
            average.calculateAverages();
            DataHandler.writeFile(average.toString());
        }

        System.out.println("Done");
    }
}
