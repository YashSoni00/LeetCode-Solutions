package Medium;

// Link: https://leetcode.com/problems/find-the-original-array-from-the-given-array/
// Time Complexity: O(logn)


import java.util.Arrays;

public class FindTheOriginalArrayofPrefixXor {
    public static void main(String[] args) {
        int[] pref = {6, 6, 7, 9, 3, 5, 8, 8};
        System.out.println(Arrays.toString(findArray(pref)));

        int[] pref2 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findArray(pref2)));
    }

    public static int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];

        arr[0] = pref[0];
        for (int i=1; i<pref.length; i++) {
            arr[i] = pref[i-1] ^ pref[i];
        }
        return arr;
    }
}
