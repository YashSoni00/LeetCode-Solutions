// Link: https://leetcode.com/problems/image-smoother/
package Easy;

public class ImageSmoother {
    public static void main(String[] args) {
        int[][] img = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int[][] result = imageSmoother(img);
        for (int[] row : result) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static int[][] imageSmoother(int[][] img) {
        // Time: O(m * n), Space: O(m * n)
        // Approach: Traverse through the image matrix and for each element,
        // find the top, bottom, left, and right bounds. Calculate the total sum
        // and count of elements in the submatrix. Calculate the average and store
        // it in the result matrix.

        // m = number of rows, n = number of columns
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        // Traverse through the image matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Find the top, bottom, left, and right bounds
                int top = Math.max(0, i - 1);
                int bottom = Math.min(m, i + 2);
                int left = Math.max(0, j - 1);
                int right = Math.min(n, j + 2);

                // Calculate the total sum and count of elements
                int total = 0;
                int count = 0;

                // Traverse through the submatrix
                for (int r = top; r < bottom; r++) {
                    for (int c = left; c < right; c++) {
                        total += img[r][c];
                        count++;
                    }
                }

                // Calculate the average and store it in the result matrix
                result[i][j] = total / count;
            }
        }
        return result;
    }
}
