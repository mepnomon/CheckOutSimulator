package simulation;



import simulation.*;
import java.util.Timer;

/**
 * Date: 19-Mar-2016
 * 
 * @author eeu436
 */
public class CheckoutTester {
   
    private static Shopper consumer;
    private static CheckOutLine line = new CheckOutLine();
    Timer t = new Timer();
    
    public static void main(String[] args){
              
        //creates 10 Shoppers.
        for(int i = 0; i < 10; i++){ //O(1)
            
            consumer = new Shopper();
            
            System.out.println("Generating shopper with " + 
                    consumer.getItemCount() + " items");
            System.out.println("Adding to queue...");
            line.addConsumer(consumer);
        }
        
        System.out.println("No. of consumers in queue: " + 
                line.getConsumerCount());
        
        System.out.println("No. of items currently in queue: " + 
                line.getCurrentGlobalItemCount());
        
        System.out.println("Items of consumer at front: " + 
                line.getCurrentConsumerItemCount() + " items");
        
        int testCount = line.getConsumerCount();
//        for(int i = 0; i < testCount; i++){
//            
//            line.processConsumer();
//        }
        while(line.getConsumerCount() != 0){
            
            System.out.println("Serving customer with " + line.getCurrentConsumerItemCount() + " items");
            line.processConsumer();
        }
    }
}
