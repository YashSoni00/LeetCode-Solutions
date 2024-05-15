package Medium;// Idea: binary search to find the position of the target, then expand the range
// Algorithm: We will apply binary search on the array. We will check if the mid-element is equal to target.
//            If it is then we will return the mid-element. Else we will check if the mid-element is smaller than
//            target. If it is then we will move right. Else we will move left.
//            Now we have found the position of the target element. So we will expand the range.
//            We will check if the element at position-1 is equal to target. If it is then we will move left.
//            We will check if the element at position+1 is equal to target. If it is then we will move right.
//            We will return the range.
// Time Complexity: O(logn)
// Space Complexity: O(1)
// LeetCode: 34. Find First and Last Position of Element in Sorted Array
// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
import java.util.Arrays;

public class FindTheFirstAndLastPositionOfElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 5, 7, 8, 8, 10};
        int target = 6;
        System.out.println(Arrays.toString(findRange(nums, target)));
    }

    private static int[] findRange(int[] nums, int target) {
        int position = findPos(nums, target);
        if (position == -1) return new int[] {-1, -1};
        int beg = position, end = position;
        while (beg != 0 && nums[beg-1] == target){
            beg--;
        }
        while (end != nums.length-1 && nums[end+1] == target){
            end++;
        }
        return new int[] {beg, end};
    }

    private static int findPos(int[] nums, int target) {
        int beg = 0, end = nums.length-1, mid;
        while (beg <= end) {
            mid = beg + (end - beg)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) beg = mid + 1;
            else end = mid -1;
        }
        return -1;
    }
}