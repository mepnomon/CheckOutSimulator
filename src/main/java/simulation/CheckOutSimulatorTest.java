package simulation;

import java.util.Scanner;

/**
 *
 * @author eeu436
 */
public class CheckOutSimulatorTest {
    
    public static void main(String[] args){
        
        Customer s = new Customer();
        Scanner sc = new Scanner(System.in);
        CheckOutSimulator simulation = new CheckOutSimulator();
        simulation.addCheckOutLines();
        simulation.verifyArray();
        System.out.print("Enter number of shoppers: ");
        int shopperCount = sc.nextInt();
        simulation.addShoppers(shopperCount);
    } 
}
