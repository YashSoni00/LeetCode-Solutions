package Medium;

// Leetcode 1442
// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
// Time Complexity: O(n^3)
// Space Complexity: O(1)

public class CountTripletsThatCanFormTwoArraysofEqualXOR {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};
        System.out.println(countTriplets(arr)); // 4

        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println(countTriplets(arr2)); // 10

        int[] arr3 = {0, 0};
        System.out.println(countTriplets(arr3)); // 1

        int[] arr4 = {1, 3, 5, 7, 9};
        System.out.println(countTriplets(arr4)); // 3
    }

    public static int countTriplets(int[] arr) {
        int count = 0;

        // Iterate over each possible starting index i
        for (int start = 0; start < arr.length - 1; start++) {
            // Initialize XOR value for the subarray from start to mid-1
            int xorA = 0;

            // Iterate over each possible middle index j
            for (int mid = start + 1; mid < arr.length; mid++) {
                // Update xorA to include arr[mid - 1]
                xorA ^= arr[mid - 1];

                // Initialize XOR value for the subarray from mid to end
                int xorB = 0;

                // Iterate over each possible ending index k (starting from mid)
                for (int end = mid; end < arr.length; end++) {
                    // Update xorB to include arr[end]
                    xorB ^= arr[end];

                    // found a valid triplet (start, mid, end)
                    if (xorA == xorB) {
                        ++count;
                    }
                }
            }
        }

        return count;
    }
}
