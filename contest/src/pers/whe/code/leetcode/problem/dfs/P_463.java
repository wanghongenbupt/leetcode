package pers.whe.code.leetcode.problem.dfs;

public class P_463 {

    /*
    * 463. Island Perimeter
    * 边界+1
     * */
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)  {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }
        return 0;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 1) {
            grid[i][j] =  2;
            return dfs(i - 1, j + 1, grid) +
                    dfs(i + 1, j + 1, grid) +
                    dfs(i + 1, j - 1, grid) +
                    dfs(i - 1, j - 1, grid);
        }
        return 0;
    }
}
