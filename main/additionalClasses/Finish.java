package additionalClasses;

/*
 * Finish class
 * 
 * Allows the program to have certain types of finish, as well as keep
 * count of the type.
 * 
 */
public class Finish {
    
	/*
	 * Create two types of Finish messages
	 */
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
    
    /*
     * getFinishType function
     * Returns a FinishType
     */
    public FinishType getFinishType() {
        return finishType;
    }
    
    /*
     * getCount function
     * Returns the count for the finish type.
     */
    public int getCount() {
        return count;
    }
    
}