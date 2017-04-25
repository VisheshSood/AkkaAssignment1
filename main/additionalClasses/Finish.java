package additionalClasses;

public class Finish {
    
    public enum FinishType {
        FILE,
        LINE
    }
    
    private FinishType finishType;
    private int count;
    
    public Finish(FinishType finishType, int count) {
        
        this.finishType = finishType;
        this.count = count;
    }
    
    public FinishType getFinishType() {
        return finishType;
    }
    
    public int getCount() {
        return count;
    }
    
}