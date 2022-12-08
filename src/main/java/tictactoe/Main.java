package tictactoe;
import java.util.Scanner;

import static tictactoe.Game.*;

public class Main {
    
    public static void main(String[] args){
        System.out.println("Welcome to TicTacToe.\nTo begin, enter a coordinate corresponding the game board. As an example, B2 would be the center.");
        printBoard();
        Scanner s = new Scanner(System.in);
    
        String in;
        while (winner == null) {
            in = s.nextLine();
            in = capitalize(in);
            
            if (!checkFormat(in)) {
                continue;
            }
            boolean format = checkFormat(in);
            boolean placement = checkPlacement(in);
            
            if (format && placement) {
                updateBoard(in);
                if (checkWinner()) {
                    printWinner();
                }
                printBoard();
            }
        }
        
        s.close(); //Good practise to prevent data-leaks
    }
}
