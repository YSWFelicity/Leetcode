package SlidingWindow;

/**
 * Leetcode 3: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    int[] count = new int[128];

    int res = 0;
    int left = 0;

    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      count[c]++;

      while(count[c] > 1){
        char leftChar = s.charAt(left);
        count[leftChar]--;
        left++;
      }
      res = Math.max(res, i - left + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();
    System.out.println(solver.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(solver.lengthOfLongestSubstring("bbbbb"));
    System.out.println(solver.lengthOfLongestSubstring("pwwkew"));
  }
}
