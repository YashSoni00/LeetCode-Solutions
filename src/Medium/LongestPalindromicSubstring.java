package Medium;

// LeetCode #5
// https://leetcode.com/problems/longest-palindromic-substring/
// Time Complexity: O(n^2)
// Space Complexity: O(1)

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // Output: "bab"
        System.out.println(longestPalindrome("cbbd")); // Output: "bb"
        System.out.println(longestPalindrome("a")); // Output: "a"
        System.out.println(longestPalindrome("ac")); // Output: "a"
    }

    public static String longestPalindrome(String s) {
        int[] result = new int[2];
        int len = s.length() - 1;
        for (int i = 0; i <= len; i++) {
            // Select a middle element and expand toward both sides to check if it is
            // palindrome.
            int left = i;
            int right = i;

            // Expand till the character is same
            while (right < len && s.charAt(left) == s.charAt(right + 1))
                right++;
            while (left > 0 && s.charAt(left) == s.charAt(left - 1))
                left--;

            // Expand till we get the same left and right characters
            while (left > 0 && right < len &&
                    s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }

            // If the length of current substring is greater than result we update result
            if (right - left > result[1] - result[0]) {
                result[1] = right;
                result[0] = left;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }
}
