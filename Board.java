/* Name: Aida M. Akuyeva
 * Pennkey: aakuyeva
 * Recitation: 201
 * 
 * Execution: java TwentyFourtyEight
 * 
 * This program creates a board object that contains a 2d cell array.
 * It also generates a random cell and merges the cells together, as well
 * as checks for the end of the game conditions (e.g. no more moves 
 * possible or reaching cell number 2048).
 * 
 */
public class Board {
    private Cell[][] board;
    
    //constructor - fills the board with empty cells (number = 0)
    public Board() {
        this.board = new Cell[4][4];
        int i = 2;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = new Cell(0);
            }
        }
    }
    
    /*
     * Description: this function returns the 2D Cell array
     * Output: 2D Cell array board
     */
    public Cell[][] getCellArray() {
        return board;
    }
    
    /*
     * Description: this function generates a random cell by
     *              counting the number of empty cells and picking
     *              a random one from them; the number of the cell is 2 or 4
     */
    public void random() {
        int num = 2 * (int) (2 * Math.random() + 1);
        int count = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col].isEmpty()) {
                    count++;
                }
            }
        }
        
        int counter = 0;
        int n = (int) (Math.random() * (count - 2)) + 1;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (counter == n) {
                    board[row][col].setNumber(num);
                }
                counter++;
            }
        }
        
    }
    
    /*
     * Description: this function merges two cells down with the same number
     *              if they are neighbors
     */
    public void mergeDown() {
        for (int row = 2; row >= 0; row--) {
            for (int col = 0; col < 4; col++) {
                //slide
                int cellRow = row;
                int nextRow = row + 1;
                int num = board[cellRow][col].getNumber();
                while ((!board[cellRow][col].isEmpty()) && (cellRow < 3) && 
                       (board[nextRow][col].isEmpty())) {
                    board[nextRow][col].setNumber(num);
                    board[cellRow][col].setNumber(0);
                    
                    cellRow++;
                    nextRow++;
                }
                
                //merge
                if (cellRow < 3) {
                    int oneNum = board[cellRow][col].getNumber();
                    int twoNum = board[nextRow][col].getNumber();
                    
                    if (oneNum == twoNum) {
                        board[nextRow][col].setNumber(oneNum + twoNum);
                        board[cellRow][col].setNumber(0);
                    }
                }
                
            }
        }
    }
    
    /*
     * Description: this function merges two cells up with the same number
     *              if they are neighbors
     */
    public void mergeUp() {
        for (int row = 1; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                //slide
                int cellRow = row;
                int nextRow = row - 1;
                int num = board[cellRow][col].getNumber();
                while ((!board[cellRow][col].isEmpty()) && (cellRow > 0) && 
                       (board[nextRow][col].isEmpty())) {
                    board[nextRow][col].setNumber(num);
                    board[cellRow][col].setNumber(0);
                    
                    cellRow--;
                    nextRow--;
                }
                
                if (cellRow > 0) {
                    //merge
                    int oneNum = board[cellRow][col].getNumber();
                    int twoNum = board[nextRow][col].getNumber();
                    
                    if (oneNum == twoNum) {
                        board[nextRow][col].setNumber(oneNum + twoNum);
                        board[cellRow][col].setNumber(0);
                    }
                }
                
            }
        }
    }
    
    
    /*
     * Description: this function merges two cells right with the same number
     *              if they are neighbors
     */
    public void mergeRight() {
        for (int row = 0; row < 4; row++) {
            for (int col = 2; col >= 0; col--) {
                //slide
                int cellCol = col;
                int nextCol = col + 1;
                int num = board[row][cellCol].getNumber();
                while ((!board[row][cellCol].isEmpty()) && (cellCol < 3) && 
                       (board[row][nextCol].isEmpty())) {
                    board[row][nextCol].setNumber(num);
                    board[row][cellCol].setNumber(0);
                    
                    cellCol++;
                    nextCol++;
                }
                
                if (cellCol < 3) {
                    //merge
                    int oneNum = board[row][cellCol].getNumber();
                    int twoNum = board[row][nextCol].getNumber();
                    
                    if (oneNum == twoNum) { 
                        board[row][nextCol].setNumber(2 * oneNum);
                        board[row][cellCol].setNumber(0);
                    }
                }
                
            }
        }
    }
    
    /*
     * Description: this function merges two cells left with the same number
     *              if they are neighbors
     */
    public void mergeLeft() {
        for (int row = 0; row < 4; row++) {
            for (int col = 3; col > 0; col--) {
                //slide
                int cellCol = col;
                int nextCol = col - 1;
                int num = board[row][cellCol].getNumber();
                while ((!board[row][cellCol].isEmpty()) && (cellCol > 0) &&
                       (board[row][nextCol].isEmpty())) {
                    board[row][nextCol].setNumber(board[row][cellCol].getNumber());
                    board[row][cellCol].setNumber(0);
                    
                    cellCol--;
                    nextCol--;
                }
                
                if (cellCol > 0) {
                    //merge
                    int oneNum = board[row][cellCol].getNumber();
                    int twoNum = board[row][nextCol].getNumber();
                    
                    if (oneNum == twoNum) {
                        board[row][nextCol].setNumber(2 * oneNum);
                        board[row][cellCol].setNumber(0);
                    }
                }
                
            }
        }
    }
    
    /*
     * Description: this function checks whether the number is 2048 or not
     * Output: boolean true/false based on condition
     */
    public boolean check() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col].getNumber() == 2048) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
     * Description: this function checks whether there are any
     *              possible moves left (any cell's number is the same
     *              as one of its neighbors)
     * Output: boolean true/false based on condition
     */
    public boolean stop() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int cellNum = board[row][col].getNumber();
                if (board[row][col].isEmpty()) {
                    return false;
                } else if (col != 0) {
                    if (cellNum == board[row][col - 1].getNumber()) {
                        return false;
                    }
                } else if (col != 3) {
                    if (cellNum == board[row][col + 1].getNumber()) {
                        return false;
                    }
                } else if (row != 0) {
                    if (cellNum == board[row - 1][col].getNumber()) {
                        return false;
                    }
                } else if (row != 3) {
                    if (cellNum == board[row + 1][col].getNumber()) {
                        return false;
                    } 
                } else {
                    return true;
                }     
            }
        }
        return false; // dummy statement
    }
}