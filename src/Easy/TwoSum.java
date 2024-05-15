package Easy;// https://leetcode.com/problems/two-sum/description/
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        System.out.println(Arrays.toString(twoSum(nums, 10)));
    }
    static public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int sum = nums[i]+nums[j];
                if (sum == target) return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
}