package Easy;

import java.util.LinkedList;
import java.util.List;

public class SumofAllSubsetXORTotals {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(subsetXORSum(nums)); // 6

        int[] nums2 = {5, 1, 6};
        System.out.println(subsetXORSum(nums2)); // 28

        int[] nums3 = {3, 4, 5, 6, 7, 8};
        System.out.println(subsetXORSum(nums3)); // 480
    }

    public static int subsetXORSum(int[] nums) {
        // Brute force
        List<List<Integer>> powerSet = new LinkedList<>();
        int sum = 0;
        powerSet.add(new LinkedList<>());
        for (int num : nums) {
            int size = powerSet.size();
            for (int i=0; i<size; i++) {
                List<Integer> subset = new LinkedList<>(powerSet.get(i));
                subset.add(num);
                powerSet.add(subset);
            }
        }

        for (List<Integer> subset : powerSet) {
            int currentSum = 0;
            for (int j=0; j<subset.size(); j++) {
                currentSum ^= subset.get(j);
            }
            sum += currentSum;
        }

        return sum;
    }
}
