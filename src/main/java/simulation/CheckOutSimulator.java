package simulation;

import java.util.ArrayList;

/**
 * Date: 19-Mar-2016
 * 
 * This class allows for the simulation 
 * to be displayed in main.
 * @author eeu436
 */
public class CheckOutSimulator {
    
    //ArrayList <Customer> consumers;
    CheckOutLine[] arr;
    
    /**
     * Constructor for CheckoutSimulator.
     */
    public CheckOutSimulator(){
        
        arr = new CheckOutLine[5];
        //consumers = new ArrayList<>();
        
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
     * Adds desired number of shoppers to queues, with chosen algorithm.
     * @param customerCount the number of customer objects to instantiate.
     * @param choice a boolean that determines which algorithm is selected.
     */
    public void addCustomers(int customerCount, boolean choice){
        
        for(int i = 0; i < customerCount; i++){
            Customer c = new Customer();
            System.out.print("Customer " + i + ": ");
            System.out.println(c.getItemCount() + " items");
            //consumers.add(c);
            
            if(!choice){
                chooseLine_leastItems(c);
                //System.out.println("Least item selected");
            } else {
                chooseLine_leastCustomers(c);
                //System.out.println("Least cust selected");
            }
        }
    }
    
    /**
     * Chooses line with least items from unsorted arrays of queues.
     * O(n), Items retrieval O(n)
     * @param c
     */
    public void chooseLine_leastItems(Customer c){
        
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
        }
        System.out.println("Adding to " + arrayNo + " with " + least + " items");
        CheckOutLine l = arr[arrayNo];
        l.addCustomer(c);
    }
    
    /**
     * Chooses the smallest Queue in an unsorted array of Queues.
     * O(n), Customer retrieval O(1)
     * @param c the customer to add
     */
    public void chooseLine_leastCustomers(Customer c){
        
        int least = 0;
        int i = 0;
        int arrayNo = 0;
        
        for(CheckOutLine l : arr){
            
            if(i == 0){
                least = l.getCustomerCount();
            } else if(i > 0 && least > l.getCustomerCount()){
                
                least = l.getCustomerCount();
                arrayNo = i;
            }
            i++;
        }
        System.out.println("Adding to " + arrayNo + " with " + least + " customer(s)");
        CheckOutLine l = arr[arrayNo];
        l.addCustomer(c);
    }
    
    /**
     * Invokes the processCustomer method for each
     * customer at the front of their respective queue.
     * Removes 1 item per tick.
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
    public int getCurrentLocalItemsPerQueue(int arrNo){
         
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
    
    /**
     * Calls the getCustomerCount() method for the selected array.
     * @param arrNo the number of the array selected
     * @return the number of customers in selected array.
     */
    public int getCustomerCountPerQueue(int arrNo){
        
        return arr[arrNo].getCustomerCount();
    }
    
    /**
     * Traverses each Checkout line in the array.
     * Sums all items per array.
     * @return the sum of all items in all arrays.
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
