package simulation;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Checkout clerk is an experiment to resolve the threading errors
 * previously encountered. Checkout Clerk will be started as a thread
 * at the invocation of checkout line. It will take the item count 
 * of line.peek() and use a timer to return a boolean when the time has cooled down.
 * After the cool-down the object at line.peek() will be calling line.poll()
 * 
 * 
 * The clerk may have ot be moved to the tester class...
 * yes i believe it does, instantiate a line and bam
 * @author Mepnomon
 */
public class CheckoutClerk implements Runnable {
    
    private int itemCount;
    Timer timer;
    CheckOutLine line;
    Shopper s;
    /**
     * Constructor for experimental Checkout Clerk.
     * @param line
     * @param queue
     */
    public CheckoutClerk(CheckOutLine line){
        
        //line = (CheckOutLine)queue; //typecasting isn't working
        //this.itemCount = itemCount;
        this.line = line;
        timer = new Timer();
        
    }
    
    private void processCustomer(){
        
        while(true){
            
            if(line.isFrontOccupied() == true){
                
                s = line.getFront();
                s.getItemCount();
                
                try {
                    Thread.sleep(s.getItemCount() * 100); // do not thread sleep, just countdown
                } catch (InterruptedException ex) {
                    Logger.getLogger(CheckoutClerk.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("shopper processed");
                line.removeFront();
            }   
        }  
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        processCustomer();
    }
    
}
