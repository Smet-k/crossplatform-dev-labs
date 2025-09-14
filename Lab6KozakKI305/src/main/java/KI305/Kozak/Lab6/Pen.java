/** Package for Lab 6 */
package KI305.Kozak.Lab6;

/**
 * Pen represents a pen(item of stationery) 
 * it contains size and remaining uses.
 * Implements Stationery to fit into Case.
 */
public class Pen implements Stationery {
    /** Size of pen*/
    private double size = 0.0;
    /** The gel color of pen*/
    private String color = "";
    /** Times pen was used*/
    private int timesActed = 0;

    /**
     * Creates a Pen with default values.
     */
    public Pen(){}

    /**
     * Creates a Pen with size.
     * 
     * @param size Pen's size.
     */
    public Pen(double size){
        this.size = size;
    }

    /**
     * Creates Pen with all Fields.
     * 
     * @param size Pen's size.
     * @param color Gel color.
     * @param timesActed Times acted.
     */
    public Pen(double size, String color, int timesActed){
        this.size = size;
        this.color = color;
        this.timesActed = timesActed;
    }

    /**
     * Gets amount of times pen was used.
     * 
     * @return times used.
     */
    public int getTimesActed() {
        return this.timesActed;
    }

    /**
     * Sets the amount of times pen was used.
     * 
     * @param timesActed new times used.
     */
    public void setTimesActed(int timesActed) {
        this.timesActed = timesActed;
    }

    /**
     * Gets the gel color.
     * 
     * @return gel color.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Sets the gel color.
     * 
     * @param color new gel color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the pen size.
     * 
     * @return Pen size.
     */
    @Override
    public double getSize() {
        return this.size;
    }

    /**
     * Sets the pen size.
     * 
     * @param size new size.
     */
    @Override
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Performs a Stationery action.
     */
    @Override
    public void act() {
        System.out.printf("Pen action: Draw a line with  %s gel\n", color);
        timesActed++;
    }

    /**
     * Compares this Stationery to provided one for order. 
     * 
     * <p>
     *  Comparison is based on the size field.
     *  it returns:
     *      <ul>
     *          <li>negative integer if this object's size is less than the provided one's size</li>
     *          <li>zero if both size are equal</li>
     *          <li>positive integer if this objects's size is greater than the provided one's size</li>
     *      </ul>
     * </p>
     * 
     * @param stat the Stationery object to be compared
     * @return a negative integer, zero, or a positive integer as this object's size 
     *         is less than, equal to, or greater than the specified object's size
     */
    @Override
    public int compareTo(Stationery stat) {
        Double s = this.size;
        return s.compareTo(stat.getSize());
    }

    /**
     * Displays info about Pen.
     */
    @Override
    public void displayInfo(){
        System.out.printf("Size: %.3f, Color: %s, Times acted: %d \n", size, color, timesActed);
    }
}