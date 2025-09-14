/** Package for Lab 6 */
package KI305.Kozak.Lab6;

/**
 * Pencil represents a pencil(item of stationery)
 * it contains size and remaining uses.
 * Implements Stationery to fit into Case.
 */
public class Pencil implements Stationery {
    /** Size of the pencil*/
    double size = 0.0;
    /** Times pencil can be used before expended */
    int remainingUses = 100;

    /**
     * Creates a Pencil with default Values.
     */
    public Pencil(){}

    /**
     * Creates a Pencil with size.
     * 
     * @param size Pencil size.
     */
    public Pencil(double size){
        this.size = size;
    }

    /**
     * Creates a Pencil with set Values.
     * 
     * @param size Pencil Size.
     * @param remainingUses Remaining uses.
     */
    public Pencil(double size, int remainingUses){
        this.size = size;
        this.remainingUses = remainingUses;
    }

    /**
     * Gets the pencil's size.
     * 
     * @return Pencil size.
     */
    @Override
    public double getSize() {
        return this.size;
    }

    /**
     * Sets the pencil's size.
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
        if (remainingUses > 0) {
            System.out.printf("Pen action: Draw a line with pencil\n");
            remainingUses--;
        } else
            System.out.println("Pen action: No uses remaining");
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
     * Displays Pencil's info
     */
    @Override
    public void displayInfo(){
        System.out.printf("Size: %.3f, Remaining uses: %s \n", size, remainingUses);
    }
}