/* Name: Aida M. Akuyeva
 * Pennkey: aakuyeva
 * Recitation: 201
 * 
 * Execution: java TwentyFourtyEight
 * 
 * This program draws the board and each cell
 * 
 */
public class Draw {
    /*
     * Description: this function draws the cell with a certain number,
     *              where the color is based on a number
     */
    public static void draw(int row, int col, int number) {
        if (number % 2 == 0) {
            if ((number >= 2) && (number <= 8)) {
                PennDraw.setPenColor(number * 30, number * 10, number * 25);
            } else if ((number > 8) && (number <= 64)) {
                PennDraw.setPenColor(number * 3, number * 3, number * 4 - 30);
            } else if ((number >= 128) && (number <= 512)) {
                PennDraw.setPenColor(number / 2 - 10, number / 3, 
                                     number / 2 - 20);
            } else if ((number >= 1024) && (number <= 2048)) {
                PennDraw.setPenColor(number / 20, number / 15, number / 20);
            }
        }
        
        //map row and col to coordinates
        double py = -0.2 * row + 0.8;
        double px = 0.2 * col + 0.2;
        
        PennDraw.filledSquare(px, py, 0.1);
        PennDraw.setPenColor(255, 255, 255);
        PennDraw.text(px, py, number + "");
    }
    
    /*
     * Description: this function draws the board
     */
    public static void drawBoard(Cell[][] board) {
        PennDraw.clear();
        PennDraw.setPenColor();
        for (double i = 0.2; i <= 0.8; i += 0.2) {
            for (double j = 0.2; j <= 0.8; j += 0.2) {
                PennDraw.square(i, j, 0.1);
            }
        }
        
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Cell cell = board[row][col];
                if (!(cell.isEmpty())) {
                    draw(row, col, cell.getNumber());
                }
            }
            
        }
    }
}