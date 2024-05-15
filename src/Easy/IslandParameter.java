package Easy;

// Link: https://leetcode.com/problems/island-perimeter/
public class IslandParameter {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        System.out.println("Perimeter of the island: " + islandPerimeter(grid));
    }

    private static int islandPerimeter(int[][] grid) {
        int parameter = 0;
        for (int i=0; i<grid.length; i++) // Row
            for (int j=0; j<grid[i].length; j++) // Column
                parameter += getParameter(grid, i, j);
        return parameter;
    }

    private static int getParameter(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return 0;
        int parameter = 0;
        if (i == 0 || grid[i-1][j] == 0) parameter++; // Top
        if (i == grid.length-1 || grid[i+1][j] == 0) parameter++; // Bottom
        if (j == 0 || grid[i][j-1] == 0) parameter++; // Left
        if (j == grid[i].length-1 || grid[i][j+1] == 0) parameter++; // Right
        return parameter;
    }
}
