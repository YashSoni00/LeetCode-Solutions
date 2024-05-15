package Easy;// Link: https://leetcode.com/problems/summary-ranges/
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }
    public static List<String> summaryRanges(int[] nums){
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]){
                i++;
            }
            if (start != nums[i]){
                result.add(start + "->" + nums[i]);
            } else {
                result.add(start + "");
            }
            i++;
        }
        return result;
    }
}
