import java.util.Scanner;

public class SolutionTopDown {

  // Stores all possible alternatives to climb stairs from 0 to the input number.
  private static int[] waysToClimbStairs;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfStairs = scanner.nextInt();
    scanner.close();

    waysToClimbStairs = new int[numberOfStairs + 1];
    int result_topDown_approach = calculate_topDown_waysToClimbStairs(numberOfStairs);
    System.out.println("result_topDown_approach: " + result_topDown_approach);
  }

  /**
   * Calculate ways to climb a certain amount of stairs, 
   * based on taking 1 or 2 stairs at a step.
   *
   * This method applies a top-down approach of dynamic programming,
   * also known as memoization (not to be confused with 'memorization').
   *
   * @return An integer, representing all alternatives to climb the stiars, as described.
   */
  private static int calculate_topDown_waysToClimbStairs(int numberOfStairs) {
    if (numberOfStairs <= 1) {
      waysToClimbStairs[numberOfStairs] = 1;
    } else {
      waysToClimbStairs[numberOfStairs] =
          calculate_topDown_waysToClimbStairs(numberOfStairs - 1)
              + calculate_topDown_waysToClimbStairs(numberOfStairs - 2);
    }
    return waysToClimbStairs[numberOfStairs];
  }
}
