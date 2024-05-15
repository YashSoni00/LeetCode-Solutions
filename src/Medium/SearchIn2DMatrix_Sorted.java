package Medium;// Time Complexity: O(log(m) + log(n)) where m is the number of rows and n is the number of columns
// Space Complexity: O(1)
// Note: This is a very good question. The idea is to first find the row in which the target lies and then search in that row.
//       To find the row, we use binary search. To find the column, we use binary search again.
//       The only thing to note is that the row in which the target lies, the first element of that row will be less than or equal to the target
//       and the last element of that row will be greater than or equal to the target.
//       So, we use this property to find the row in which the target lies.
//       If the first element of the row is greater than the target, then we search in the rows before that row.
//       If the last element of the row is less than the target, then we search in the rows after that row.
//       If the target lies in the row, then we search in that row using binary search.
//       If the target doesn't lie in the matrix, then we return {-1, -1}.
// Leetcode: 74. Search a 2D Matrix
// Link: https://leetcode.com/problems/search-a-2d-matrix/description/

import java.util.Arrays;

public class SearchIn2DMatrix_Sorted {
    public static void main(String[] args) {
        int[][] matrix= new int[][] {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30 ,34, 60}
        };
        System.out.println(Arrays.toString(search2DSorted(matrix, 3)));
    }

    private static int[] search2DSorted(int[][] matrix, int target) {
        int rowBeg = 0, rowEnd = matrix.length-1;
        while (rowBeg <= rowEnd) {
            int rowMid = rowBeg + (rowEnd-rowBeg)/2;
            if (matrix[rowMid][0] <= target && matrix[rowMid][matrix[0].length-1] >= target) {
                return searchRow(matrix, rowMid, target);
            }
            if (matrix[rowMid][0] > target)
                rowEnd = rowMid-1;
            else
                rowBeg = rowMid+1;
        }
        return new int[] {-1, -1};
    }

    private static int[] searchRow(int[][] matrix, int rowMid, int target) {
        int colBeg = 0, colEnd = matrix[0].length-1;
        while (colBeg <= colEnd) {
            int colMid = colBeg + (colEnd-colBeg)/2;
            if (matrix[rowMid][colMid] == target)
                return new int[] {rowMid, colMid};
            if (matrix[rowMid][colMid] > target)
                colEnd = colMid-1;
            else
                colBeg = colMid+1;
        }
        return new int[] {-1, -1};
    }
}
