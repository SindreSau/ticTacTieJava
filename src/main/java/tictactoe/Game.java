package tictactoe;

import java.util.Arrays;

public class Game {
    static String[][] board =
            {{"-", "-", "-"},
             {"-", "-", "-"},
             {"-", "-", "-"}};
    static int turnCount = 0;
    static boolean isCorrectFormat;
    static String turn;
    static String winner = "X";
    static int[] ints = {0,0};
    
    static void printBoard() {
        String[] letters = {"A ", "B ", "C "};
        System.out.println("   1   2   3");
        for (int i = 0; i < board.length; i++) {
            System.out.print(letters[i] + " ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        
        if (turnCount % 2 == 0) {
            turn = "X";
        } else {
            turn = "O";
        }
        
        System.out.println("\n" + turn + "'s turn:");
    }
    
    static void incTurncount() {
        if (isCorrectFormat) {
            turnCount++;
        }
    }
    
    static boolean isCorrectInput(String userInput) {
        userInput = userInput.toUpperCase();
        char[] chArray = userInput.toCharArray();
        
        if (isCorrectPlace() && chArray.length == 2 && chArray[0] >= 65 && chArray[0] <= 67 && chArray[1] >= 49 && chArray[1] <= 51) {
            isCorrectFormat = true;
            return true;
        } else {
            isCorrectFormat = false;
            return false;
        }
    }
    
    static boolean isCorrectPlace() {
        boolean correctPlacement = false;
        
        return correctPlacement;
    }
    
    static void setPiece(String userInput) {
        userInput = userInput.toUpperCase();
        switch (userInput) {
            case "A1":
                board[0][0] = turn;
                ints = new int[]{0, 0};
                break;
            case "A2":
                board[0][1] = turn;
                ints = new int[]{0, 1};
                break;
            case "A3":
                board[0][2] = turn;
                break;
            case "B1":
                board[1][0] = turn;
                break;
            case "B2":
                board[1][1] = turn;
                ints = new int[]{1, 1};
                break;
            case "B3":
                board[1][2] = turn;
                break;
            case "C1":
                board[2][0] = turn;
                break;
            case "C2":
                board[2][1] = turn;
                break;
            case "C3":
                board[2][2] = turn;
                break;
        }
    }
    
    static void getInts() {
        System.out.println(Arrays.toString(ints));
    }
    
    static boolean checkWinner() {
        
        return false;
    }
    
    static String winner() {
        //Return X eller O
        return winner;
    }
}