// Link: https://leetcode.com/problems/find-the-maximum-sum-of-node-values
// Medium: https://medium.com/@yash-soni/solving-leetcode-3068-find-the-maximum-sum-of-node-values-4817bed75282

package Hard;

import java.util.Arrays;

public class FindtheMaximumSumofNodeValues {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}};
        System.out.println(maximumValueSum(nums, k, edges)); // 25
    }
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long nodeSum = 0;

        for (int i = 0; i < n; i++) {
            nodeSum += nums[i];
            nums[i] = (nums[i] ^ k) - nums[i];
        }

        Arrays.sort(nums);

        for (int i = n-1; i >= 1; i -= 2) {
            long pairSum = nums[i] + nums[i - 1];
            // Include in nodeSum if pairSum is positive
            if (pairSum > 0) {
                nodeSum += pairSum;
            } else {
                return nodeSum;
            }
        }
        return nodeSum;
    }
}
