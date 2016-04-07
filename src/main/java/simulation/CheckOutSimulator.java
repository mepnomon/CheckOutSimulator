package simulation;

import java.util.ArrayList;
import javax.swing.JProgressBar;

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
     * Reads back created arrays
     */
    public void verifyArray(){
        
        for(CheckOutLine l : arr){
            
            System.out.println(l);
        }
    }
    
    /**
     * Adds desired number of shoppers
     * @param shopperCount
     */
    public void addShoppers(int shopperCount){
        
        for(int i = 0; i < shopperCount; i++){
            Customer consumer = new Customer();
            System.out.print(i + " ");
            System.out.println(consumer.getItemCount());
            consumers.add(consumer);
            chooseLine(consumer);
        }
    }
    
    /**
     * This bit will be O(n)
     * Unsorted array.
     * @param s
     */
    public void chooseLine(Customer s){
        
        int least = 0;
        int i = 0;
        int arrayNo = 0;
        
        for(CheckOutLine l : arr){
        
            if(i == 0){
                least = l.getCurrentGlobalItemCount();
                
            }else if(i > 0 && least > l.getCurrentGlobalItemCount()){
                least = l.getCurrentGlobalItemCount(); 
                arrayNo = i;
            }
            i++;
            System.out.println(l.getCurrentGlobalItemCount());
        }
        System.out.println("Queue with least items: " + least);
        System.out.println("Adding to check out no." + arrayNo);
        CheckOutLine l = arr[arrayNo];
        l.addConsumer(s);
    }
    
    /**
     * 
     * @return 
     */
    public CheckOutLine[] getArray(){
        
        return arr;
    }
    
    /**
     * 
     */
    public void processCustomerPerArr(){
        
        for(CheckOutLine c : arr){
            
            try{
                c.processCustomer();
                System.out.println(c.getFrontCustomerItemCount());
            }catch(NullPointerException e){
                System.out.println(e + " caught");
            }
        }
    }
        
    /**
     * Retrieves the global item count for each checkout line individually.
     * @return an array containing the global item counts.
     */
    public int getCurrentGlobalItemsPerQueue(int arrNo){
         
        return arr[arrNo].getCurrentGlobalItemCount();
    }
    
    public int getCurrentQueueFrontItems(int arrNo){

        return arr[arrNo].getFrontCustomerItemCount();
    }
    
    public int getCustomerCountPerQueue(int arrNo){
        
        return arr[arrNo].getCustomerCount();
    }
    
    /**
     * 
     * @return 
     */
    public int getGlobalCustomerItemCount(){
        
        int items = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            items += arr[i].getCurrentGlobalItemCount();
        }
        return items;
    }
    
   /**
    * 
    * @return 
    */
    public int getGlobalCustomerCount(){
        int count = 0;
        for(CheckOutLine l : arr){
            
            count += l.getCustomerCount();
        }
        return count;
    }
}
