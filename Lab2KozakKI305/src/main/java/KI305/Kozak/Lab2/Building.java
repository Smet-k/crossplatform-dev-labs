/**Package for lab 2*/
package KI305.Kozak.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
/**
 * Building class represents a building.
 * it contains - address, floors, area, elevator presense
 * in addition this class implements logging
 */
public class Building {
    /** Building's floors */
    private int floors = 0;
    /** Building's address. */
    private String address = "";
    /** Building's area. */
    private float area = 0.0f;
    /** Is elevator present in building. */
    private boolean hasElevator = false;
    /** Log file's path.  */
    private String logFile = "BuildingLog.txt";

    /**
     * Creates a Building with default values.
     */
    public Building(){}

    /**
     * Creates a Building with address, floors, area.
     * @param address building address.
     * @param floors amount of floors in the building.
     * @param area building area.
     */
    public Building(String address, int floors, float area) {
        this.floors = floors;
        this.address = address;
        this.area = area;
    }

    /**
     * Creates a Building with address, floors, area and elevator presence.
     * @param address building address.
     * @param floors amount of floors in the building.
     * @param area building area.
     * @param hasElevator elevator presence in the building.
     */
    public Building(String address, int floors, float area, boolean hasElevator) {
        this(address, floors, area);
        this.hasElevator = hasElevator;
    }

    /**
     * Creates a building with every parameter set.
     * @param address building address.
     * @param floors amount of floors in the building.
     * @param area building area.
     * @param hasElevator elevator presence in the building.
     * @param logFile path to log file.
     */
    public Building(String address, int floors, float area, boolean hasElevator, String logFile) {
        this(address, floors, area, hasElevator);
        this.logFile = logFile;
    }

    /**
     * Gets if buiding has a elevator
     * 
     * @return true if building has an elevator, else false.
     */
    public boolean getHasElevator(){
        log("HasElevator requested.");
        return this.hasElevator;
    }

    /**
     * Sets if building has a elevator.
     * 
     * @param hasElevator is elevator present.
     */
    public void setHasElevator(boolean hasElevator){
        log("HasElevator changed to: " + hasElevator + ".");
        this.hasElevator = hasElevator;
    }

    /**
     * Gets the amount of floors.
     * 
     * @return amount of floors.
     */
    public int getFloors() {
        log("Floors requested.");
        return this.floors;
    }

    /**
     * Sets the amount of floors.
     * 
     * @param floors amount of floors.
     */
    public void setFloors(int floors) {
        log("Floors changed to: " + floors + ".");
        this.floors = floors;
    }

    /**
     * Gets the address.
     * 
     * @return building address.
     */
    public String getAddress() {
        log("Address requested.");
        return this.address;
    }

    /**
     * Sets the address.
     * 
     * @param address new address.
     */
    public void setAddress(String address) {
        log("Address changed to: " + address + ".");
        this.address = address;
    }

    /**
     * Gets the area.
     * 
     * @return area.
     */
    public float getArea() {
        log("Area requested.");
        return this.area;
    }

    /**
     * Sets the area.
     * 
     * @param area new area.
     */
    public void setArea(float area) {
        log("Area changed to: " + area + ".");
        this.area = area;
    }

    /**
     * Gets the log file path.
     * 
     * @return log file path.
     */
    public String getLogFile() {
        log("LogFile requested.");
        return this.logFile;
    }

    /**
     * Sets the log file path.
     * 
     * @param logFile Log file path.
     */
    public void setLogFile(String logFile) {
        this.logFile = logFile;
        log("LogFile changed to: " + logFile + ".");
    }

    /**
     *  Display building's info.
     * 
     */
    public void displayInfo() {
        log("Building info displayed.");
        System.out.printf("Building info: %s, floors: %d, area: %fm², ", address, floors,  area);
        System.out.printf("Has elevator: %s, current log file %s.\n", (hasElevator ? "Yes" : "No"), logFile);
    }

    /**
     * Adds a new floor to the building.
     * area increases with addition of new floor,
     * if area is 0 or lower, the operation won't go through.
     */
    public void addFloor(){
        if(area <= 0){
            log("Failed to add floor, current area: " + area);
            return;
        }

        area += area / floors;
        floors++;
        log("Added a floor. Total floors: " + floors + ", new area: " + area);
    }

    /**
     * Returns the average area.
     * 
     * @return the average area.
     */
    public float getFloorArea(){
        log("FloorArea requested.");
        return area / floors;
    }

    /**
     * Writes the data to log.
     * 
     * @param msg data to write.
     */
    private void log(String msg){
        try {
            FileWriter fw = new FileWriter(logFile, true);

            fw.write(LocalDateTime.now() + " - " + msg + "\n");

            fw.close();
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }

}
