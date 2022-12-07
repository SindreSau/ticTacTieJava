package tictactoe;
import java.util.Scanner;

import static tictactoe.Game.*;

public class Main {
    
    public static void main(String[] args){
        System.out.println("Welcome to TicTacToe.\nTo begin, enter a coordinate corresponding the game board. As an example, B2 would be the center.");
        getInts();
        printBoard();
        Scanner s = new Scanner(System.in);
    
        String in = null;
        while (true) { //will be set to winner-boolean
            try {
                in = s.nextLine();
                if (isCorrectInput(in)) {
                    setPiece(in);
                } else {
                    System.out.println("Wrong format or placement, try again:");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Exception??");
                continue;
            }
            incTurncount();
            printBoard();
        }
        /*s.close();*/
    }
}
