package Medium;

// Idea: Modified version of binary search.
// Algorithm: First we will find the pivot element. Then we will apply binary search on both the parts.
//            To find the pivot element, we will use the same binary search algorithm.
//            We will check if the mid element is greater than mid+1 element. If it is then we have found the pivot.
//            If not then we will check if the mid element is smaller than mid-1 element. If it is then we have found
//            the pivot. If not then we will check if the mid element is smaller than the first element. If it is then
//            we will move left. Else we will move right.
//            Now we have found the pivot element. So we will check if the pivot element is equal to the target. If it
//            is then we will return the pivot element. Else we will check if the first element is smaller than the
//            target. If it is then we will apply binary search on the left part. Else we will apply binary search on
//            the right part.
//            Now we will apply binary search on the left part. If the mid element is equal to the target then we will
//            return the mid element. Else we will check if the mid element is greater than the target. If it is then
//            we will move left. Else we will move right.
//            Now we will apply binary search on the right part. If the mid element is equal to the target then we will
//            return the mid element. Else we will check if the mid element is greater than the target. If it is then
//            we will move left. Else we will move right.
//            Now we will return -1. This means that the element is not present in the array.
// Time Complexity: O(log n)
// Space Complexity: O(1)
// Leetcode: 33. Search in Rotated Sorted Array
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInARotatedArray {
    public static void main(String[] args) {
        int[] nums = {7, 9, 0, 2, 3, 4, 5, 6};
        int target = 6;
//        System.out.println(searchInRotated(nums, target));
        System.out.println(findElement(nums, target));
    }

    /*
    This is a modified version of binary search. But the idea is same.
    Now we have to find the pivot element first. Then we can apply binary search on both the parts.
    So we will do this in a method that can be easily understood.
    private static int searchInRotated(int[] nums, int target) {
        int beg = 0, end = nums.length-1, mid;
        while (beg<=end) {
            mid = beg + (end - beg)/2; // To avoid overflow
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[beg]) { // This means we are in ascending part of array.
                if (target >= nums[beg] && target < nums[mid]) end = mid-1;
                else beg = mid+1;
            } else { // This means we are in descending part of array.
                if (target <= nums[end] && target > nums[mid]) beg = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }
    */
    static int findPivot(int[] nums) {
        int beg = 0, end = nums.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2; // To avoid overflow

            if (mid < end && nums[mid] > nums[mid + 1])
                return mid; // Because we know that [mid] element is greater than [mid+1].
            if (mid > beg && nums[mid] < nums[mid - 1])
                return mid - 1; // Because we know that [mid] element is smaller than [mid-1].

//            Now if the above two conditions are not true then we have to move either left or right. Because if the
//            above two conditions are not true then we are not in the pivot element.
            if (nums[mid] <= nums[beg]) end = mid - 1; // This means we are in descending part of array.
            else beg = mid + 1; // This means we are in ascending part of array.
        }
        return -1; // This means that the array is not rotated.
    }

    private static int findElement(int[] nums, int target){
        int pivot = findPivot(nums);
        if (pivot == -1) return binarySearch(nums, target, 0, nums.length-1);

        // If pivot is found, then you have found 2 ascending sorted arrays.
        if (nums[pivot] == target) return pivot;
        if (nums[0] <= target) return binarySearch(nums, target, 0, pivot-1);
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    private static int binarySearch(int[] nums, int target, int beg, int end) {
        while (beg<=end){
            int mid = beg + (end - beg)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else beg = mid+1;
        }
        return -1; // This means that the element is not present in the array.
    }
}