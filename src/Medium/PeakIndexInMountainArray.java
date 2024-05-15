package Medium;

// Idea: Binary Search
// Algorithm: We will apply binary search on the array. We will check if the mid element is greater than mid+1 element.
//            If it is then we have found the peak element. If not then we will check if the mid element is smaller than
//            mid-1 element. If it is then we have found the peak element. If not then we will check if the mid element
//            is smaller than the first element. If it is then we will move left. Else we will move right.
// Time Complexity: O(logn)
// Space Complexity: O(1)
// LeetCode: 852. Peak Index in a Mountain Array
// Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] nums = {0, 2, 6, 10, 11, 14, 19, 20,  1, 0};
        System.out.println(findPeak(nums));
    }
    private static int findPeak(int[] nums) {
        int beg = 0, end = nums.length-1, mid;
        while (beg<end) {
            mid = beg + (end - beg)/2; // To avoid overflow
            if (nums[mid] > nums[mid+1]) end = mid; // Because we know that [mid] element is greater than [mid+1].
//            This means we are in descending part of array.
            else beg = mid+1; // Because we know that [mid] element is smaller than [mid+1]
//            This means we are in ascending part of array.
        }
        return beg;
    }
}