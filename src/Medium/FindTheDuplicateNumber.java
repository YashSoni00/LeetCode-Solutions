package Medium;// Link: https://leetcode.com/problems/find-the-duplicate-number/description/

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicateWithCyclic(nums));
    }

    private static int findDuplicateWithCyclic(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int correct = nums[i]-1;
            if (nums[i] != i+1){
                if (nums[correct] == nums[i]) return nums[i];
                else swap(nums, i, correct);
            } else {
                i++;
            }
        }
        return -1;
    }
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    private static int findDuplicate(int[] nums) {
        // For this problem, we are not allowed to modify the array.
        // So we cannot use cyclic sort.

        // So we create a new array of size n+1 and initialize all the elements to 0.
        // Then we iterate over the given array and increment the count of the element at the index of the given array.
        // If the count is greater than 1, then we return the index.
        int duplicate = -1;
        int[] count = new int[nums.length+1];
        for (int i=0; i<nums.length; i++){
            count[nums[i]]++;
            if (count[nums[i]] > 1){
                duplicate = nums[i];
                break;
            }
        }
        return duplicate;
    }
}
