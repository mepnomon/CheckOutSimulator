package simulation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 19-Mar-2016
 * 
 * @author eeu436
 */
public class CheckOutLine{
    
    Queue<Customer> line;
    
    public CheckOutLine(){
        
        line = new LinkedList<>();
//        Runnable r = new CheckoutClerk(line);
//        Thread t = new Thread(r);
//        t.start();
//        
    }
    
    /**
     * Adds consumer to checkout queue.
     * @param consumer
     */
    public void addConsumer(Customer consumer){
        
        line.add(consumer);
    }
    
    /**
     * Retrieves the count of consumers.
     * @return consumer count
     */
    public int getCustomerCount(){
        
        return line.size();
    }
    
    /**
     * The item count of the consumer at the head of the queue.
     * @return the item count
     */
    public int getFrontCustomerItemCount(){
        
        if(line.peek() != null){
            return line.peek().getItemCount();
        } else {
            return 0;
        }
    }
    
    /**
     * Sums all items currently in the queue.
     * @return count of all items in queue.
     */
    public int getCurrentGlobalItemCount(){
        
        int globalItemCount = 0;
        
        for(Customer s : line){
            
            globalItemCount += s.getItemCount();
        }
        
        return globalItemCount;
    }
    
    
    
    /**
     * Processes a customer, until items == 0
     * Then removes customer.
     */
    public void processCustomer(){
        
        if(line.peek() != null){
            
            if(line.peek().getItemCount() > 0){
             
                line.peek().removeItem();
            
            } else {
                
                line.poll();
            } 
        }
    }
}

