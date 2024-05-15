package Medium;// Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums= {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            int correct = nums[i]-1;
            if (nums[i] != i+1 && nums[i] != nums[correct]){
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        for (i=0; i<nums.length; i++){
            if (nums[i] != i+1) result.add(nums[i]);
        }
        return result;
    }
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }
}
