package BFS_Questions;

import java.util.ArrayDeque;
import java.util.HashSet;

//Note :  base_row = (src_row - dest_row) , base_col = (src_col - dest_col);

public class Distinct_Islands {

    //holds the position on matrix
    class Position{
        int r;
        int c;
        Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    //standard bfs
    public void bfs(int[][] grid, int sr, int sc, HashSet<String> set, int[][] directions) {

        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(sr, sc));

        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        sb.append( "["+ (sr - sr) + "," + (sc  - sc)+ "]");

        grid[sr][sc] = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Position curr = queue.poll();

                for(int[] dir : directions){
                    int x = dir[0] + curr.r;
                    int y = dir[1] + curr.c;

                    if(!isPositionValid(grid, x, y)) continue;

                    queue.add(new Position(x,y));
                    grid[x][y] = 0;
                    sb.append( "["+ (x - sr) + "," +( y - sc)+ "]");
                }
            }
        }
        sb.append("}");
        set.add(sb.toString());
    }
    //Method to check position is valid or not
    public boolean isPositionValid(int[][] grid, int x, int y){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y] != 1){
            return false;
        }
        return true;
    }

    int countDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        HashSet<String> set = new HashSet<>();
        int[][] directions = { {1,0}, {0,1}, {-1,0} , {0,-1}};

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i, j, set, directions);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        //Main Method
    }


}
