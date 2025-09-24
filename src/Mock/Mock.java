package Mock; /**
 * 
 * i, j, k 
 * l + r > -nums[i] r--
 * l + r < -nums[i] l++
 * l + r + nums[i] = 0
 * l + r = -nums[i]
 *                    0,l          r
 * example1: nums = [-1,0,1,2,-1,-4] -> output: [-1, 0, 1], [-1, -1, 2] -> Output: [[-1,-1,2],[-1,0,1]]
 * [-4, -1, -1, 0, 1, 2]
 * index 2 compare it to index 1 
 * [-1, -1, ]
 * index 1 compare it to index 0 
 * first round: 
 * i = 0, l = 1, r = 5
 * -4 + (-1) + 2 = -3 < 0
 * -4 + 0 + 2 = -2 < 0
 * -4 + 1 + 2 = -1 < 0
 * 
 * second round: 
 * i = 1, l = 2, r = 5
 * -1 + 0 + 2 = 1 > 0 -> r = 4
 * -1 + 0 + 1 = 0 -> add to the res 
 * 
 * example2: [0, 1, 1] 0 + 1 + 1 -> output: []
 * example: nums[0, 0, 0] -> output: [[0,0,0]]
 * 

 skip i, l, r

 Time: O(N^2) 
 Space: O(1)
 */

import java.util.*;
//Leetcode 15: 3 Sum
public class Mock {

    public static List<List<Integer>> tripletSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //edge cases
        if(nums == null || nums.length < 3){
            return res;
        }

        //sort 
        Arrays.sort(nums); //O(nlogn)
        for(int i = 0; i < nums.length - 2; i++){ //O(n)
            //skip i 
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }            

            
            int target = -nums[i];
            int l = i+1, r = nums.length - 1;
            while(l < r){ //O(n)
                int sum = nums[l] + nums[r];
                if(sum == target){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    int leftVal = nums[l], rightVal = nums[r];
                    while(l < r && nums[l] == leftVal){
                        //skip l 
                        l++;
                    }
                    while(l < r && nums[r] == rightVal){
                        //skip r
                        r--;
                    }
                    
                }else if(sum < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
        
    }

    public static void main(String[] args) {
        System.out.println(tripletSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(tripletSum(new int[]{0, 0, 0}));
        System.out.println(tripletSum(new int[]{0, 1, 1}));
    }
}
