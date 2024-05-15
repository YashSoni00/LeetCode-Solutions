package Medium;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        // 2 -> 3 -> 1 -> 1 -> 4
        // 0    1    2    3    4
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int jumps = 0;

        // Max Jump from the current position
        int maxJump = nums[0];

        // Max Position that can be reached
        int maxPosition = nums[0];

        // Start from index 0 and iterate through the array to find the minimum number of jumps required
        // To do that we need to keep track of the max jump from the current position and the max position that
        // can be reached from the current position

        // Also for every index we need to increment the maxPosition to the maximum of the current maxPosition and
        // the current index + the value at the current index in the array

        // The idea is to keep track of the max position that can be reached from the current position and if the current
        // position is greater than the max jump then we need to jump to the max position
        for (int i = 1; i < nums.length; i++) {
            // If the current position is greater than the max jump then we need to jump
            if (i > maxJump) {
                jumps++;
                maxJump = maxPosition;
            }
            maxPosition = Math.max(maxPosition, i + nums[i]);
        }
        return jumps+1;
    }
}
