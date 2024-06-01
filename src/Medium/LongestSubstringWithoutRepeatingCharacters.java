package Medium;

// LeetCode #3
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Time Complexity: O(n)
// Space Complexity: O(1)

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("")); // 0
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] chars = new boolean[128];
        int len = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (chars[c]) {
                chars[s.charAt(j++)] = false;
            }
            chars[c] = true;
            len = Math.max(len, i - j + 1);
        }
        return len;
    }
}
