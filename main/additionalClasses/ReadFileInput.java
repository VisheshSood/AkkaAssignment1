package additionalClasses;

import java.io.InputStream;

/*
 * ReadFileInput Class
 * 
 * Allows the program to read the file that is saved in the resources directory, that 
 * is passed down in the main application.
 */
public class ReadFileInput {
    
    private InputStream inputStream;
    
    /*
     * ReadFileInput function
     * Takes a string of the filename and produces the input stream
     */
    public ReadFileInput(String fileInput) {
    	inputStream = this.getClass().getClassLoader().getResourceAsStream(fileInput);
    }
    
    /*
     * getInputStream function
     * Returns the InputStream of type InputStream.
     */
    public InputStream getInputStream() {
        return inputStream;
    }
}