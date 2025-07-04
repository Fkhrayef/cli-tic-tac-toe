import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                        "┌──────────────────────────────┐\n" +
                        "│                              │\n" +
                        "│  Welcome to CLI-Tic-Tac-Toe  │\n" +
                        "│    Java Bootcamp Project1    │\n" +
                        "│      Made by Fkhrayef        │\n" +
                        "│                              │\n" +
                        "└──────────────────────────────┘\n");

        char[][] board = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        printBoard(board);
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" │ ");
            }
            System.out.println();
            if (i < 2) System.out.println("───┼───┼───");
        }
        System.out.println();
    }

}