package simulation;

import java.util.ArrayList;

/**
 * Date: 19-Mar-2016
 * 
 * This class allows for the simulation 
 * to be displayed in main.
 * 
 * Press s for new shopper
 * @author eeu436
 */
public class CheckOutSimulator {
    
    Customer shoppers;
    ArrayList <Customer> consumers;
    CheckOutLine[] arr;
    
    /**
     * Constructor for CheckoutSimulator.
     */
    public CheckOutSimulator(){
        
        arr = new CheckOutLine[5];
        consumers = new ArrayList<>();
        
    }
    
    /**
     * Adds 5 checkout lines to an array
     */
    public void addCheckOutLines(){
        
        for(int i = 0; i < arr.length; i++){
            
            CheckOutLine line = new CheckOutLine();
            arr[i] = line;
        }
    }
    
    /**
     * Adds desired number of shoppers
     * @param customerCount
     */
    public void addCustomers(int customerCount){
        
        for(int i = 0; i < customerCount; i++){
            Customer c = new Customer();
            System.out.print(i + " ");
            System.out.println(c.getItemCount());
            consumers.add(c);
            chooseLine(c);
        }
    }
    
    /**
     * This bit will be O(n)
     * Unsorted array.
     * @param c
     */
    public void chooseLine(Customer c){
        
        int least = 0;
        int i = 0;
        int arrayNo = 0;
        
        for(CheckOutLine l : arr){
        
            if(i == 0){
                least = l.getLocalItemCount();
                
            }else if(i > 0 && least > l.getLocalItemCount()){
                least = l.getLocalItemCount(); 
                arrayNo = i;
            }
            i++;
            System.out.println(l.getLocalItemCount());
        }
        System.out.println("Queue with least items: " + least);
        System.out.println("Adding to check out no." + arrayNo);
        CheckOutLine l = arr[arrayNo];
        l.addCustomer(c);
    }
    
    /**
     * 
     */
    public void processCustomerPerArr(){
        
        for(CheckOutLine l : arr){
            
            try{
                l.processCustomer();
                //System.out.println(c.getFrontCustomerItemCount());
            }catch(NullPointerException e){
                System.out.println(e + " caught");
            }
        }
    }
        
    /**
     * Retrieves the global item count for each checkout line individually.
     * @return the item count of each checkout line.
     */
    public int getCurrentGlobalItemsPerQueue(int arrNo){
         
        return arr[arrNo].getLocalItemCount();
    }
    
    /**
     * Retrieves the current item count for a customer at the front of the queue.
     * @param arrNo
     * @return item count for the front customer.
     */
    public int getCurrentQueueFrontItems(int arrNo){

        return arr[arrNo].getFrontCustomerItemCount();
    }
    
    public int getCustomerCountPerQueue(int arrNo){
        
        return arr[arrNo].getCustomerCount();
    }
    
    /**
     * Traverses each Checkout line in the array.
     * Retrieves 
     * @return 
     */
    public int getGlobalCustomerItemCount(){
        
        int items = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            items += arr[i].getLocalItemCount();
        }
        return items;
    }
    
   /**
    * Queries each array position for its length.
    * @return a summation of each resident customer count.
    */
    public int getGlobalCustomerCount(){
        int count = 0;
        for(CheckOutLine l : arr){
            
            count += l.getCustomerCount();
        }
        return count;
    }
}
