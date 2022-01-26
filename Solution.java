import java.util.Scanner;

/**
 * @author Nikki McIntyre
 *         Takes in an array and an int and returns the index of the first 2
 *         values in the array to add to the provided integer
 */
class Solution {
  public static void main(String[] args) {
    // obtain values
    Scanner kbd = new Scanner(System.in);
    System.out.println("enter the values in the array to sort through and find the target seperated by a space");
    String input = kbd.nextLine();
    // make an array split on the white space
    String[] inputArr = input.split("\\s");
    // put the values into an int array
    int[] nums = new int[inputArr.length];
    for (int i = 0; i < inputArr.length; i++) {
      try {
        nums[i] = Integer.parseInt(inputArr[i]);
      } catch (Exception e) {
        // break if entered a non int
        System.out.println("Please only enter numbers");
        System.exit(0);
      }
    }
    System.out.println("Please enter the target number");
    int target = 0;
    try {
      target = kbd.nextInt();
    }
    // break if entered a non int
    catch (Exception e) {
      System.out.println("Please only enter an integer");
    }
    kbd.close();
    // take and write the answer
    int[] answer = twoSum(nums, target);
    for (int i = 0; i < answer.length; i++) {
      System.out.print(answer[i] + " ");
    }
  }

  /**
   * 
   * @param nums   the array to see if you can find the values added to the targer
   * @param target the target to add to
   * @return the array indexs of the first 2 numbers to add to the array, if there
   *         is no solution it'll say so then return the full array inputted
   */
  public static int[] twoSum(int[] nums, int target) {
    //The target to try to add to
    int currentTarget = target;
    //Will cycle through every int and then iterated again through every int until finding an answer
    for (int i = 0; i < nums.length; i++) {
      //Take the current target and subtract the current value I.E. if the target is 7 and nums[i] is 4 then it's 7 - 4 = 3 so the next loop looks for a 3 
      currentTarget = target - nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        if (currentTarget - nums[j] == 0) {
          int[] ans = { i, j };
          return ans;
        }
      }
      currentTarget = target;
    }
    //if going through the entire array with no solutions then it must not have a soulution at all
    System.out.println("There was no answers, here's your initial array back");
    return nums;
  }
}