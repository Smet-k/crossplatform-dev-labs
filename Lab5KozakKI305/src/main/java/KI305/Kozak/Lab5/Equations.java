/**Package for Lab 5 */
package KI305.Kozak.Lab5;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Exception thrown when an invalid argument is passed to a mathematical calculation
 * in the Equations class.
 */
class CalcException extends ArithmeticException {
    /**
     * Creates a new CalcException without a detail message.
     */
    public CalcException() {}

    /**
     * Creates a new CalcException with the specified detail message.
     */
    public CalcException(String e) {
        super(e);
    }
}

/**
 * Equations class represents equation tan(x)/cot(x).
 */
public class Equations {
    /** File helper field, used to simplify operations with files */
    private FileHelper fh;

    /**
     * Creates an Equation with default values
     */
    public Equations(){
        this.fh = new FileHelper();
    }

    /**
     * Creates an Equation with set Filehelper
     * 
     * @param filename file that will be used by FileHelper
     */
    public Equations(String filename){
        this.fh = new FileHelper(filename);
    }

    /**
     * Gets file helper.
     * 
     * @return file helper
     */
    public FileHelper getFileHelper(){
        return this.fh;
    }

    /**
     * Sets the file helper.
     * 
     * @param fh new file helper.
     */
    public void setFileHelper(FileHelper fh){
        this.fh = fh;
    }

    /**
     * Calculates the cot of provided value.
     * 
     * @param rad radians to find cot of
     * @return cot of rad
     */
    private double cot(double rad){
        return 1.0 / Math.tan(rad);
    }

    /**
     * Calculates the value of the expression:
     * tan(x)/cot(x)
     * 
     * where x is given in degrees.
     * 
     * @param x the angle in degrees
     * @return the result of the calculation
     * @throws CalcException if x corresponds to an undefined tangent or cotangent value,
     *                       or if the calculation results in an illegal or undefined value
     */
    public double calculate(int x) throws CalcException, FileNotFoundException, IOException{
        double y, rad;
        rad = x * Math.PI / 180.0;

        try{
            if(x == 90 || x == -90 || x % 180 == 0)
                throw new ArithmeticException();
                
            y = Math.tan(rad)/cot(rad);

            String fileFormat = fh.getFileFormat();
            
            // Chooses the function corresponding to file format
            switch (fileFormat) {
                case "txt" -> fh.writeTxt(y);
                case "bin" -> fh.writeBin(y);
                default -> throw new FileNotFoundException("Exception reason: Unsupported file format.");
            }


            if(Double.isNaN(y) || Double.isInfinite(y))
                throw new ArithmeticException();
        }catch(ArithmeticException ex){
            if(Math.abs(rad)==Math.PI/2.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else if(Math.abs(rad % Math.PI) == 0.0)
                throw new CalcException("Exception reason: Illegal value of X for cotangent calculation");
            else if(x == 0)
                throw new CalcException("Exception reason: X = 0");
            else
                throw new CalcException("Unknown exception reason");            
        }catch(FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        }catch(IOException ex){
            throw new IOException("Exception reason: Error writing to/reading from a file");
        }

        return y;
    }
}
