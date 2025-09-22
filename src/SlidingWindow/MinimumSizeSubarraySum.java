package SlidingWindow;

/**
 * Problem 209: https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 */
public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    int sum = 0;
    int res = Integer.MAX_VALUE;
    int left = 0;
    for(int i = 0; i < nums.length; i++){
      sum += nums[i];
      while(sum >= target){
        res = Math.min(res, i - left + 1);
        sum -= nums[left];
        left++;
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }

  public static void main(String[] args) {
    MinimumSizeSubarraySum solver = new MinimumSizeSubarraySum();

    // 1) 基本用例
    System.out.println(solver.minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 期望: 2 ([4,3])

    // 2) 无解情况
    System.out.println(solver.minSubArrayLen(100, new int[]{1,2,3,4,5})); // 期望: 0

    // 3) 只有一个元素就满足
    System.out.println(solver.minSubArrayLen(4, new int[]{1,4,4})); // 期望: 1 ([4])

    // 4) 整个数组才能满足
    System.out.println(solver.minSubArrayLen(15, new int[]{1,2,3,4,5})); // 期望: 5 ([1,2,3,4,5])

    // 5) 多个候选，取最短的
    System.out.println(solver.minSubArrayLen(11, new int[]{1,2,3,4,5})); // 期望: 3 ([3,4,5])
  }
}
