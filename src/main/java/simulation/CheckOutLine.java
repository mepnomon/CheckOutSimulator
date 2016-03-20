package simulation;

import simulation.Shopper;
import java.sql.Time;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 19-Mar-2016
 * 
 * @author eeu436
 */
public class CheckOutLine {
    
    Queue<Shopper> checkoutLine;
    
    public CheckOutLine(){
        
        checkoutLine = new LinkedList<>();
    }
    
    /**
     * Adds consumer to checkout queue.
     * @param consumer
     */
    public void addConsumer(Shopper consumer){
        
        checkoutLine.add(consumer);
    }
    
    /**
     * Retrieves the count of consumers.
     * @return consumer count
     */
    public int getConsumerCount(){
        
        return checkoutLine.size();
    }
    
    /**
     * The item count of the consumer at the head of the queue.
     * @return the item count
     */
    public int getCurrentConsumerItemCount(){
        
        return checkoutLine.peek().getItemCount();
    }
    
    /**
     * Method to process consumer.
     * Takes consumer's time tag and waits.
     */
    public void processConsumer(){
        Time time;
        //get the time allocated and wait until the end of time
        //while time < maxTime, wait for time. or something.
        //checkoutLine.poll();
        
        int delay = checkoutLine.peek().getItemCount();
              
        try {
            Thread.sleep(100*delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(CheckOutLine.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkoutLine.poll();
    }
    
    private void releaseConsumer(){
        
        checkoutLine.poll();
    }
    
    /**
     * Sums all items currently in the queue.
     * @return count of all items in queue.
     */
    public int getCurrentGlobalItemCount(){
        
        int globalItemCount = 0;
        
        for(Shopper s : checkoutLine){
            
            globalItemCount += s.getItemCount();
        }
        
        return globalItemCount;
    }
   
}
