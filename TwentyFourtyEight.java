/* Name: Aida M. Akuyeva
 * Pennkey: aakuyeva
 * Recitation: 201
 * 
 * Execution: java TwentyFourtyEight
 * 
 * This program simulates a 2048 game by creating a board object, 
 * randomly generating a new cell in it, and moving/merging if
 * a certain key is pressed.
 * 
 */
public class TwentyFourtyEight {
    
    public static void main(String[] args) {
        Board gameBoard = new Board();
        gameBoard.random();
        Draw.drawBoard(gameBoard.getCellArray());
        //keeps track of number of moves
        int count = 0;
        
        while (true) {
            if (PennDraw.hasNextKeyTyped()) {
                char var = PennDraw.nextKeyTyped();
                if (var == 'a' || var == 'A') {
                    count++;
                    gameBoard.mergeLeft();
                    gameBoard.random();
                    Draw.drawBoard(gameBoard.getCellArray());
                } else if (var == 'd' || var == 'D') {
                    count++;
                    gameBoard.mergeRight();
                    gameBoard.random();
                    Draw.drawBoard(gameBoard.getCellArray());
                } else if (var == 'w' || var == 'W') {
                    count++;
                    gameBoard.mergeUp();
                    gameBoard.random();
                    Draw.drawBoard(gameBoard.getCellArray());
                } else if (var == 's' || var == 'S') {
                    count++;
                    gameBoard.mergeDown();
                    gameBoard.random();
                    Draw.drawBoard(gameBoard.getCellArray());
                }
                
                PennDraw.setPenColor();
                PennDraw.text(0.7, 0.05, "Moves:" + count);
                
                //end of the game result
                if (gameBoard.check()) {
                    PennDraw.text(0.7, 0.95, "You won");
                    break;
                }
                if (gameBoard.stop()) {
                    PennDraw.text(0.7, 0.95, "You lost");
                    break;
                }
            }
        }
        
    }
}