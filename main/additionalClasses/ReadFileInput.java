package additionalClasses;

import java.io.InputStream;

public class ReadFileInput {
    
    private InputStream inputStream;
    
    public ReadFileInput(String fileInput) {
    	inputStream = this.getClass().getClassLoader().getResourceAsStream(fileInput);
    }
    
    public InputStream getInputStream() {
        return inputStream;
    }
}