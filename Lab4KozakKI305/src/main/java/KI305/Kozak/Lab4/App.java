/**Package for Lab 4 */
package KI305.Kozak.Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Driver class for Lab 4 demonstration
 */
public class App {
    /**
     * main method is program's entry point
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Enter file name: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        try{
            PrintWriter fout = new PrintWriter(new File(fileName));
            try{
                try{
                    Equations eq = new Equations();
                    System.out.print("Enter X: ");
                    fout.print(eq.calculate(in.nextInt()));
                }
                finally{
                    fout.flush();
                    fout.close();
                }
            } catch(CalcException ex){
                System.out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex){
            System.out.println("Exception reason: wrong file path");
        }
        in.close();
    }
}
