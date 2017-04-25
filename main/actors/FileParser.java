package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.ActorRefRoutee;
import akka.routing.Routee;
import akka.routing.Router;
import akka.routing.SmallestMailboxRoutingLogic;
import additionalClasses.Finish;
import additionalClasses.LineScanner;
import additionalClasses.ReadFileInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileParser extends UntypedActor {
    
    private Router router = customRouter();
    
    private Router customRouter() {
        ArrayList<Routee> listOfRoutees = new ArrayList<Routee>();
        final Props props = Props.create(FileScanner.class);
        for (int i = 0; i < 25; i++) {
            ActorRef ref = context().actorOf(props);
            context().watch(ref);
            listOfRoutees.add(new ActorRefRoutee(ref));
        }
        return new Router(new SmallestMailboxRoutingLogic(), listOfRoutees);
    }
    
    @Override
    public void onReceive(Object object) throws Exception {
        if (object instanceof ReadFileInput) {
            ReadFileInput readFile = (ReadFileInput) object;
            System.out.println("Currently Parsing... Please wait ");
            parseFile(readFile.getInputStream());
        }
    }
    
    /*
     * parseFile function
     * Accepts an InputStream and basde on the input parses the file by calling the right
     * actor based on the progress
     */
    private void parseFile(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int lineCount = 0;
        String line = bufferedReader.readLine();
        
        while (line != null) {
        	lineCount++; // keeps track of the line
            router.route(new LineScanner(line), self());
            line = bufferedReader.readLine();
        }
        
        // Create the finish message and send it
        Props props = Props.create(Aggregator.class);
        ActorRef aggregator = context().actorOf(props);
        aggregator.tell(new Finish(Finish.FinishType.FILE, lineCount), self());   
    }
   
}
