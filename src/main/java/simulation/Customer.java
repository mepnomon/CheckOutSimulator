package simulation;

import java.util.Random;

/**
 * Date: 19-Mar-2016
 * 
 * @author eeu436
 */
public class Customer {
    
    private int items;
    private final int MAX_ITEMS = 10;
    private final int MIN_ITEMS = 1;
    private final Random GENERATOR;
    
    /**
     * Constructor for customer.
     * Attaches random item count to customer.
     * A customer can hold up to 10 items (inclusive).
     */
    public Customer(){
        
        GENERATOR = new Random();
        items = GENERATOR.nextInt(MAX_ITEMS) + MIN_ITEMS;
    }
    
    /**
     * Item count determines processing time
     * in checkout line.
     * @return item count.
     */
    public int getItemCount(){  
        
        return items;
    }
    
    /**
     * Deletes 1 item, when called.
     */
    public void removeItem(){
        
        items--;
    }
}