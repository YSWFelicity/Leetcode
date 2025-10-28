package SlidingWindow;

/**
 *
 * Leetcode 643:https://leetcode.com/problems/maximum-average-subarray-i/description/
 */

public class MaximumAverageSubarray {
  public double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    for(int i = 0; i < k; i++){
      sum += nums[i];
    }
    double res = sum / k;

    for(int i = k ; i < nums.length; i++){
      sum += nums[i];
      sum -= nums[i - k];

      res = Math.max(res, sum / k);
    }
    return res;
  }

  public static void main(String[] args) {
    MaximumAverageSubarray solver = new MaximumAverageSubarray();
    System.out.println(solver.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    System.out.println(solver.findMaxAverage(new int[]{5}, 1));
  }

}
