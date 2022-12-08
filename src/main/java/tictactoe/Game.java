package tictactoe;

import java.util.Objects;

public class Game {
    static String[][] board =
            {{"-", "-", "-"},
             {"-", "-", "-"},
             {"-", "-", "-"}};
    static int turnCount = 0;
    static boolean correctFormat = false;
    static boolean correctPlacement = false;
    static String turn = "X";
    static boolean draw = false;
    static String winner = null;
    
    
    static String capitalize(String input) {
        return input.toUpperCase();
    }
    
    static boolean checkFormat(String userInput) {
        char[] chArray = userInput.toCharArray();
        
        if (chArray.length == 2 && chArray[0] >= 65 && chArray[0] <= 67 && chArray[1] >= 49 && chArray[1] <= 51) {
            correctFormat = true;
        }
        
        if (!correctFormat) {
            System.out.println("Sorry, wrong format. Try again!");
        }
        
        return correctFormat;
    }
    
    static boolean checkPlacement(String userInput) {
        switch (userInput) {
            case "A1" -> correctPlacement = !Objects.equals(board[0][0], "X") && !Objects.equals(board[0][0], "O");
            case "A2" -> correctPlacement = !Objects.equals(board[0][1], "X") && !Objects.equals(board[0][1], "O");
            case "A3" -> correctPlacement = !Objects.equals(board[0][2], "X") && !Objects.equals(board[0][2], "O");
            case "B1" -> correctPlacement = !Objects.equals(board[1][0], "X") && !Objects.equals(board[1][0], "O");
            case "B2" -> correctPlacement = !Objects.equals(board[1][1], "X") && !Objects.equals(board[1][1], "O");
            case "B3" -> correctPlacement = !Objects.equals(board[1][2], "X") && !Objects.equals(board[1][2], "O");
            case "C1" -> correctPlacement = !Objects.equals(board[2][0], "X") && !Objects.equals(board[2][0], "O");
            case "C2" -> correctPlacement = !Objects.equals(board[2][1], "X") && !Objects.equals(board[2][1], "O");
            case "C3" -> correctPlacement = !Objects.equals(board[2][2], "X") && !Objects.equals(board[2][2], "O");
        }
        
        if (!correctPlacement) {
            System.out.println("Sorry, wrong placement. Try again!");
        }
        return correctPlacement;
    }
    
    static void updateBoard(String userInput) {
        switch (userInput) {
            case "A1" -> board[0][0] = turn;
            case "A2" -> board[0][1] = turn;
            case "A3" -> board[0][2] = turn;
            case "B1" -> board[1][0] = turn;
            case "B2" -> board[1][1] = turn;
            case "B3" -> board[1][2] = turn;
            case "C1" -> board[2][0] = turn;
            case "C2" -> board[2][1] = turn;
            case "C3" -> board[2][2] = turn;
        }
    }
    
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
    
        if (checkWinner()) {
            System.out.println("");
        } else if (correctFormat) {
            turnCount++;
            
            if (turnCount % 2 == 0) {
                turn = "X";
            } else {
                turn = "O";
            }
            System.out.println("\n" + turn + "'s turn:");
        } else {
            System.out.println("X will start:");
        }
        //Initialize checkers:
        correctFormat = false;
        correctPlacement = false;
    }
    
    static boolean checkWinner() {
        boolean hasWinner = false;
        String[] winningLines = {
                board[0][0] + board[0][1] + board[0][2],
                board[1][0] + board[1][1] + board[1][2],
                board[2][0] + board[2][1] + board[2][2],
                board[0][0] + board[1][0] + board[2][0],
                board[0][1] + board[1][1] + board[2][1],
                board[0][2] + board[1][2] + board[2][2],
                board[0][0] + board[1][1] + board[2][2],
                board[0][2] + board[1][1] + board[2][0]
        };
    
        for (String winningLine : winningLines) {
            if (winningLine.equals("XXX")) {
                winner = "X";
                hasWinner = true;
                break;
            } else if (winningLine.equals("OOO")) {
                winner = "O";
                hasWinner = true;
                break;
            }
        }
        
        if (turnCount > 7) {
            hasWinner = true;
            draw = true;
        }
        
        return hasWinner;
    }
    
    static void printWinner() {
        //Return X eller O
        if (draw) {
            System.out.println("\nIt's a draw!");
        } else {
            System.out.println("\n" + winner + " has won the game!");
        }
    }
}