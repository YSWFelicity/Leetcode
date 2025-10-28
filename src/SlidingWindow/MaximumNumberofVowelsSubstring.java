package SlidingWindow;

/**
 * Problem 1456: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 *
 */
public class MaximumNumberofVowelsSubstring {
  public int maxVowels(String s, int k) {
    int slow = 0;
    int res = 0;
    int count = 0;
    for(int fast = 0; fast < s.length(); fast++){
      if(isVowel(s.charAt(fast))){
        count++;
      }

      if(fast - slow + 1 == k){
        res = Math.max(res, count);
        if(isVowel(s.charAt(slow))){
          count--;
        }
        slow++;
      }
    }
    return res;
  }

  private boolean isVowel(char c){
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  public static void main(String[] args) {
    MaximumNumberofVowelsSubstring solver = new MaximumNumberofVowelsSubstring();
    System.out.println(solver.maxVowels("abciiidef", 3));
    System.out.println(solver.maxVowels("aeiou", 2));
    System.out.println(solver.maxVowels("leetcode", 3));
    System.out.println(solver.maxVowels("bhythms", 4));
  }
}
