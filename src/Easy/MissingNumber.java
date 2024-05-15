package Easy;// Link: https://leetcode.com/problems/missing-number/
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        cyclicSort(nums);

        // Find the missing number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return i;
            }
        }

        // After sorting if the array is in the correct order, then the missing number is the last number.
        return nums.length;
    }

    public static void cyclicSort(int[] arr) {

        // The numbers are ranging from 0 to n-1
        int i = 0;
        while (i < arr.length){
            // In this case, we are not using the index to place the element at the correct index.
            // Instead, we are using the value of the element to place it at the correct index.
            // So if the element is missing, then we will not be able to place it at the correct index.
            // This is how we find the missing number.

            int correct = arr[i];

            // Do not reverse the order of these conditions ``IMP``
            if (arr[i] < arr.length && arr[i] != arr[correct]){
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
