import java.util.Scanner;

public class Main {
    

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
        double totalMasterCBM = (totalPieces/perMaster)*CBM;

        double CTN40HQ = (Math.floor(63 / CBM))*perMaster;
        double CTN40GP = (Math.floor(57 / CBM))*perMaster;
        double CTN20= (Math.floor(27 / CBM))*perMaster;
        System.out.println("The total CBM for your shipment is "+totalMasterCBM);
        System.out.println("You would fit around "+CTN40HQ+" pieces in a 40'HQ container.");
        System.out.println("You would fit around "+CTN40GP+" pieces in a 40'GP container.");
        System.out.println("You would fit around "+CTN20+" pieces in a 20'container.");
        //should fix the infinite decimal for totalMasterCBM
        

        if(totalMasterCBM<=15){
            System.out.println("This quantity of CBMs ("+totalMasterCBM+") is less than or equal to 15 so it qualifies for LCL");
        } 
        
    } 

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
      
        //should fix the infinite decimal for totalMasterCBM
        double totalMasterCBM = (totalPieces/perMaster)*CBM;
        //these options are not all the options, can combine 20' and 40' and LCL
        double LCL = totalMasterCBM*625;
        double ctn20 = Math.ceil(totalMasterCBM/27)*13800;
        double ctn20AndLCL = Math.floor(totalMasterCBM/27)*13800+(totalMasterCBM-(Math.floor(totalMasterCBM/27)*27))*625;
        double GP = Math.ceil(totalMasterCBM/57)*16875;
        double GPAndLCL = Math.floor(totalMasterCBM/57)*16875+(totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))*625;
        double HQ = Math.ceil(totalMasterCBM/63)*17125;
        double HQAndLCL = Math.floor(totalMasterCBM/63)*17125+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63))*625;
        
        double freightOptions[] = {LCL, ctn20, ctn20AndLCL, GP, GPAndLCL, HQ, HQAndLCL};

        double min = freightOptions[0];
	    int indexOfCheapest=0;

	       for(int i = 0; i < freightOptions.length; i++)
	       {
	            if(min > freightOptions[i])
	            {
	                min = freightOptions[i];
	                indexOfCheapest=i;
	            }
	        }
        
        switch(indexOfCheapest){
            case 0:
                System.out.println("The most optimal freight solution is to ship LCL for a cost of $"+LCL);
                break;
            case 1:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/27)+" 20' containers for a cost of $"+ctn20);
                break;
            case 2:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/27)+" 20' containers and the rest with LCL for a cost of $"+ctn20AndLCL);
                break;
            case 3:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/57)+" 40'GP containers for a cost of $"+GP);
                break;
            case 4:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP containers and the rest with LCL for a cost of $"+GPAndLCL);
                break;
            case 5:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/63)+" 40'HQ contianers for a cost of $"+HQ);
                break;
            case 6:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with LCL for a cost of $"+HQAndLCL);
                break;
            
        }

    }
    
    public void general(){
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
      
        //should fix the infinite decimal for totalMasterCBM
        double totalMasterCBM = (totalPieces/perMaster)*CBM;

        double CTN40HQ = (Math.floor(63 / CBM))*perMaster;
        double CTN40GP = (Math.floor(57 / CBM))*perMaster;
        double CTN20= (Math.floor(27 / CBM))*perMaster;
        System.out.println("You would fit around "+CTN40HQ+" pieces in a 40'HQ container.");
        System.out.println("You would fit around "+CTN40GP+" pieces in a 40'GP container.");
        System.out.println("You would fit around "+CTN20+" pieces in a 20'container.");
        
        double num20 = Math.ceil(totalMasterCBM/27)*13800;
        double num20LCL = Math.floor(totalMasterCBM/27)*13800;
        double ctn20LCLCost = (totalMasterCBM-(Math.floor(totalMasterCBM/27)*27))*625;
        double GPCost = Math.ceil(totalMasterCBM/57)*16875;
        double GPAndCost = Math.floor(totalMasterCBM/57)*16875;
        double GPAndLCLCost = (totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))*625;
        double GPAnd20Cost = Math.ceil((totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))/27)*13800;
        

        //need to rewrite the math
        double LCL = totalMasterCBM*625;
        double ctn20 = Math.ceil(totalMasterCBM/27)*13800;
        double ctn20AndLCL = Math.floor(totalMasterCBM/27)*13800+(totalMasterCBM-(Math.floor(totalMasterCBM/27)*27))*625;
        double GP = Math.ceil(totalMasterCBM/57)*16875;
        double GPAndLCL = Math.floor(totalMasterCBM/57)*16875+(totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))*625;
        double GPAnd20 = Math.floor(totalMasterCBM/57)*16875+Math.ceil((totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))/27)*13800;
        double GPAnd20AndLCL = Math.floor(totalMasterCBM/57)*16875+Math.floor((totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))/27)*13800+(totalMasterCBM-(Math.floor(totalMasterCBM/57)*16875+Math.floor((totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))/27)))*675;
        double HQ = Math.ceil(totalMasterCBM/63)*17125;
        double HQAndLCL = Math.floor(totalMasterCBM/63)*17125+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63))*625;
        double HQAnd20 = Math.floor(totalMasterCBM/63)*17125+Math.ceil((totalMasterCBM-(Math.floor(totalMasterCBM/63)*63))/27)*13800;
        double HQAnd20AndLCL = Math.floor(totalMasterCBM/63)*17125+Math.floor((totalMasterCBM-(Math.floor(totalMasterCBM/63)*63))/27)*13800+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*17125+Math.floor((totalMasterCBM-(Math.floor(totalMasterCBM/63)*63))/27)))*675;
        double HQAndGP = Math.floor(totalMasterCBM/63)*17125+16875;
        double HQAndGPAndLCL = Math.floor(totalMasterCBM/63)*17125+16875+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63+57))*625;
        double HQAndGPAnd20 = Math.floor(totalMasterCBM/63)*17125+16875+13800;
        double HQAndGPAnd20AndLCL= Math.floor(totalMasterCBM/63)*17125+16875+13800+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63+57+27))*625;

    
        
        double freightOptions[] = {LCL, ctn20, ctn20AndLCL, GP, GPAndLCL, GPAnd20, GPAnd20AndLCL, HQ, HQAndLCL, HQAnd20, HQAnd20AndLCL, HQAndGP, HQAndGPAndLCL, HQAndGPAnd20, HQAndGPAnd20AndLCL};

        double min = freightOptions[0];
	    int indexOfCheapest=0;

	       for(int i = 0; i < freightOptions.length; i++)
	       {
	            if(min > freightOptions[i])
	            {
	                min = freightOptions[i];
	                indexOfCheapest=i;
	            }
	        }
        
        switch(indexOfCheapest){
            case 0:
                System.out.println("The most optimal freight solution is to ship LCL for a cost of $"+LCL);
                System.out.println("Cost/piece: $"+LCL/totalPieces);
                break;
            case 1:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/27)+" 20' containers for a cost of $"+ctn20);
                System.out.println("Cost/piece: $"+ctn20/totalPieces);
                break;
            case 2:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/27)+" 20' containers and the rest with LCL for a cost of $"+ctn20AndLCL);
                System.out.println("Cost/piece: $"+ctn20AndLCL/totalPieces);
                break;
            case 3:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/57)+" 40'GP containers for a cost of $"+GP);
                System.out.println("Cost/piece: $"+GP/totalPieces);
                break;
            case 4:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP containers and the rest with LCL for a cost of $"+GPAndLCL);
                System.out.println("Cost/piece: $"+GPAndLCL/totalPieces);
                break;
            case 5:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP containers and the rest with one 20' for a cost of $"+GPAnd20);
                System.out.println("Cost/piece: $"+GPAnd20/totalPieces);
                break;
            case 6:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP containers and the rest with one 20' and LCL for a cost of $"+GPAnd20AndLCL);
                System.out.println("Cost/piece: $"+GPAnd20AndLCL/totalPieces);
                break;
            case 7:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/63)+" 40'HQ contianers for a cost of $"+HQ);
                System.out.println("Cost/piece: $"+HQ/totalPieces);
                break;
            case 8:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with LCL for a cost of $"+HQAndLCL);
                System.out.println("Cost/piece: $"+HQAndLCL/totalPieces);
                break;
            case 9:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 20' container for a cost of $"+HQAnd20);
                System.out.println("Cost/piece: $"+HQAnd20/totalPieces);
                break;
            case 10:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 20' and LCL for a cost of $"+HQAnd20AndLCL);
                System.out.println("Cost/piece: $"+HQAnd20AndLCL/totalPieces);
                break;
            case 11:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 40'GP container for a cost of $"+HQAndGP);
                System.out.println("Cost/piece: $"+HQAndGP/totalPieces);
                break;
            case 12:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 40'GP and LCL for a cost of $"+HQAndGPAndLCL);
                System.out.println("Cost/piece: $"+HQAndGPAndLCL/totalPieces);
                break;
            case 13:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 40'GP and one 20' for a cost of $"+HQAndGPAnd20);
                System.out.println("Cost/piece: $"+HQAndGPAnd20/totalPieces);
                break;
            case 14:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 40'GP and one 20' and LCL for a cost of $"+HQAndGPAnd20AndLCL);
                System.out.println("Cost/piece: $"+HQAndGPAnd20AndLCL/totalPieces);
                break;
            }
    }
   
   
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Main user = new Main(); 
       
        System.out.println("What tool do you want to use?");
        System.out.println("Enter 1 in the Terminal for CBM calculator.");
        System.out.println("Enter 2 in the Terminal for peices/container calculator.");
        System.out.println("Enter 3 in the Terminal for freight cost calculator");
        System.out.println("Enter 4 in the Terminal for complete freight information calculator (includes all calculators)[RECOMMENDED]");
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
        else if (userSelection==4){
            user.general();
        }
        else {
            System.out.println("Invalid entry");
        }
    }
}
