import java.util.Scanner;

public class SolutionBottomUp {

  // Stores all possible alternatives to climb stairs from 0 to the input number.
  private static int[] waysToClimbStairs;
  
  // BASE_CASE_ONE and BASE_CASE_TWO represent number of stairs allowed to be taken at one step.
  private static final int BASE_CASE_ONE = 1;
  private static final int BASE_CASE_TWO = 2;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfStairs = scanner.nextInt();
    scanner.close();

    int result_bottomUp_approach = calculate_bottomUp_waysToClimbStairs(numberOfStairs);
    System.out.println("result_bottomUp_approach: " + result_bottomUp_approach);
  }

  /**
   * Calculate ways to climb certain amount of stairs, 
   * based on taking 1 or 2 stairs at a step.
   *
   * This method applies a bottom-up approach of dynamic programming, 
   * also known as tabulization,
   *
   * @return An integer, representing all alternatives to climb the stiars, as described.
   */
  public static int calculate_bottomUp_waysToClimbStairs(int numberOfStairs) {
    if (numberOfStairs <= 1) {
      return 1;
    }

    waysToClimbStairs = new int[numberOfStairs + 1];
    waysToClimbStairs[0] = 1;
    waysToClimbStairs[BASE_CASE_ONE] = 1;
    waysToClimbStairs[BASE_CASE_TWO] = 2;

    for (int i = 3; i <= numberOfStairs; i++) {
      waysToClimbStairs[i] = waysToClimbStairs[i - 1] + waysToClimbStairs[i - 2];
    }

    return waysToClimbStairs[numberOfStairs];
  }
}
