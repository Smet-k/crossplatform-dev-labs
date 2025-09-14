/** Package for lab 3*/
package KI305.Kozak.Lab3;

/**
 * Class driver for Lab 3 demonstration
 */
public class App {
    /**
     * main class, the program's entry point
     * 
     * @param args
     */
    public static void main(String[] args) {
        OfficeCentre centre1 = new OfficeCentre();
        OfficeCentre centre2 = new OfficeCentre("Office st. 5", 4, 424.0f, "CompanyName2");
        OfficeCentre centre3 = new OfficeCentre("Office st. 6", 7, 915.3f, "CompanyName3", true, 250);

        centre1.setAddress("Office st. 2");
        centre1.setArea(532.4f);
        centre1.setFloors(3);
        centre1.setCompanyName("Company1");
        centre1.setHasElevator(true);

        centre1.displayInfo();

        centre2.addFloor();

        centre2.displayInfo();

        centre3.displayInfo();

    }
}
