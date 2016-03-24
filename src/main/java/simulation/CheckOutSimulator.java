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
    
    Shopper shoppers;
    ArrayList <Shopper> consumers;
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
            Shopper consumer = new Shopper();
            System.out.print(i + " ");
            System.out.println(consumer.getItemCount());
            consumers.add(consumer);
            chooseLine(consumer);
        }
    }
    
    /**
     * This bit will be O(n log n)
     * Unsorted array.
     * @param s
     */
    public void chooseLine(Shopper s){
        
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
    
    private class ProcessCheckOut extends Thread{

       CheckOutLine line;
       
       private ProcessCheckOut(CheckOutLine line){
           
           this.line = line;
           line.processConsumer();
       }
    }
}
