package BFS_Questions;

import java.util.ArrayDeque;

public class Number_Of_Islands_I {
    //Position class to hold the indices of matrix
    public class Position{
        int r;
        int c;
        Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    //BFS
    private void bfs(char[][] grid, int r, int c){
        //four Directions       down    right    left      up
        int[][] directions = { { 1,0} , {0,1} , {-1,0} , {0,-1} };

        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(r,c));
        grid[r][c] = '0';

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Position curr = queue.poll();
                for(int[] dir : directions){
                    int x = dir[0] + curr.r;
                    int y = dir[1] + curr.c;

                    if(!isValidPosition(grid, x, y)) continue;
                    grid[x][y] = '0'; //act as visited cell
                    queue.add(new Position(x,y));

                }
            }
        }
    }

    //method to check position is valid or not in grid or already visited
    private boolean isValidPosition(char[][] grid, int r, int c){
        if( r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            return false;
        }
        return true;
    }


    public int numIslands(char[][] grid) {
        //Base Condition
        if(grid == null || grid.length == 0){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int counter = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if( grid[i][j] == '1'){
                    bfs(grid, i, j);
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        //Main Method
    }
}
