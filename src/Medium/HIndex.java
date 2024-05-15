package Medium;

import java.util.Arrays;

// Link: https://leetcode.com/problems/h-index/
public class HIndex {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    public static int hIndex(int[] citations){
        Arrays.sort(citations); // Array : [0, 1, 3, 5, 6]
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // If the number of citations is greater than or equal to the number of papers that have that many citations
            if (citations[i] >= n-i){
                return n-i;
            }
        }
        return 0;
    }
}
