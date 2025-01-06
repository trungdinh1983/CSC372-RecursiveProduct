import java.util.ArrayList;
import java.util.Scanner;

// Just like a tree grows by repeating the same pattern at different scales,
// this program uses recursion to break down multiplication into smaller parts
public class RecursiveProduct {
  private static Scanner scanner = new Scanner(System.in);

  // Think of this like looking through nested folders on your computer:
  // Each level goes deeper until we reach the end
  public static double multiplyNumbersRecursively(ArrayList<Double> numbers, int currentPosition) {
    // Base case: Like reaching the bottom of a folder structure
    if (currentPosition == numbers.size()) {
      return 1.0;
    }

    // Similar to how a search engine explores web pages one link at a time,
    // we handle one number and let recursion handle the rest
    double currentNumber = numbers.get(currentPosition);

    // This is like a Russian nesting doll - each call opens a smaller version
    // of the same problem until we reach the smallest one
    double resultFromRemainingNumbers = multiplyNumbersRecursively(numbers, currentPosition + 1);

    // Combine current result with previous results, like building back up the
    // nesting dolls
    return currentNumber * resultFromRemainingNumbers;
  }

  // Demonstrates another way to use recursion - keep trying until we succeed
  public static double getValidNumberFromUser(int numberPosition, int attempts) {
    try {
      System.out.print("Enter number #" + (numberPosition + 1) + ": ");
      return scanner.nextDouble();
    } catch (Exception e) {
      // Like a GPS recalculating when you take a wrong turn
      System.out.println("Let's try again! Please enter a valid number.");
      scanner.nextLine(); // Clear invalid input
      // Recursively try again, like a GPS continuing to redirect
      return getValidNumberFromUser(numberPosition, attempts + 1);
    }
  }

  // This method shows how we can visualize the recursive process
  public static void displayRecursiveSteps(ArrayList<Double> numbers, int step) {
    String indent = "    ".repeat(step); // Visual indentation to show recursion depth
    System.out.println(indent + "Step " + step + ": Processing " +
        (step < numbers.size() ? numbers.get(step) : "final result"));
  }

  public static void main(String[] args) {
    ArrayList<Double> numbers = new ArrayList<>();

    System.out.println("Welcome to the Recursive Calculator!");
    System.out.println("Like a tree growing from a seed, we'll build our answer step by step.\n");

    // Collect numbers from user
    for (int i = 0; i < 5; i++) {
      numbers.add(getValidNumberFromUser(i, 1));
    }

    System.out.println("\nWatching recursion in action (like exploring branches of a tree):");

    // Show the recursive process visually
    for (int i = 0; i <= numbers.size(); i++) {
      displayRecursiveSteps(numbers, i);
    }

    // Calculate and show result
    double finalResult = multiplyNumbersRecursively(numbers, 0);

    System.out.println("\nYour numbers: " + numbers);
    System.out.println("Final result: " + finalResult);

    // Show calculation like expanding a mathematical expression
    System.out.print("\nFull calculation: ");
    for (int i = 0; i < numbers.size(); i++) {
      System.out.print(numbers.get(i));
      if (i < numbers.size() - 1) {
        System.out.print(" × "); // Using multiplication symbol for clarity
      }
    }
    System.out.println(" = " + finalResult);

    scanner.close();
  }
}