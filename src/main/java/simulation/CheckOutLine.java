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
    }
    
    /**
     * Adds customer to checkout queue.
     * @param c the customer
     */
    public void addCustomer(Customer c){
        
        line.add(c);
    }
    
    /**
     * Retrieves the count of customers.
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
    public int getLocalItemCount(){
        
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

