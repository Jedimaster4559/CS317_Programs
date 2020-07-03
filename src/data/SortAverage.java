package data;

public class SortAverage {
    private int listSize;
    private int[] worstQuickPermutation;
    private int[] worstInsertionPermutation;
    private int worstQuickPermutationComparisons;
    private int worstInsertionPermutationComparisons;
    private double quickAverage;
    private double insertionAverage;
    private double resultsAdded = 0;

    public SortAverage(int listSize){
        this.listSize = listSize;
        this.worstQuickPermutation = new int[listSize];
        this.worstInsertionPermutation = new int[listSize];
        this.worstQuickPermutationComparisons = Integer.MIN_VALUE;
        this.worstInsertionPermutationComparisons = Integer.MIN_VALUE;
        this.quickAverage = 0;
        this.insertionAverage = 0;
        this.resultsAdded = 0;
    }


    public void addResult(SortResult result){
        quickAverage = (quickAverage * (resultsAdded / (resultsAdded + 1))) + (result.getQuickCount() * (1 / (resultsAdded + 1)));
        insertionAverage = (insertionAverage * (resultsAdded / (resultsAdded + 1))) + (result.getInsertionCount() * (1 / (resultsAdded + 1)));
        resultsAdded++;

        if(result.getInsertionCount() > worstInsertionPermutationComparisons){
            worstInsertionPermutationComparisons = result.getInsertionCount();
            worstInsertionPermutation = result.getList();
        }

        if(result.getQuickCount() > worstQuickPermutationComparisons){
            worstQuickPermutationComparisons = result.getQuickCount();
            worstQuickPermutation = result.getList();
        }
    }

    public String toString(){
        return listSize + "," + quickAverage + "," + insertionAverage;
    }

    public String printWorstCase(){
        return listSize + "\t" + worstQuickPermutation.toString() + "\t" + worstInsertionPermutation.toString();
    }
}
