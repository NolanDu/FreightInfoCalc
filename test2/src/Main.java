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
        totalMasterCBM = (double)Math.round(totalMasterCBM * 1000)/1000;


        double CTN40HQ = (Math.floor(63 / CBM))*perMaster;
        double CTN40GP = (Math.floor(57 / CBM))*perMaster;
        double CTN20= (Math.floor(27 / CBM))*perMaster;
        System.out.println("The total CBM for your shipment is "+totalMasterCBM);
        System.out.println("You would fit around "+CTN40HQ+" pieces in a 40'HQ container.");
        System.out.println("You would fit around "+CTN40GP+" pieces in a 40'GP container.");
        System.out.println("You would fit around "+CTN20+" pieces in a 20'container.");

       
        //declare and set costs to 0
        double GP = 0;
        double GPAndLCL = 0;
        double GPAnd20 = 0;
        double GPAnd20AndLCL = 0;
        double HQ = 0;
        double HQAndLCL = 0;
        double HQAnd20 = 0;
        double HQAnd20AndLCL = 0;
        double HQAndGP = 0;
        double HQAndGPAndLCL = 0;
        double HQAndGPAnd20 = 0;
        double HQAndGPAnd20AndLCL= 0;
            
        //calculate costs
        double LCL = totalMasterCBM*675;
        double ctn20 = Math.ceil(totalMasterCBM/27)*13800;
        double ctn20AndLCL = Math.floor(totalMasterCBM/27)*13800+(totalMasterCBM-(Math.floor(totalMasterCBM/27)*27))*675;
        
        if(Math.floor(totalMasterCBM/27)>0){
            GP = Math.ceil(totalMasterCBM/57)*16875;
            GPAndLCL = Math.floor(totalMasterCBM/57)*16875+(totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))*675;
        }
        
        if(totalMasterCBM>57){
            HQ = Math.ceil(totalMasterCBM/63)*17125;
            HQAndLCL = Math.floor(totalMasterCBM/63)*17125+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63))*675;
        }

        if(totalMasterCBM>83.0741){
            GPAnd20 = Math.floor(totalMasterCBM/57)*16875+Math.ceil((totalMasterCBM-(Math.floor(totalMasterCBM/57)*57))/27)*13800;
            GPAnd20AndLCL = Math.floor(totalMasterCBM/57)*16875+13800+(totalMasterCBM-57-27)*675;                                                             
        }

        if(Math.floor(totalMasterCBM/63)>0&&totalMasterCBM>84.4444){
            HQAnd20 = Math.floor(totalMasterCBM/63)*17125+Math.ceil((totalMasterCBM-(Math.floor(totalMasterCBM/63)*63))/27)*13800;
        }
          
        if(Math.floor(totalMasterCBM/63)>0&&totalMasterCBM>84.5){    
            HQAnd20AndLCL = Math.floor(totalMasterCBM/63)*17125+13800+(totalMasterCBM-63-27)*675;
        }

          
        if(totalMasterCBM>88){
            HQAndGP = Math.floor(totalMasterCBM/63)*17125+Math.ceil((totalMasterCBM-(Math.floor(totalMasterCBM/63)*63))/57)*16875;
        }
        //under this, values too large and equalling 2 when .floor. does not work, 120 max cbm

        if(totalMasterCBM>120&&totalMasterCBM<140.444){
            //going negative
            HQAndGPAndLCL = Math.floor(totalMasterCBM/63)*17125+16875+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63+57))*675;
        }    
        
        if(totalMasterCBM>108.444){
            //value too high because Math.floor comes out to 2
            HQAndGPAnd20 = Math.floor(totalMasterCBM/63)*17125+16875+13800;
        }
        if(totalMasterCBM>147&&totalMasterCBM<210){    
        //going negative
        HQAndGPAnd20AndLCL = Math.floor(totalMasterCBM/63)*17125+16875+13800+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63+57+27))*675;
        }

        if(totalMasterCBM>210){
        HQAndGPAnd20AndLCL = Math.floor(totalMasterCBM/63)*17125+16875+13800+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63+57+27))*675; 
        }    
        
        /* 
        System.out.println("LCL: "+LCL);
        System.out.println("ctn20: "+ctn20);
        System.out.println("ctn20AndLCL: "+ctn20AndLCL);
        System.out.println("GP: "+GP);
        System.out.println("GPAndLCL: "+GPAndLCL);
        System.out.println("GPAnd20: "+GPAnd20);
        System.out.println("GPAnd20AndLCL: "+ GPAnd20AndLCL);
        System.out.println("HQ: "+HQ);
        System.out.println("HQAndLCL: "+HQAndLCL);
        System.out.println("HQAnd20: "+HQAnd20);
        System.out.println("HQAnd20AndLCL: "+HQAnd20AndLCL);
        System.out.println("HQAndGP: "+ HQAndGP);
        System.out.println("HQAndGPAndLCL: "+HQAndGPAndLCL);
        System.out.println("HQAndGPAnd20: "+HQAndGPAnd20);
        System.out.println("HQAndGPAnd20AndLCL: "+HQAndGPAnd20AndLCL);
        */
    
        
        double freightOptions[] = {LCL, ctn20, ctn20AndLCL, GP, GPAndLCL, GPAnd20, GPAnd20AndLCL, HQ, HQAndLCL, HQAnd20, HQAnd20AndLCL, HQAndGP, HQAndGPAndLCL, HQAndGPAnd20, HQAndGPAnd20AndLCL};

        double min = freightOptions[0];
	    int indexOfCheapest=0;

	       for(int i = 0; i < freightOptions.length; i++)
	       {
	            if(min > freightOptions[i]&&freightOptions[i]>5)
	            {
	                min = freightOptions[i];
	                indexOfCheapest=i;
	            }
	        }
        
        
        switch(indexOfCheapest){
            case 0:
                System.out.println("The most optimal freight solution is to ship LCL for a cost of $"+LCL);
                LCL = (double)Math.round(LCL * 1000)/1000;
                System.out.println("Cost/piece: $"+LCL/totalPieces);
                break;
            case 1:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/27)+" 20' containers for a cost of $"+ctn20);
                ctn20 = (double)Math.round(ctn20 * 1000)/1000;
                System.out.println("Cost/piece: $"+ctn20/totalPieces);
                break;
            case 2:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/27)+" 20' containers and the rest with LCL for a cost of $"+ctn20AndLCL);
                ctn20AndLCL = (double)Math.round(ctn20AndLCL * 1000)/1000;
                System.out.println("Cost/piece: $"+ctn20AndLCL/totalPieces);
                break;
            case 3:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/57)+" 40'GP containers for a cost of $"+GP);
                GP = (double)Math.round(GP * 1000)/1000;
                System.out.println("Cost/piece: $"+GP/totalPieces);
                break;
            case 4:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP containers and the rest with LCL for a cost of $"+GPAndLCL);
                GPAndLCL = (double)Math.round(GPAndLCL * 1000)/1000;
                System.out.println("Cost/piece: $"+GPAndLCL/totalPieces);
                break;
            case 5:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP containers and the rest with one 20' for a cost of $"+GPAnd20);
                GPAnd20 = (double)Math.round(GPAnd20 * 1000)/1000;
                System.out.println("Cost/piece: $"+GPAnd20/totalPieces);
                break;
            case 6:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP containers and the rest with one 20' and LCL for a cost of $"+GPAnd20AndLCL);
                GPAnd20AndLCL = (double)Math.round(GPAnd20AndLCL * 1000)/1000;
                System.out.println("Cost/piece: $"+GPAnd20AndLCL/totalPieces);
                break;
            case 7:
                System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/63)+" 40'HQ containers for a cost of $"+HQ);
                HQ = (double)Math.round(HQ * 1000)/1000;
                System.out.println("Cost/piece: $"+HQ/totalPieces);
                break;
            case 8:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with LCL for a cost of $"+HQAndLCL);
                HQAndLCL = (double)Math.round(HQAndLCL * 1000)/1000;
                System.out.println("Cost/piece: $"+HQAndLCL/totalPieces);
                break;
            case 9:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 20' container for a cost of $"+HQAnd20);
                HQAnd20 = (double)Math.round(HQAnd20 * 1000)/1000;
                System.out.println("Cost/piece: $"+HQAnd20/totalPieces);
                break;
            case 10:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 20' and LCL for a cost of $"+HQAnd20AndLCL);
                HQAnd20AndLCL = (double)Math.round(HQAnd20AndLCL * 1000)/1000;
                System.out.println("Cost/piece: $"+HQAnd20AndLCL/totalPieces);
                break;
            case 11:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 40'GP container for a cost of $"+HQAndGP);
                HQAndGP = (double)Math.round(HQAndGP * 1000)/1000;
                System.out.println("Cost/piece: $"+HQAndGP/totalPieces);
                break;
            case 12:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 40'GP and LCL for a cost of $"+HQAndGPAndLCL);
                HQAndGPAndLCL = (double)Math.round(HQAndGPAndLCL * 1000)/1000;
                System.out.println("Cost/piece: $"+HQAndGPAndLCL/totalPieces);
                break;
            case 13:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 40'GP and one 20' for a cost of $"+HQAndGPAnd20);
                HQAndGPAnd20 = (double)Math.round(HQAndGPAnd20 * 1000)/1000;
                System.out.println("Cost/piece: $"+HQAndGPAnd20/totalPieces);
                break;
            case 14:
                System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ containers and the rest with one 40'GP and one 20' and LCL for a cost of $"+HQAndGPAnd20AndLCL);
                HQAndGPAnd20AndLCL = (double)Math.round(HQAndGPAnd20AndLCL * 1000)/1000;
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