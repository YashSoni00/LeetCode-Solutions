package Easy;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int x: nums) {
            if (even(x)) count++;
        }
        return count;
    }

    private static boolean even(int x) {
        int numberOfDigits = digits2(x);
        return numberOfDigits % 2 == 0;
    }

    private static int digits2(int x) {
        if (x<0) x *= -1;
        if (x==0) return 1;
        return (int)(Math.log10(x) + 1); // Shortcut to find number of digits.
    }

    private static int digits(int x) {
        if (x<0) x *= -1;
        int count = 0;
        if (x==0) return 1;
        while (x>0){
            x = x/10;
            count++;
        }
        return count;
    }
}