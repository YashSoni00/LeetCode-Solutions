package Medium;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        // [5,1,3,5,10,7,4,9,2,8] - 15
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;
        System.out.println(minSubArrayLen(target, nums));

        // [1,1,1,1,1,1,1,1] - 11
        int[] nums2 = {1,1,1,1,1,1,1,1};
        int target2 = 11;
        System.out.println(minSubArrayLen(target2, nums2));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
