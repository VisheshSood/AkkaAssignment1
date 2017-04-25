package additionalClasses;

/*
 * LineScanner Class
 * 
 * Allows the program to identify a line and scan it.
 */
public class LineScanner {
    
    private String line;
    
    /*
     * Initializes the line as a string
     */
    public LineScanner(String line) {
        this.line = line;
    }
    
    /*
     * getLine function
     * Returns a String of the line
     */
    public String getLine() {
        return line;
    }
}

