package data;

public class SortResult {
    private int insertionCount;
    private int quickCount;
    private int[] list;

    public SortResult(int[] list){
        this.insertionCount = 0;
        this.quickCount = 0;
        this.list = list;
    }

    public void addQuick(){
        quickCount++;
    }

    public void addInsertion(){
        insertionCount++;
    }

    public int getQuickCount(){
        return quickCount;
    }

    public int getInsertionCount(){
        return insertionCount;
    }

    public int[] getList(){
        return list;
    }
}
