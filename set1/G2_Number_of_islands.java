package set1;

public class G2_Number_of_islands {

    //four Directions       down    right    left      up
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    //dfs method
    private void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] dir : directions) {
            int x = dir[0] + r;
            int y = dir[1] + c;
            if (isValidPosition(grid, x, y, visited)) {
                dfs(grid, x, y, visited);
            }
        }
    }

    //method to check position is valid or not in grid or already visited
    private boolean isValidPosition(char[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0' || visited[r][c]) {
            return false;
        }
        return true;
    }

    public int numIslands(char[][] grid) {
        //Base Condition
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int counter = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {

    }
}
