package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 438: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */

public class FindAllAnagramsInString {
  public List<Integer> findAnagrams(String s, String p){
    List<Integer> res = new ArrayList<>();

    int lenS = s.length();
    int lenP = p.length();

    if(lenS < lenP){
      return res;
    }

    int[] need = new int[26];
    int[] window = new int[26];
    for(int i = 0; i < lenP; i++){
      char c = p.charAt(i);
      need[c - 'a']++;
    }

    int left = 0, right = 0;
    while(right < lenS){
      char inChar = s.charAt(right);
      window[inChar - 'a']++;
      right++;

      if(right - left == lenP){
        if(isSame(window, need)){
          res.add(left);
        }

        char outChar = s.charAt(left);
        window[outChar - 'a']--;
        left++;
      }

    }

    return res;
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
    FindAllAnagramsInString solver = new FindAllAnagramsInString();
    System.out.println(solver.findAnagrams("cbaebabacd", "abc"));
    System.out.println(solver.findAnagrams("abab", "ab"));
  }
}
