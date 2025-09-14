/** Package for Lab 6 */
package KI305.Kozak.Lab6;

import java.util.ArrayList;

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