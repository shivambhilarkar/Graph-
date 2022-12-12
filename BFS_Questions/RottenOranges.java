package BFS_Questions;

import java.util.ArrayDeque;

public class RottenOranges {

    static class Solution {
        // to store position in grid
        class Position{
            int x;
            int y;
            Position(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        public int orangesRotting(int[][] grid) {
            if(grid == null || grid.length == 0) return 0;
            int row = grid.length , col = grid[0].length;

            // loop through matrix and get rotten oranges position
            ArrayDeque<Position> queue = new ArrayDeque<>();
            int rotten = 0;
            int fresh = 0;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == 1) fresh += 1;
                    if(grid[i][j] == 2){
                        queue.add(new Position(i, j));
                        rotten += 1;
                    }
                }
            }
            if(fresh == 0) return 0;

            // Breadth First Search
            int[][] directions = {{0,1}, {0,-1},{1,0},{-1,0}};
            int minutes = 0;
            int Oranges = fresh + rotten;

            while(!queue.isEmpty()){
                int size = queue.size();
                Oranges -= size;
                if(Oranges == 0){
                    return minutes;
                }
                for(int i = 0; i < size; i++){
                    Position current = queue.poll();
                    for(int[] direction : directions){
                        int x = direction[0] + current.x;
                        int y = direction[1] + current.y;

                        if(nextPositionIsInvalid(x,y,grid)){
                            continue;
                        }
                        queue.add(new Position(x,y));
                        grid[x][y] = 2;
                    }
                }
                minutes += 1;
            }
            return -1;//can not rott all oragnes;
        }

        //function to check next position
        private boolean nextPositionIsInvalid(int i, int j, int[][] grid){
            if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j] != 1){
                return true;
            }
            return false;
        }

    }


    //Main function
    public static void main(String[] args) {

    }


}
