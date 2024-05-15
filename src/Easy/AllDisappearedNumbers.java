package Easy;// Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class AllDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1}; // Worst Case
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        cyclicSort(nums);
        for (int i=0; i<nums.length; i++){
            // Numbers are ranging from 1 to n
            if (nums[i] != i+1){
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }
    public static void cyclicSort(int[] arr) {
        // The numbers are ranging from 1 to n
        int i = 0;
        while (i < arr.length){
            int correct = arr[i]-1;

            if (arr[i] <= arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }
}
