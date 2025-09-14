/** Package for lab 3*/
package KI305.Kozak.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Provides logging functionality for classes that implement it.
 * 
 * Implementing classes must define how messages are written to the file or another logging target
 */
interface Loggable {
    /**
     * Writes a message to the log
     * 
     * @param message the message to be logged
     */
    void log(String message);

    /** Default path for the log file */
    String logPath = "Log.txt";
}

/**
 * Defines working hours for an organization.
 * 
 * Implementing classes provide behavior to check whether the
 * organization is open or closed at a given time
 */
interface Workplace{
    /**
     * Determines if the place is open at the given time
     * @param time
     */
    void isWorking(LocalTime time);

    /** Closing hour of the workplace(19:00) */
    LocalTime closingHour = LocalTime.of(19, 0);
    /** Opening hour of the workplace (9:00) */
    LocalTime openingHour = LocalTime.of(9, 0);
}

/**
 * Represents a specialized Builidng that serves as an office center.
 * 
 * In addition to standard building properties, this class contains
 * the company name and employee count. It also implements Workplace
 * and Loggable interfaces, to see if office is open and to log it respectively
 */
public class OfficeCentre extends Building implements Workplace, Loggable{
    private String companyName = "";
    private int employeeCount = 0;

    /**
     * Creates an OfficeCentre with default values.
     */
    public OfficeCentre(){ }

    /**
     * Creates a OfficeCentre with address, floors, area and company name.
     * @param address building address.
     * @param floors amount of floors in the building.
     * @param area building area.
     * @param companyName company name
     */
    public OfficeCentre(String address, int floors, float area, String companyName) {
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.companyName = companyName;
    }

    /**
     * Creates a OfficeCentre with address, floors, area, company name and elevator presence.
     * @param address building address.
     * @param floors amount of floors in the building.
     * @param area building area.
     * @param companyName company name
     * @param hasElevator elevator presence in the building.
     */
    public OfficeCentre(String address, int floors, float area, String companyName, boolean hasElevator) {
        this(address, floors, area, companyName);
        hasElevator = true;
    }

    /**
     * Creates a OfficeCentre with every value set.
     * @param address building address.
     * @param floors amount of floors in the building.
     * @param area building area.
     * @param companyName company name
     * @param hasElevator elevator presence in the building.
     * @param employeeCount employee count.
     */
    public OfficeCentre(String address, int floors, float area, String companyName, boolean hasElevator, int employeeCount) {
        this(address, floors, area, companyName, hasElevator);
        this.employeeCount = employeeCount;
    }

    /**
     * Gets the company name.
     * 
     * @return company name.
     */
    public String getCompanyName(){
        log("CompanyName requested.");
        return this.companyName;
    }

    /**
     * Sets the new company name.
     * 
     * @param companyName new company name.
     */
    public void setCompanyName(String companyName){
        log("CompanyName changed to: " + companyName + ".");
        this.companyName = companyName;
    }

    /**
     * Gets employee count.
     * 
     * @return employee count.
     */
    public int getEmployeeCount(){
        log("EmployeeCount requested.");
        return this.employeeCount;
    }

    /**
     * Sets the new employee ocunt.
     * 
     * @param employeeCount employee count.
     */
    public void setEmployeeCount(int employeeCount){
        log("EmployeeCount changed to: " + employeeCount + ".");
        this.employeeCount = employeeCount;
    }

    /**
     * {@inheritDoc}
     * Additionaly, each access is logged.
     */
    @Override
    public boolean getHasElevator() {
        log("Elevator status requested.");
        return this.hasElevator;
    }

    /**
     * {@inheritDoc}
     * Additionaly, each change is logged.
     */
    @Override
    public void setHasElevator(boolean hasElevator) {
        log("HasElevator changed to: " + hasElevator + ".");
        this.hasElevator = hasElevator;
    }

    /**
     * {@inheritDoc}
     * Additionaly, each access is logged.
     */
    @Override
    public int getFloors() {
        log("Floors requested.");
        return this.floors;
    }

    /**
     * {@inheritDoc}
     * Additionaly, each change is logged.
     */
    @Override
    public void setFloors(int floors) {
        log("Floors changed to: " + floors + ".");
        this.floors = floors;
    }

    /**
     * {@inheritDoc}
     * Additionaly, each access is logged.
     */
    @Override
    public String getAddress() {
        log("Address requested.");
        return this.address;
    }

    /**
     * {@inheritDoc}
     * Additionaly, each change is logged.
     */
    @Override
    public void setAddress(String address) {
        log("Address changed to: " + address + ".");
        this.address = address;
    }

    /**
     * {@inheritDoc}
     * Additionaly, each access is logged.
     */
    @Override
    public float getArea() {
        log("Area requested.");
        return this.area;
    }

    /**
     * {@inheritDoc}
     * Additionaly, each change is logged.
     */
    @Override
    public void setArea(float area) {
        log("Area changed to: " + area + ".");
        this.area = area;
    }

    /**
     * {@inheritDoc}
     * Additionaly, the method call is logged.
     */
    @Override
    public void displayInfo() {
        log("Building info displayed.");
        System.out.printf("Building info: %s, floors: %d, area: %.2fkm² ", address, floors,  area);
        System.out.printf("Has elevator: %s, company: %s, employees: %d.\n", (hasElevator ? "Yes" : "No"), companyName, employeeCount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFloor() {
        if(area <= 0){
            log("Failed to add floor, current area: " + area);
            return;
        }

        area += area / floors;
        floors++;
        log("Added a floor. Total floors: " + floors + ", new area: " + area);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float getFloorArea() {
        log("FloorArea requested.");
        return area / floors;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void isWorking(LocalTime time){
        if(time.isBefore(openingHour)){
            System.out.println("The office hasn't opened yet.");
        }
        else if(time.isAfter(closingHour)){
            System.out.println("The office is closed already.");
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void log(String msg){
        try {
            FileWriter fw = new FileWriter(logPath, true);

            fw.write(LocalDateTime.now() + " - " + msg + "\n");

            fw.close();
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}
