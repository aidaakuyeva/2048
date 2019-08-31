/* Name: Aida M. Akuyeva
 * Pennkey: aakuyeva
 * Recitation: 201
 * 
 * Execution: java TwentyFourtyEight
 * 
 * This program creates a cell object with a certain number
 * 
 */
public class Cell {
    private int number;
    
    //constructor
    public Cell(int number) {
        this.number = number;
    }
    
    /*
     * Description: this function returns the cell's number
     * Output: int number
     */
    public int getNumber() {
        return number;
    }
    
    /*
     * Description: this function sets cell's number to a new inputted value
     * Input: int num
     */
    public void setNumber(int num) {
        number = num;
    }
    
    /*
     * Description: this function checks whether the cell is empty
     * Output: boolean true/false based on condition
     */
    public boolean isEmpty() {
        return number == 0; 
    }
}