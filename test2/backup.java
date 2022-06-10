import java.lang.reflect.Constructor;
import java.util.Scanner;

import javax.swing.event.SwingPropertyChangeSupport;


public class Main {
    double CBM; 
    

    public double calcCBM(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter dimension 1 of master box in CM"); 
        double dimension1 = input.nextDouble();
        System.out.println("Enter dimension 2 of master box in CM");
        double dimension2 = input.nextDouble();
        System.out.println("Enter dimension 3 of master box in CM");
        double dimension3 = input.nextDouble();
      
        
        double CBM = (0.01*dimension1)*(0.01*dimension2)*(dimension3*0.01);
    
        return CBM;
        
    }

    public void calcCTN(){
        Scanner input = new Scanner(System.in);
        //could try and call CBM class
        System.out.println("Enter dimension 1 of master box in CM"); 
        double dimension1 = input.nextDouble();
        System.out.println("Enter dimension 2 of master box in CM");
        double dimension2 = input.nextDouble();
        System.out.println("Enter dimension 3 of master box in CM");
        double dimension3 = input.nextDouble();
        System.out.println("Enter number of pieces to ship");
        double totalPieces = input.nextDouble();
        System.out.println("Enter pieces per master box");
        double perMaster = input.nextDouble(); 


        double CBM = (0.01*dimension1)*(0.01*dimension2)*(dimension3*0.01);
        double CTN40HQ = (Math.floor(63 / CBM))*perMaster;
        double CTN40GP = (Math.floor(57 / CBM))*perMaster;
        double CTN20= (Math.floor(27 / CBM))*perMaster;

        System.out.println("You would fit around"+CTN40HQ+" pieces in a 40'HQ container.");
        System.out.println("You would fit around"+CTN40GP+" pieces in a 40'GP container.");
        System.out.println("You would fit around"+CTN20+" pieces in a 20' container.");
        //should fix the infinite decimal for totalMasterCBM
        double totalMasterCBM = (totalPieces/perMaster)*CBM;

        if(totalMasterCBM<=15){
            System.out.println("This quantity of CBMs ("+totalMasterCBM+") is less than or equal to 15 so it qualifies for LCL");
        } 
        
    } 
    /* 
    public void calcFreightCost(){
        Main filler = new Main();
        filler.calcCBM();
        System.out.println("lndakdf"+CBM);
    } */

    public void calcFreightCost(){
        Scanner input = new Scanner(System.in);
        //could try and call CBM class
        System.out.println("Enter dimension 1 of master box in CM"); 
        double dimension1 = input.nextDouble();
        System.out.println("Enter dimension 2 of master box in CM");
        double dimension2 = input.nextDouble();
        System.out.println("Enter dimension 3 of master box in CM");
        double dimension3 = input.nextDouble();
        System.out.println("Enter number of pieces to ship");
        double totalPieces = input.nextDouble();
        System.out.println("Enter pieces per master box");
        double perMaster = input.nextDouble(); 


        double CBM = (0.01*dimension1)*(0.01*dimension2)*(dimension3*0.01);
        double CTN40HQ = (Math.floor(63 / CBM))*perMaster;
        double CTN40GP = (Math.floor(57 / CBM))*perMaster;
        double CTN20= (Math.floor(27 / CBM))*perMaster;

        System.out.println("You would fit around"+CTN40HQ+" pieces in a 40'HQ container.");
        System.out.println("You would fit around"+CTN40GP+" pieces in a 40'GP container.");
        System.out.println("You would fit around"+CTN20+" pieces in a 20' container.");
        //should fix the infinite decimal for totalMasterCBM
        double totalMasterCBM = (totalPieces/perMaster)*CBM;

        if(totalMasterCBM<=15){
            System.out.println("This quantity of CBMs ("+totalMasterCBM+") is less than or equal to 15 so it qualifies for LCL");
        }  
    }
   
   
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Main user = new Main(); 
       
        System.out.println("What tool do you want to use?");
        System.out.println("Enter 1 in the Terminal for CBM calculator.");
        System.out.println("Enter 2 in the Terminal for peices/container calculator.");
        System.out.println("Enter 3 in the Terminal for freight cost calculator");
        double userSelection = input.nextDouble();

        if (userSelection==1.0) {
            user.calcCBM();
        }
        else if (userSelection==2){
            user.calcCTN();
        }
        else if (userSelection==3){
            user.calcFreightCost();
        }

        else {
            System.out.println("Invalid entry");
        }


       

    }
}
