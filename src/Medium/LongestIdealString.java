package Medium;

public class LongestIdealString {
    public static void main(String[] args) {
        LongestIdealString longestIdealString = new LongestIdealString();
        System.out.println(longestIdealString.longestIdealString("acfgbd", 2));
    }

    public int longestIdealString(String s, int k) {
        int longest = 0;
        int current = 0;
        k = k%26;
        // If the character at index i is 'a' and k is 2 then the next character can be 'c' or 'y'.
        // This is because 'c' is 2 characters away from 'a' and 'y' is 2 characters away from 'a'.
        // Till this condition is satisfied we increment current and if its false we set current to 0.
        for (int i = 0; i < s.length()-1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i+1)) <= k){
                current++;
            } else {
                i++;
            }
            longest = Math.max(longest, current);
        }
        return longest+k;
    }
}
