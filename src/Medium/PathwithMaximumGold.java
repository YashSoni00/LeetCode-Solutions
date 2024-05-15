package Medium;

public class PathwithMaximumGold {
    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold(grid)); // 24

        int[][] grid2 = {
                {1,0,7},
                {2,0,6},
                {3,4,5},
                {0,3,0},
                {9,0,20}
        };
        System.out.println(getMaximumGold(grid2)); // 28

        int[][] grid3 = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        System.out.println(getMaximumGold(grid3)); // 28
    }

    public static int getMaximumGold(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int maxGold = 0;

        for (int i=0; i<rLen; i++) {
            for (int j=0; j<cLen; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    public static int dfs(int[][] grid, int i, int j) {
        // Breaking Condition
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;

        // Save the current cell value and set it to 0 to avoid visiting it again in the current path
        int temp = grid[i][j];
        grid[i][j] = 0;

        // Visit all 4 directions and get the maximum gold
        int left = dfs(grid, i, j-1);
        int right = dfs(grid, i, j+1);
        int up = dfs(grid, i-1, j);
        int down = dfs(grid, i+1, j);

        // Restore the cell value before returning
        grid[i][j] = temp;

        // Return the maximum gold that can be collected from the current cell onwards
        return temp + Math.max(Math.max(left, right), Math.max(up, down));
    }
}
