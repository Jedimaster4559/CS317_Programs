package data;

public class SearchResult {
    private int sequentialCount;
    private int binaryCount;

    public SearchResult(){
        this.sequentialCount = 0;
        this.binaryCount = 0;
    }

    public void addBinary(){
        binaryCount++;
    }

    public void addSequential(){
        sequentialCount++;
    }

    public int getBinaryCount(){
        return binaryCount;
    }

    public int getSequentialCount(){
        return sequentialCount;
    }
}
