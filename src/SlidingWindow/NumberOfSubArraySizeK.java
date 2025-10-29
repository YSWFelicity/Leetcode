package SlidingWindow;

/**
 * Leetcode 1343: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
 */

public class NumberOfSubArraySizeK {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    if(arr == null || arr.length == 0 || k <= 0 || arr.length < k){
      return 0;
    }

    int count = 0;
    int left = 0;
    long sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];

      if(i - left + 1 == k){
        if(sum / k >= threshold){
          count++;
        }
        sum -= arr[left];
        left++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    NumberOfSubArraySizeK solver = new NumberOfSubArraySizeK();
    System.out.println(solver.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
    System.out.println(solver.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5));
  }
}
