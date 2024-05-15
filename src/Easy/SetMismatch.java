package Easy;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int i = 0, duplicate = -1, missing = -1;
        while (i < nums.length){
            int correct = nums[i]-1;

            if (nums[i] <= nums.length && nums[i] != nums[correct]){
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        for (i=0; i<nums.length; i++){
            if (nums[i] != i+1) {
                duplicate = nums[i];
                missing = i+1;
            }
        }

        return new int[] {duplicate, missing};
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }
}
