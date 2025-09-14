/** Package for Lab 6 */
package KI305.Kozak.Lab6;

import java.util.Random;

/**
 * Driver class for Lab 6 demonstration
 */
public class App {
    /**
     * main method is program's entry point
     * 
     * @param args
     */
    public static void main(String[] args) {
        Case <? super Stationery> pencilCase = new Case<>();
        Random rand = new Random();

        // Fills the pencilCase with either Pen or Pencil
        for(int i = 0; i < 8; i++){
            switch (rand.nextInt(2)) {
                case 0 -> pencilCase.AddStationery(new Pen(rand.nextDouble(20.0), "Purple", rand.nextInt(24)));
                case 1 -> pencilCase.AddStationery(new Pencil(rand.nextDouble(20.0), rand.nextInt(200)));
                default -> {
                }
            }
        }

        Stationery res = pencilCase.findMin();

        System.out.println("---------- Items inside the case ----------");
        pencilCase.displayInfo();
        System.out.println("---------- Min item ----------");
        res.displayInfo();

    }
}
