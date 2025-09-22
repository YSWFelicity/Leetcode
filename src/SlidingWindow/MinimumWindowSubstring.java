package SlidingWindow;

/**
 * Problem 76: https://leetcode.com/problems/minimum-window-substring/
 *
 */
public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    // 边界：t 比 s 长，必无解
    if (t.length() > s.length()) {
      return "";
    }

    // 统计 t 中每个字符所需频次（欠账本）
    int[] freqT = new int[256];
    for (char c : t.toCharArray()) {
      freqT[c]++;                 // 欠一个 c
    }

    // 滑动窗口指针与答案记录
    int left = 0;                   // 当前窗口左边界
    int res = Integer.MAX_VALUE;    // 当前最短窗口长度（答案长度）
    int need = t.length();          // 还差多少“字符位”没被覆盖（总位数，而非种类数）
    int bestStart = 0;              // 当前最短窗口的起点

    // 右指针 i 向右扩张窗口
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      // 用窗口里的 ch 去抵 t 的欠账：先减再判定
      freqT[ch]--;                // 可能会变为负数：表示这个字符在窗口里“多拿了”

      // 若减完仍 >= 0，说明这次确实补上了 t 所“欠”的一个字符位
      if (freqT[ch] >= 0) {
        need--;                 // 整体“还欠的位数”减少 1
      }

      // 当窗口已经覆盖了 t（need == 0），尝试收缩左边界，尽量变短
      while (need == 0) {
        // 进入收缩前：先记录答案（因为此刻窗口是合法覆盖）
        if (i - left + 1 < res) {
          res = i - left + 1; // 更新最短长度
          bestStart = left;   // 记录最短窗口起点
        }

        // 丢掉左端字符：把它“加回欠账表”
        char lc = s.charAt(left);
        freqT[lc]++;            // 窗口少用一个 lc，相当于又“欠回去”一个 lc

        // 如果加回去后 > 0，说明刚丢的是必需品（覆盖被破坏）
        if (freqT[lc] > 0) {
          need++;             // 标记为“不再覆盖”，退出 while 收缩
        }

        // 左指针右移一格（继续尝试更短；或者因为 need>0 而结束收缩）
        left++;
      }
    }

    // 若 res 未更新，返回空串；否则返回记录下的最短窗口
    return res == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + res);
  }

  public static void main(String[] args) {
    MinimumWindowSubstring solver = new MinimumWindowSubstring();

    System.out.println(solver.minWindow("ADOBECODEBANC", "ABC")); // 期望: BANC
    System.out.println(solver.minWindow("A", "AA"));              // 期望: 空串
    System.out.println(solver.minWindow("ABC", "ABC"));           // 期望: ABC
    System.out.println(solver.minWindow("AAABBC", "ABC"));        // 期望: ABBC
    System.out.println(solver.minWindow("aaflslflsldkalskaaa", "aaa")); // 期望: aaa
  }
}
