package additionalClasses;

/*
 * Word Count Custom Class
 * 
 * Created this custom class to make it easier to keep track of words. Allows for
 * upgraded features in the future if necessary. Currently it just keeps track
 * of all words in the file, but has the potential to store count of specific words
 * instead of all words.
 * 
 */
public class WordCount {
    
    private String Word;
    private int Count;
    
    public WordCount(String word, int count) {
        this.Word = word;
        this.Count = count;
    }
    
    /*
     * getWord function
     * Returns the word stored as a String
     */
    public String getWord() {
        return Word;
    }
    /*
     * getCount function
     * Returns the count as an integer
     */
    public int getCount() {
        return Count;
    }
    
}
