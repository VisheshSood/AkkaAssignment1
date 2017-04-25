package actors;

import actors.Aggregator;
import additionalClasses.Finish;
import additionalClasses.WordCount;
import akka.actor.UntypedActor;
import additionalClasses.LineScanner;

public class FileScanner extends UntypedActor {
	
	private int LineCount = 0;
	
	@Override
	  public void onReceive(Object object) throws Exception {
	    if (object instanceof LineScanner) {
	    	LineScanner processLine = (LineScanner) object;
	    	System.out.println("FileScanner. Line: " + LineCount);
	    	LineCount++;
	    	processLine(processLine.getLine());
	    }
	  }

	  private void processLine(String line) {
	    String[] wordsInLine = splitLineToWords(line);
	    System.out.println(wordsInLine.length);
	    WordCount wordCount = new WordCount("Word Count", wordsInLine.length);
	    Aggregator.getAggregator().tell(wordCount, self());
	    Aggregator.getAggregator().tell(new Finish(Finish.FinishType.LINE, wordsInLine.length), self());
	  }

	 

	  private String[] splitLineToWords(String line) {
	    return line.split("\\s+");
	  }
	}