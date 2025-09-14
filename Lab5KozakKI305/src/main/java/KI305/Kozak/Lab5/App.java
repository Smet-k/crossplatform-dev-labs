/** Package for Lab 5 */
package KI305.Kozak.Lab5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Driver class for Lab 5 demonstration
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
        double result = 0.0;

        try{
            FileHelper fh = new FileHelper(fileName);
            try{
                Equations eq = new Equations();
                eq.setFileHelper(fh);

                System.out.print("Enter X: ");
                eq.calculate(in.nextInt());
            } catch(CalcException ex){
                System.out.println(ex.getMessage());
            }

            String fileFormat = fh.getFileFormat();
            // Chooses the function corresponding to file format
            switch (fileFormat) {
                case "txt" -> result = fh.readTxt();
                case "bin" -> result = fh.readBin();
                default -> {
                    in.close();
                    throw new FileNotFoundException("Exception reason: Unsupported file format.");
                }
            }
        } catch (FileNotFoundException ex ){
            System.out.println(ex.getMessage());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        } 
        
        in.close();
        
        System.out.println("Calculation result from " + fileName);
        System.out.printf("Result: %f \n", result);
    }
}
