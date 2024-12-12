import java.util.ArrayList;
import java.util.Scanner;

// Program that multiplies five numbers together using recursion
public class RecursiveProduct {
  // Scanner object to read user input
  private static Scanner scanner = new Scanner(System.in);

  // Multiplies all numbers in the list starting from currentPosition
  public static double multiplyNumbersRecursively(ArrayList<Double> numbers, int currentPosition) {
    // Base case: return 1 when we've multiplied all numbers
    if (currentPosition == numbers.size()) {
      return 1.0;
    }

    // Get current number and multiply it with product of remaining numbers
    double currentNumber = numbers.get(currentPosition);
    double remainingProduct = multiplyNumbersRecursively(numbers, currentPosition + 1);
    return currentNumber * remainingProduct;
  }

  // Gets a valid number from the user, keeps trying if input is invalid
  public static double getValidNumberFromUser(int numberPosition) {
    while (true) {
      try {
        System.out.print("Enter number #" + (numberPosition + 1) + ": ");
        return scanner.nextDouble();
      } catch (Exception e) {
        // Clear invalid input and ask user to try again
        System.out.println("Oops! That's not a valid number. Please try again.");
        scanner.nextLine();
      }
    }
  }

  // Main program starts here
  public static void main(String[] args) {
    // Store our numbers in an ArrayList
    ArrayList<Double> numbers = new ArrayList<>();

    // Show welcome message
    System.out.println("Welcome! Enter five numbers and I'll multiply them together.\n");

    // Get five numbers from user
    for (int i = 0; i < 5; i++) {
      numbers.add(getValidNumberFromUser(i));
    }

    // Calculate final result using recursion
    double result = multiplyNumbersRecursively(numbers, 0);

    // Show the numbers entered and their product
    System.out.println("\nYour numbers: " + numbers);
    System.out.println("Final result: " + result);

    // Display the calculation in equation format
    System.out.print("\nCalculation: ");
    for (int i = 0; i < numbers.size(); i++) {
      System.out.print(numbers.get(i));
      System.out.print(i < numbers.size() - 1 ? " * " : " = ");
    }
    System.out.println(result);

    // Clean up by closing the scanner
    scanner.close();
  }
}