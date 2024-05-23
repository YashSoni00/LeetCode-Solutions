package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheNumberofBeautifulSubsets {
    static int count = 0;
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int k = 3;
        System.out.println(beautifulSubsets(nums, k)); // 3

        int[] nums2 = {5, 1, 6};
        int k2 = 2;
        System.out.println(beautifulSubsets(nums2, k2)); // 7

        int[] nums3 = {3, 4, 5, 6, 7, 8};
        int k3 = 2;
        System.out.println(beautifulSubsets(nums3, k3)); // 36
    }

    private static int beautifulSubsets(int[] nums, int k) {
        // Recursive approach
        count = 0;
        rec(nums, k, 0, new ArrayList<>());
        return count-1;
    }

    private static void rec(int[] nums, int k, int index, List<Integer> subset) {
        if (index == nums.length) {
            if (isBeautiful(subset.stream().mapToInt(i -> i).toArray(), k)) {
                count++;
            }
            return;
        }

        // We will only consider the current element if it is still beautiful
        if (subset.isEmpty() || isSafe(subset, nums[index], k)) {
            subset.add(nums[index]);
            rec(nums, k, index+1, subset);
            subset.remove(subset.size()-1);
        }
        rec(nums, k, index+1, subset);
    }

    private static boolean isSafe(List<Integer> subset, int num, int k) {
        for (Integer integer : subset) {
            if (Math.abs(integer - num) == k) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBeautiful(int[] subset, int k) {
        Arrays.sort(subset);
        for (int i=0; i<subset.length-1; i++)
            if (subset[i + 1] - subset[i] == k) return false;
        return true;
    }
}
