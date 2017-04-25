package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import additionalClasses.WordCount;
import additionalClasses.Finish;

public class Aggregator extends UntypedActor  {
    
    private static ActorRef AGGREGATOR;
    private static int ExpectedLineCount = -1;
    private static int CurrentLineCount = 0;
    private static int WordCountFinal = 0;
       
    
    private Aggregator() {}
    
    public static void setAggregator(ActorRef ref) {
        if (AGGREGATOR == null) {
            AGGREGATOR = ref;
        }
    }
    
    public static ActorRef getAggregator() {
        if (AGGREGATOR == null) {
            throw new IllegalStateException();
        }
        return AGGREGATOR;
    }
    
    @Override
    public void onReceive(Object object) throws Exception {
        if (object instanceof WordCount) {
            WordCount wordCount = (WordCount) object;
            WordCountFinal += wordCount.getCount();
        } else if (object instanceof Finish) {
            Finish finish = (Finish) object;
            finishMessage(finish);
        } else {
            unhandled(object);
        }
    }
    
   
    private void finishMessage(Finish message) {
        switch (message.getFinishType()) {
            case FILE:
            	ExpectedLineCount = message.getCount();
            	break;
            case LINE:
            	CurrentLineCount++;
            	break;
        }
        
        if (ExpectedLineCount >= 0 && ExpectedLineCount == CurrentLineCount) {
            finalMessage();
        }
    }
    
    private void finalMessage() {
        System.out.println("Total Word Count: " + WordCountFinal);
        System.out.println("Total Line Count: " + CurrentLineCount);
        System.exit(0);
    } 
}
