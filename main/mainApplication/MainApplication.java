package mainApplication;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import additionalClasses.ReadFileInput;

import actors.Aggregator;
import actors.FileParser;

public class MainApplication {
	
	public static void main(String[] args) {
		//Initialize the system
		ActorSystem mainSystem = ActorSystem.create("WordCountSystem");
		
		//Initialize the file parser
		ActorRef fileParser = mainSystem.actorOf(Props.create(FileParser.class), "FileParser");
		
		//Initialize the Aggregator to count the words
		Aggregator.setAggregator(mainSystem.actorOf(Props.create(Aggregator.class), "Aggregator"));
		
		//Provide the file parser with the file to parse
		fileParser.tell(new ReadFileInput("input.txt"), fileParser);
	}
}

