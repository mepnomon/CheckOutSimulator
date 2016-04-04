package simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 19-Mar-2016
 * 
 * @author eeu436
 */
public class CheckOutLine{
    
    Queue<Shopper> line;
    
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
    public void addConsumer(Shopper consumer){
        
        line.add(consumer);
    }
    
    /**
     * Retrieves the count of consumers.
     * @return consumer count
     */
    public int getConsumerCount(){
        
        return line.size();
    }
    
    /**
     * The item count of the consumer at the head of the queue.
     * @return the item count
     */
    public int getCurrentConsumerItemCount(){
        
        return line.peek().getItemCount();
    }
    
    /**
     * Method to process consumer.
     * Takes consumer's time tag and waits.
     */
    public void processConsumer(Shopper s){
        
        int delay = line.peek().getItemCount();
              
        try {
            Thread.sleep(100*delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(CheckOutLine.class.getName()).log(Level.SEVERE, null, ex);
        }
        line.poll();
    }
    
    /**
     * Sums all items currently in the queue.
     * @return count of all items in queue.
     */
    public int getCurrentGlobalItemCount(){
        
        int globalItemCount = 0;
        
        for(Shopper s : line){
            
            globalItemCount += s.getItemCount();
        }
        
        return globalItemCount;
    }
    
    public boolean isFrontOccupied(){
        
        if(line.peek() == null){
            return false;
        } else {
            return true;
        }
    }
    
    public Shopper getFront(){
        
        Shopper s;
        s = line.peek();
        return s;
    }
     
    public void removeFront(){
        
        line.poll();
    }
} 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    private void pauseThread(Shopper s){
//        
//        try {
//            Thread.sleep(s.getItemCount()*100);
//            System.out.println("Thread resumed");
//        } catch (InterruptedException ex) {
//            Logger.getLogger(CheckOutLine.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

//    @Override
//    public void run() {
//        System.out.println("Thread started");
//        while(true){
//            
//            if(isFrontOccupied()){
//                Shopper s = getFront();
//                pauseThread(s);
//            } else {
//            //do nothing
//            } 
//        }
//    }

