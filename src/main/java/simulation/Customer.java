package simulation;

import java.util.Random;

/**
 * Date: 19-Mar-2016
 * 
 * @author eeu436
 */
public class Customer {
    
    private final int ITEMS;
    private final int MAX_ITEMS = 50;
    private final int MIN_ITEMS = 1;
    private final Random GENERATOR;
    
    /**
     * Constructor for shopper.
     * Attaches random item count to shopper.
     * A shopper can hold up to 50 items (inclusive).
     */
    public Customer(){
        
        GENERATOR = new Random();
        ITEMS = GENERATOR.nextInt(MAX_ITEMS) + MIN_ITEMS;
    }
    
    /**
     * Item count determines processing time
     * in checkout line.
     * @return item count.
     */
    public int getItemCount(){  
        
        return ITEMS;
    }
    
    public void removeItem() throws InterruptedException{
        
        for(int i = ITEMS; i >= 0; i--){
            Thread.sleep(100);
        }
    }
}