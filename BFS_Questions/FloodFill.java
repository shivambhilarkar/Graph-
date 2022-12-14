package BFS_Questions;

import java.util.ArrayDeque;

public class FloodFill {
    class Solution {
        //Position class to hold position on grid
        public class Position{
            int r;
            int c;
            Position(int r, int c){
                this.r = r;
                this.c = c;
            }
        }
        //Breadth First Search
        public void bfs(int[][] image, int sr, int sc, int color){
            int oldColor = image[sr][sc];
            if(oldColor == color) return;

            ArrayDeque<Position> queue = new ArrayDeque<>();
            queue.add(new Position(sr, sc));

            int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    Position curr = queue.poll();
                    image[curr.r][curr.c] = color;

                    for(int[] dir : directions){
                        int x = dir[0] + curr.r;
                        int y = dir[1] + curr.c;

                        if(!positionIsValid(image,x,y,oldColor)) continue;
                        queue.add(new Position(x,y));
                    }
                }
            }
        }
        //method to check if next position is out of bound || valid or not
        public boolean positionIsValid(int[][] matrix, int r, int c, int color){
            if(r<0||r>=matrix.length||c<0||c>=matrix[0].length|| matrix[r][c] != color){
                return false;
            }
            return true;
        }

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image == null || image.length == 0) return null;

            bfs(image,sr,sc,color);
            return image;
        }
    }

    public static void main(String[] args) {
        //Main methode
    }

}
