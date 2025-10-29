package SlidingWindow;

/**
 * Leetcode 567: https://leetcode.com/problems/permutation-in-string/description/
 */
public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    int lenS1 = s1.length();
    int lenS2 = s2.length();

    if(lenS2 < lenS1){
      return false;
    }

    int[] need = new int[26];
    int[] window = new int[26];
    for(int i = 0; i < lenS1; i++){
      char c = s1.charAt(i);
      need[c - 'a']++;
    }

    int left = 0, right = 0;
    while(right < lenS2){
      char inChar = s2.charAt(right);
      window[inChar - 'a']++;
      right++;

      if(right - left == lenS1){
        if(isSame(window, need)){
          return true;
        }

        char outChar = s2.charAt(left);
        window[outChar - 'a']--;
        left++;
      }
    }
    return false;
  }

  private boolean isSame(int[] a, int[] b){
    for(int i = 0; i < 26; i++){
      if(a[i] != b[i]){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    PermutationInString solver = new PermutationInString();
    System.out.println(solver.checkInclusion("ab", "eidbaooo"));
    System.out.println(solver.checkInclusion("ab", "eidboaoo"));
  }
}
