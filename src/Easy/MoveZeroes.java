package Easy;

// Leetcode: 283
// Link: https://leetcode.com/problems/move-zeroes/
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums2 = {0};
        moveZeroes(nums2);
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }

//     Approach: Two pointers
//     1. Initialize two pointers i and j to 0.
//     2. Iterate through the array with j pointer.
//     3. If nums[j] is not equal to 0, then assign nums[j] to nums[i] and increment i.
//     4. After the loop, assign 0 to the remaining elements from i to n.

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        while (i < n) {
            nums[i++] = 0;
        }
    }
}
