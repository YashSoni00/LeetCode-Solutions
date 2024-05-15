package Easy;// Link: https://leetcode.com/problems/find-the-highest-altitude/
// Time Complexity: O(n)
// Space Complexity: O(1)

public class HighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
    }

    private static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0; // Starting Altitude
        for (int i=0; i<gain.length; i++){
            currentAltitude += gain[i];
            if (maxAltitude < currentAltitude) maxAltitude = currentAltitude;
        }
        return maxAltitude;
    }
}
