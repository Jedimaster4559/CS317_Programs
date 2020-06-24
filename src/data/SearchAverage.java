package data;

import java.util.ArrayList;

public class SearchAverage {
    private int listSize;
    private ArrayList<SearchResult> results;
    private double binaryAverage;
    private double sequentialAverage;

    public SearchAverage(int listSize){
        this.listSize = listSize;
        results = new ArrayList<>();
        this.binaryAverage = 0;
        this.sequentialAverage = 0;
    }

    public void calculateAverages(){
        for(SearchResult result : results){
            binaryAverage += (double)result.getBinaryCount();
            sequentialAverage += (double)result.getSequentialCount();
        }
        binaryAverage = (double)binaryAverage / (double)listSize;
        sequentialAverage = (double)sequentialAverage / (double)listSize;
    }

    public void addResult(SearchResult result){
        results.add(result);
    }

    public String toString(){
        return listSize + "," + binaryAverage + "," + sequentialAverage;
    }
}
