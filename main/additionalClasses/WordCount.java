package additionalClasses;
// Custom class that keeps track of the words in the file. 
public class WordCount {
    
    private String Word;
    private int Count;
    
    public WordCount(String word, int count) {
        this.Word = word;
        this.Count = count;
    }
    
    public String getWord() {
        return Word;
    }
    
    public int getCount() {
        return Count;
    }
   
}
