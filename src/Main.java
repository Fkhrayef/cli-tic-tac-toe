import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
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

        while (true) {
            int isDone = 0;

            // Player Turn
            System.out.println("Pick a number to play in: ");
            String input = sc.next();
            char choice = '\0';
            if (input.length() == 1) {
                choice = input.charAt(0);
            }
            try {
                playChoice(board, choice, 'X');
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            // Check if the game is done
            isDone = checkIsDone(board, 'X');
            if (isDone == 1) {
                printBoard(board);
                System.out.println("Player Wins!");
                break;
            }
            if (isDone == 2) {
                printBoard(board);
                System.out.println("Draw!");
                break;
            }


            // Computer turn
            try {
                char computerChoice = randomChoice(board);
                playChoice(board, computerChoice, 'O');
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
            // Check if the game is done
            isDone = checkIsDone(board, 'O');
            if (isDone == 1) {
                printBoard(board);
                System.out.println("Computer Wins!");
                break;
            }
            if (isDone == 2) {
                printBoard(board);
                System.out.println("Draw!");
                break;
            }

            printBoard(board);

        }
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

    public static void playChoice(char[][] board, char choice, char turn) throws InputMismatchException {
        switch (choice) {
            case '1':
                if (board[0][0] == '1') {
                    board[0][0] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            case '2':
                if (board[0][1] == '2') {
                    board[0][1] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            case '3':
                if (board[0][2] == '3') {
                    board[0][2] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            case '4':
                if (board[1][0] == '4') {
                    board[1][0] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            case '5':
                if (board[1][1] == '5') {
                    board[1][1] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            case '6':
                if (board[1][2] == '6') {
                    board[1][2] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            case '7':
                if (board[2][0] == '7') {
                    board[2][0] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            case '8':
                if (board[2][1] == '8') {
                    board[2][1] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            case '9':
                if (board[2][2] == '9') {
                    board[2][2] = turn;
                } else {
                    throw new InputMismatchException("Already played!");
                }
                break;
            default:
                throw new InputMismatchException("Invalid choice!");
        }
    }

    public static char randomChoice(char[][] board) throws ArrayIndexOutOfBoundsException {
        Random random = new Random();

        ArrayList<Character> availableChoices = new ArrayList<>();

        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar != 'X' && aChar != 'O') {
                    availableChoices.add(aChar);
                }
            }
        }
        if (availableChoices.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int randomIndex = random.nextInt(availableChoices.size());
        return availableChoices.get(randomIndex);
    }

    public static int checkIsDone(char[][] board, char turn) {
        // return 0: game is not done
        // return 1: game is won
        // return 2: game is draw

        // First Row Win Case
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == turn && board[i][1] == turn && board[i][2] == turn) {
                return 1;
            }
        }

        // Check Column Win Case
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == turn && board[1][i] == turn && board[2][i] == turn) {
                return 1;
            }
        }

        // Check Diagonal Win Case
        // First Diagonal
        if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) {
            return 1;
        }
        // Second Diagonal
        if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn) {
            return 1;
        }

        // Ongoing Case
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar >= '1' && aChar <= '9') {
                    return 0;
                }
            }
        }

        // Draw
        return 2;
    }
}