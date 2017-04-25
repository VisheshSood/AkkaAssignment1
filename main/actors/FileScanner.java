package actors;

import actors.Aggregator;
import additionalClasses.Finish;
import additionalClasses.WordCount;
import akka.actor.UntypedActor;
import additionalClasses.LineScanner;

public class FileScanner extends UntypedActor {
        
    @Override
    public void onReceive(Object object) throws Exception {
        if (object instanceof LineScanner) {
            LineScanner processLine = (LineScanner) object;
            processLine(processLine.getLine());
        }
    }
    
    /*
     * processLine function
     * Accepts a String which would be the line and processes it by splitting it by spaces
     * and then keeping track of the count.
     */
    private void processLine(String line) {
        //Aggregator actor split words in the lines by the space “ “ character based on the “line” event
    	String[] wordsInLine = line.split("\\s+"); // split line by spaces
        //System.out.println(wordsInLine.length);
        WordCount wordCount = new WordCount("Word Count", wordsInLine.length);
        //Aggregator actor counts the number of words in a file
        Aggregator.getAggregator().tell(wordCount, self());
        // Let aggregator know that the line is complete by passing a finish message
        Aggregator.getAggregator().tell(new Finish(Finish.FinishType.LINE, wordsInLine.length), self());
    }
    
}