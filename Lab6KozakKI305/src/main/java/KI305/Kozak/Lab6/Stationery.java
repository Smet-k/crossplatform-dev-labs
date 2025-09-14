
package KI305.Kozak.Lab6;

/**
 * Provides the Stationery functionality for classes that implement it.
 * 
 * <p>
 * Extend Comparable interface, the class that implements it will need to
 * implement CompareTo method.
 * </p>
 */
public interface Stationery extends Comparable<Stationery> {
    /**
     * Gets the Stationery's size
     * 
     * @return size
     */
    abstract double getSize();

    /**
     * Sets the Stationery's size
     * 
     * @param size new size
     */
    abstract void setSize(double size);

    /**
     * Does the action depending on Stationery implementing it
     */
    abstract void act();
    
    /**
     * Displays info about Stationery
     */
    abstract void displayInfo();
}



