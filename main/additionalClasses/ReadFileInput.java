package additionalClasses;

import java.io.InputStream;

public class ReadFileInput {
    
    private InputStream input;
    
    public ReadFileInput(String file) {
        input = this.getClass().getClassLoader().getResourceAsStream(file);
    }
    
    public InputStream getInputStream() {
        return input;
    }
}