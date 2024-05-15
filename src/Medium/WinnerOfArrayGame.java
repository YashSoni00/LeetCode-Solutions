package Medium;// Link: https://leetcode.com/problems/find-the-winner-of-an-array-game/
// Date: 03/18/2021 Daily Challenge


public class WinnerOfArrayGame {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7};
        int k = 2;

        System.out.println(getWinner(arr, k));
    }

    private static int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int winCount = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > winner) {
                winner = arr[i];
                winCount = 0;
            }
            winCount++;
            if (winCount == k) {
                break;
            }
        }

        return winner;
    }
}
