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
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = Math.max(0, i - 1);
                int bottom = Math.min(m, i + 2);
                int left = Math.max(0, j - 1);
                int right = Math.min(n, j + 2);
                int total = 0;
                int count = 0;

                for (int r = top; r < bottom; r++) {
                    for (int c = left; c < right; c++) {
                        total += img[r][c];
                        count++;
                    }
                }
                result[i][j] = total / count;
            }
        }
        return result;
    }
}
