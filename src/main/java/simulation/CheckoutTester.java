package simulation;



import java.util.ArrayList;

/**
 * Date: 19-Mar-2016
 * 
 * @author eeu436
 */
public class CheckoutTester {
   
    private static ArrayList<Customer> consumers = new ArrayList();
    private static CheckOutLine line = new CheckOutLine();
    private static Customer consumer;
    
    public static void main(String[] args){
              
        //creates 10 Shoppers.
        for(int i = 0; i < 50; i++){ //O(1)
            
            consumer = new Customer();
            
            System.out.println("Generating shopper with " + 
                    consumer.getItemCount() + " items");
            //System.out.println("Adding to queue...");
            //line.addConsumer(consumer);
            System.out.println("Ready to choose a check-out line");
            consumers.add(consumer);
            //line.add(consumer);
        }
        
//        System.out.println("No. of consumers in queue: " + 
//                line.getConsumerCount());
//        
//        System.out.println("No. of items currently in queue: " + 
//                line.getCurrentGlobalItemCount());
//        
//        System.out.println("Items of consumer at front: " + 
//                line.getCurrentConsumerItemCount() + " items");
        
        


        //processing...
//        while(line.getConsumerCount() != 0){
//            
//            System.out.println("Serving customer with " + line.getCurrentConsumerItemCount() + " items");
//            line.processConsumer();
//        }
    }
}
