import java.lang.reflect.Constructor;
import java.util.Scanner;


public class Main {

    public double calcCBM(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter dimension 1"); 
        double dimension1 = input.nextDouble();
        System.out.println("Enter dimension 2");
        double dimension2 = input.nextDouble();
        System.out.println("Enter dimension 3");
        double dimension3 = input.nextDouble();
      
        
        double cbm = dimension1*dimension2*dimension3;

        System.out.println(cbm);
     
    public static void main(String[] args) throws Exception {
       

    }
}
