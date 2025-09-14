/** Package for Lab 6 */
package KI305.Kozak.Lab6;

import java.util.ArrayList;

/**
 * Provides the Stationery functionality for classes that implement it.
 * 
 * <p>
 * Extend Comparable interface, the class that implements it will need to
 * implement CompareTo method.
 * </p>
 */
interface Stationery extends Comparable<Stationery> {
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

/**
 * Pen represents a pen(item of stationery) 
 * it contains size and remaining uses.
 * Implements Stationery to fit into Case.
 */
class Pen implements Stationery {
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

/**
 * Pencil represents a pencil(item of stationery)
 * it contains size and remaining uses.
 * Implements Stationery to fit into Case.
 */
class Pencil implements Stationery {
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
/**
 * Case class represents a case
 * it contains an array of T
 * T must extend stationery.
 */
public class Case<T extends Stationery> {
    /** List of Stationery items*/
    private ArrayList<T> arr;

    /**
     * Creates a case with empty list.
     */
    public Case(){
        arr = new ArrayList<>();
    }

    /**
     * Find the element with the lowest {@code size}.
     * 
     * @return element with lowest size.
     */
    public T findMin(){
        if(!arr.isEmpty()){
            T min = arr.get(0);
            for(int i = 1; i < arr.size(); i++){
                if(arr.get(i).compareTo(min) < 0)
                    min = arr.get(i);
            }
            return min;
        }
        return null;
    }

    /**
     * Adds a new item to {@code arr}
     * @param item new Stationery item.
     */
    public void AddStationery(T item){
        arr.add(item);
    }

    /**
     * Removes the item at index i
     * 
     * @param i index of removed item
     */
    public void RemoveStationery(int i){
        arr.remove(i);
    }

    /**
     * Display case's info
     */
    public void displayInfo(){
        for (T item : arr) {
            item.displayInfo();
        }
    }
}