/** Package for lab 3 */
package KI305.Kozak.Lab3;

/**
 * abstract class representing a general type of building.
 */
public abstract class Building {

    /**
     * Building floor count.
     */
    protected int floors = 0;
    /**
     * Building address.
     */
    protected String address = "";
    /**
     * Building area.
     */
    protected float area = 0.0f;
    /**
     * Is elevator present.
     */
    protected boolean hasElevator = false;

    /**
     * Gets the presence of elevator
     *
     * @return True if elevator present, otherwise false
     */
    abstract boolean getHasElevator();

    /**
     * Sets the elevator presence.
     *
     * @param hasElevator new elevator presence.
     */
    abstract void setHasElevator(boolean hasElevator);

    /**
     * Gets the floor count.
     * 
     * @return floor count.
     */
    abstract int getFloors();

    /**
     * Sets the floor count.
     * 
     * @param floors new floor count
     */
    abstract void setFloors(int floors);

    /**
     * Gets the address.
     * 
     * @return address.
     */
    abstract String getAddress();

    /**
     * Sets the address.
     * 
     * @param address new address.
     */
    abstract void setAddress(String address);

    /**
     * Gets the area.
     * 
     * @return area.
     */
    abstract float getArea();

    /**
     * Sets the area.
     * 
     * @param area new area.
     */
    abstract void setArea(float area);

    /**
     *  Displays info about class object.
     * 
     */
    abstract void displayInfo();

    /**
     * Adds a new floor.
     */
    abstract void addFloor();

    /**
     * Calculates the average floor area.
     * 
     * @return average floor area
     */
    abstract float getFloorArea();
}
