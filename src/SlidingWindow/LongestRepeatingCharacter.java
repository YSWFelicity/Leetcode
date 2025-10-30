package SlidingWindow;

/**
 *
 * Leetcode 424: https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacter {

  public int characterReplacement(String s, int k){
    int n = s.length();
    int[] count = new int[26];

    int left = 0;
    int maxCount = 0;
    int res = 0;
    for(int i = 0; i < n; i++){
      char inChar = s.charAt(i);
      count[inChar - 'A']++;

      if(count[inChar - 'A'] > maxCount){
        maxCount = count[inChar - 'A'];
      }

      if((i - left + 1) - maxCount > k){
        char outChar = s.charAt(left);
        count[outChar - 'A']--;
        left++;
      }

      if((i - left + 1) > res){
        res = i - left + 1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    LongestRepeatingCharacter solver = new LongestRepeatingCharacter();
    System.out.println(solver.characterReplacement("ABAB", 2));
    System.out.println(solver.characterReplacement("AABABBA", 1));
  }

}
