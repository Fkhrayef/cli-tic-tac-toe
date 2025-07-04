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

}