package HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < nums.length; i++){
      int x = target - nums[i];
      if(map.containsKey(x)){
        return new int[]{i, map.get(x)};
      }else{
        map.put(nums[i], i);
      }
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    TwoSum solver = new TwoSum();

    // 1) 基本用例
    int[] result1 = solver.twoSum(new int[]{2, 7, 11, 15}, 9);
    System.out.println(Arrays.toString(result1)); // 期望: [1, 0] 或 [0, 1] (取决于实现顺序)

    // 2) 有多个解，返回第一个找到的
    int[] result2 = solver.twoSum(new int[]{3, 2, 4}, 6);
    System.out.println(Arrays.toString(result2)); // 期望: [2, 1] 或 [1, 2]

    // 3) 无解情况
    int[] result3 = solver.twoSum(new int[]{1, 2, 3}, 100);
    System.out.println(Arrays.toString(result3)); // 期望: []
  }
}
