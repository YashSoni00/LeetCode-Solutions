package Medium;

// Link: https://leetcode.com/problems/score-after-flipping-matrix/
public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(A));

        int[][] B = {{0,1},{0,1},{0,1},{0,0}};
        System.out.println(matrixScore(B));

        int[][] C = {{0,0,0},{0,0,1},{1,1,0}};
        System.out.println(matrixScore(C));
    }

    public static int matrixScore(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;

        // Row Flips
        for (int i=0; i<rLen; i++) {
            if (grid[i][0] == 0) {
                // Flip row
                for (int j=0; j<cLen; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        // Column Flips
        for (int i=0; i<cLen; i++) {
            int count = 0;
            for (int j=0; j<rLen; j++) {
                if (grid[j][i] == 0) count++;
            }

            if (count > rLen/2) {
                // Flip column
                for (int j=0; j<rLen; j++) {
                    grid[j][i] = grid[j][i] == 0 ? 1 : 0;
                }
            }
        }

        for (int i=0; i<rLen; i++) {
            for (int j=0; j<cLen; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        // Calculate result
        int sum = 0;
        for (int i=0; i<rLen; i++) {
            // Math.pow(base, exponent);
            // Math.pow(2, 3) = 8
            int rowSum = 0;
            for (int j=0; j<cLen; j++) {
                if (grid[i][j] == 1)
                    rowSum += (int) Math.pow(2, cLen-1-j);
            }
            sum += rowSum;
        }

        return sum;
    }
}
