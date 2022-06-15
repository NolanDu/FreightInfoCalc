import java.util.Scanner;
import java.lang.Math;

public class Tester {
public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double dimension1 = 10;
        double dimension2 = 10;
        double dimension3 = 10;
        System.out.println("Enter test CBM");
        double totalPieces = input.nextDouble();
        totalPieces= totalPieces*10000;
        double perMaster = 10; 


        double CBM = (0.01*dimension1)*(0.01*dimension2)*(dimension3*0.01);
      
        double totalMasterCBM = (totalPieces/perMaster)*CBM;
        totalMasterCBM = (double)Math.round(totalMasterCBM * 1000)/1000;
        System.out.println(totalMasterCBM);

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
        //under this, values have higher chance of error 

        if(totalMasterCBM>120&&totalMasterCBM<140.444){
            //never optimal
            HQAndGPAndLCL = 0;
            //Math.floor(totalMasterCBM/63)*17125+16875+(totalMasterCBM-(Math.floor(totalMasterCBM/63)*63+57))*675;
        }    
        
        if(totalMasterCBM>108.444&&(totalMasterCBM-57-27)%63==0){
            //this is only the optimal value when cbm is equal to 147 or a multiple
            HQAndGPAnd20 = ((totalMasterCBM-57-27)/63)*17125+16875+13800;
            //Math.floor(totalMasterCBM/63)*17125+16875+13800
        }
        
        if(totalMasterCBM>147&&totalMasterCBM<210){    
            //never optimal
            HQAndGPAnd20AndLCL = 0;
            //Math.floor((totalMasterCBM-57-27)/63)*17125+16875+13800+(totalMasterCBM-(Math.floor((totalMasterCBM-57-27)/63)*63))*675;
        }  
    
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
                    double c0 = (double)Math.round(LCL/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c0);
                    break;
                case 1:
                    System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/27)+" 20' container(s) for a cost of $"+ctn20);
                    double c1 = (double)Math.round(ctn20/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c1);
                    break;
                case 2:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/27)+" 20' container(s) and the rest with LCL for a cost of $"+ctn20AndLCL);
                    double c2 = (double)Math.round(ctn20AndLCL/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c2);
                    break;
                case 3:
                    System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/57)+" 40'GP container(s) for a cost of $"+GP);
                    double c3 = (double)Math.round(GP/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c3);
                    break;
                case 4:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP container(s) and the rest with LCL for a cost of $"+GPAndLCL);
                    double c4 = (double)Math.round(GPAndLCL/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c4);
                    break;
                case 5:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP container(s) and the rest with one 20' for a cost of $"+GPAnd20);
                    double c5 = (double)Math.round(GPAnd20/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c5);
                    break;
                case 6:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/57)+" 40'GP container(s) and the rest with one 20' and LCL for a cost of $"+GPAnd20AndLCL);
                    double c6 = (double)Math.round(GPAnd20AndLCL/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c6);
                    break;
                case 7:
                    System.out.println("The most optimal freight solution is to ship "+Math.ceil(totalMasterCBM/63)+" 40'HQ container(s) for a cost of $"+HQ);
                    double c7 = (double)Math.round(HQ/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c7);
                    break;
                case 8:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ container(s) and the rest with LCL for a cost of $"+HQAndLCL);
                    double c8 = (double)Math.round(HQAndLCL/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c8);
                    break;
                case 9:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ container(s) and the rest with one 20' container for a cost of $"+HQAnd20);
                    double c9 = (double)Math.round(HQAnd20/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c9);
                    break;
                case 10:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ container(s) and the rest with one 20' and LCL for a cost of $"+HQAnd20AndLCL);
                    double c10 = (double)Math.round(HQAnd20AndLCL/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c10);
                    break;
                case 11:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ container(s) and the rest with one 40'GP container for a cost of $"+HQAndGP);
                    double c11 = (double)Math.round(HQAndGP/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c11);
                    break;
                case 12:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor(totalMasterCBM/63)+" 40'HQ container(s) and the rest with one 40'GP and LCL for a cost of $"+HQAndGPAndLCL);
                    double c12 = (double)Math.round(HQAndGPAndLCL/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c12);
                    break;
                case 13:
                    System.out.println("The most optimal freight solution is to ship "+(totalMasterCBM-57-27)/63+" 40'HQ container(s) and the rest with one 40'GP and one 20' for a cost of $"+HQAndGPAnd20);
                    double c13 = (double)Math.round(HQAndGPAnd20/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c13);
                    break;
                case 14:
                    System.out.println("The most optimal freight solution is to ship "+Math.floor((totalMasterCBM-57-27)/63)+" 40'HQ container(s) and the rest with one 40'GP and one 20' and LCL for a cost of $"+HQAndGPAnd20AndLCL);
                    double c14 = (double)Math.round(HQAndGPAnd20AndLCL/totalPieces * 1000)/1000;
                    System.out.println("Cost/piece: $"+c14);
                    break;
                }
    }
       
          
    }


