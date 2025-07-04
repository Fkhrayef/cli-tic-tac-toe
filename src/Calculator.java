import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        ArrayList<Number> results = new ArrayList<>();

        while (running) {
            int choice;

            try {
                System.out.println("What process you want to apply?");
                printMenu();
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice!");
                sc.nextLine(); // <-- This clears the invalid input
                continue; // Skip rest of loop
            }

            int num1 = 0;
            int num2 = 0;

            if (choice != 0 && choice != 9 && choice != 10) {
                try {
                    System.out.println("Enter 1st number: ");
                    num1 = sc.nextInt();

                    System.out.println("Enter 2nd number: ");
                    num2 = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input!");
                    sc.nextLine(); // <-- This clears the invalid input
                    continue; // Skip rest of loop
                }
            }
            try {
                switch (choice) {
                    case 0:
                        System.out.println("Program terminated.");
                        running = false;
                        break;
                    case 1:
                        int sumResult = num1 + num2;
                        results.add(sumResult);
                        System.out.println(num1 + " + " + num2 + " = " + (sumResult));
                        break;
                    case 2:
                        int subResult = num1 - num2;
                        results.add(subResult);
                        System.out.println(num1 + " - " + num2 + " = " + subResult);
                        break;
                    case 3:
                        int mulResult = num1 * num2;
                        results.add(mulResult);
                        System.out.println(num1 + " * " + num2 + " = " + mulResult);
                        break;
                    case 4:
                        double divResult = findDivision(num1, num2);
                        results.add(divResult);
                        System.out.println(num1 + " / " + num2 + " = " + divResult);
                        break;
                    case 5:
                        int modResult = num1 % num2;
                        results.add(modResult);
                        System.out.println(num1 + " % " + num2 + " = " + (modResult));
                        break;
                    case 6:
                        int minResult = findMinimum(num1, num2);
                        results.add(minResult);
                        System.out.println("Minimum number is " + minResult);
                        break;
                    case 7:
                        int maxResult = findMaximum(num1, num2);
                        results.add(maxResult);
                        System.out.println("Maximum number is " + maxResult);
                        break;
                    case 8:
                        double avgResult = findAvg(num1, num2);
                        results.add(avgResult);
                        System.out.println("Average = " + avgResult);
                        break;
                    case 9:
                        if (!results.isEmpty()) {
                            System.out.println("Last result is: " + results.getLast());
                        } else {
                            System.out.println("No results yet.");
                        }
                        break;
                    case 10:
                        System.out.println("All previous results: " + results);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    public static void printMenu() {
        System.out.println("0: to quit\n" +
                "1: to addition the numbers\n" +
                "2: to subtraction the numbers\n" +
                "3: to multiplication the numbers\n" +
                "4: to division the numbers\n" +
                "5: to modulus the numbers\n" +
                "6: to find minimum number\n" +
                "7: to find maximum number\n" +
                "8: to find the average of numbers\n" +
                "9: to print the last result in calculator\n" +
                "10: to print the list of all results in calculator");
    }

    public static double findDivision(int num1, int num2) {
        return (double) num1 / num2;
    }

    public static int findMinimum(int num1, int num2) {
        int min = num1;
        if (num2 < min) {
            min = num2;
        }
        return min;
    }

    public static int findMaximum(int num1, int num2) {
        int max = num1;
        if (num2 > max) {
            max = num2;
        }
        return max;
    }

    public static double findAvg(int num1, int num2) {
        return (double) (num1 + num2) / 2;
    }
}