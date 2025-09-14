/**Package for Lab 4 */
package KI305.Kozak.Lab4;

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
    /**
     * Calculates the cot of provided value.
     * 
     * @param rad 
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
    public double calculate(int x) throws CalcException{
        double y, rad;
        rad = x * Math.PI / 180.0;

        try{
            if(x == 90 || x == -90 || x % 180 == 0)
                throw new ArithmeticException();
                
            y = Math.tan(rad)/cot(rad);

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
        }   

        return y;
    }
}
