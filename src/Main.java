import java.util.*;

public class Main {
    // Color for Pretty prints
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(GREEN +
                """
                ╔════════════════════════════════════╗
                ║                                    ║
                ║          CLI Tic-Tac-Toe           ║
                ║     Java Bootcamp – Project 1      ║
                ║         Made by Fkhrayef           ║
                ║                                    ║
                ╚════════════════════════════════════╝
                """ + RESET);

        int bestOf;
        while (true) {
            try {
                System.out.println("🕹️ Best of 1 or 3?");
                bestOf = sc.nextInt();
                if (bestOf != 1 && bestOf != 3) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, enter 1 or 3");
                sc.nextLine();
                continue;
            }
            break;
        }

        int playerWon = 0;
        int computerWon = 0;

        for (int i = 1; i <= bestOf; i++) {
            char[][] board = {
                    {'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'}
            };

            // 2D Array holding winner pattern
            boolean[][] highlight = new boolean[3][3];

            System.out.println("\n🎲 Round " + i + " / " + bestOf + " 🎲");

            // print initial board
            printBoard(board, highlight, ' ');

            while (true) {

                int isDone;

                // Player Turn
                // input
                System.out.println("👤 Your Turn (X): Pick a number → ");
                String input = sc.next();
                char choice = '\0';
                if (input.length() == 1) {
                    choice = input.charAt(0);
                }
                // play
                try {
                    playChoice(board, choice, 'X');
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                // Check if the game is done
                isDone = checkIsDone(board, 'X', highlight);
                if (isDone == 1) {
                    printBoard(board, highlight, 'X');
                    System.out.println(GREEN + "Player Wins Game " + i + " of " + bestOf + "!" + RESET);
                    playerWon++;
                    break;
                }
                if (isDone == 2) {
                    printBoard(board, highlight, ' ');
                    System.out.println("Draw!");
                    break;
                }


                // Computer turn
                // play
                try {
                    char computerChoice = randomChoice(board);
                    System.out.println("🤖 Computer's Turn → " + computerChoice);
                    playChoice(board, computerChoice, 'O');
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                // Check if the game is done
                isDone = checkIsDone(board, 'O', highlight);
                if (isDone == 1) {
                    printBoard(board, highlight, 'O');
                    System.out.println(RED + "Computer Wins Game " + i + " of " + bestOf + "!" + RESET);
                    computerWon++;
                    break;
                }
                if (isDone == 2) {
                    printBoard(board, highlight, ' ');
                    System.out.println("Draw!");
                    break;
                }

                printBoard(board, highlight, ' ');

            }

            if (playerWon == 2 || computerWon == 2) break;
        }

        System.out.println("\n🏁 Final Score: 👤 Player " + playerWon + " - " + computerWon + " Computer 🤖");
        if (playerWon > computerWon) {
            System.out.println("🎉 " + GREEN + "You won the match!" + RESET);
        } else if (computerWon > playerWon) {
            System.out.println("💻 " + RED + "Computer wins the match!" + RESET);
        } else {
            System.out.println("🤝 It's a tie overall!");
        }


    }

    public static void printBoard(char[][] board, boolean[][] highlight, char winner) {

        String color = (winner == 'X') ? GREEN : RED;

        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < board[i].length; j++) {
                if (highlight[i][j]) {
                    System.out.print(color + board[i][j] + RESET);
                } else if (board[i][j] == 'X' || board[i][j] == 'O') {
                    System.out.print(BOLD + board[i][j] + RESET);
                } else {
                    System.out.print(board[i][j]);
                }

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

    public static int checkIsDone(char[][] board, char turn, boolean[][] highlight) {
        // return 0: game is not done
        // return 1: game is won
        // return 2: game is draw

        // First Row Win Case
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == turn && board[i][1] == turn && board[i][2] == turn) {
                highlight[i][0] = highlight[i][1] = highlight[i][2] = true;
                return 1;
            }
        }

        // Check Column Win Case
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == turn && board[1][i] == turn && board[2][i] == turn) {
                highlight[0][i] = highlight[1][i] = highlight[2][i] = true;
                return 1;
            }
        }

        // Check Diagonal Win Case
        // First Diagonal
        if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) {
            highlight[0][0] = highlight[1][1] = highlight[2][2] = true;
            return 1;
        }
        // Second Diagonal
        if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn) {
            highlight[0][2] = highlight[1][1] = highlight[2][0] = true;
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