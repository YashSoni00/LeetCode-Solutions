package Medium;// Link: https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/

import java.util.Arrays;

public class EliminateMaxMonsters {
    public static void main(String[] args) {
        int[] dist = {3, 2, 4};
        int[] speed = {5, 3, 2};
        // In this problem, we have to return the maximum number of monsters killed.

        // So we can just subtract the speed[i] from dist[i] and if two or more dist[i] results in 0 or -ve then we lose.
        System.out.println(killMonsters(dist, speed));
    }

    private static int killMonsters(int[] dist, int[] speed) {

        // Calculate Arrival Times
        for (int i = 0; i < dist.length; i++) {
            dist[i] = dist[i] / speed[i];
        }

        // Sort Arrival Times
        Arrays.sort(dist);

        // Eliminate Monsters
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= i) {
                return i;
            }
        }

        return dist.length;
    }
}
