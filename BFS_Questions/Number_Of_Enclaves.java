package BFS_Questions;

import java.util.ArrayDeque;

public class Number_Of_Enclaves {

        //Time Limit Exicited
        public class Position{
            int r;
            int c;
            Position(int r, int c){
                this.r = r;
                this.c = c;
            }
        }

        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};

        public boolean checkIsBoundary(int[][] board, int sr, int sc){
            int row = board.length;
            int col = board[0].length;

            boolean[][] visited = new boolean[row][col];

            ArrayDeque<Position> queue = new ArrayDeque<>();
            queue.add(new Position(sr, sc));
            visited[sr][sc] = true;

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    Position curr = queue.poll();
                    for(int[] dir : directions){
                        int x = dir[0] + curr.r;
                        int y = dir[1] + curr.c;

                        if(x<0||x>=row||y<0||y>=col) return true;

                        if(!visited[x][y] && board[x][y] == 1){
                            queue.add(new Position(x,y));
                            visited[x][y] = true;
                        }

                    }
                }
            }
            return false;
        }


        public int fillMatrix(int[][] board, int sr, int sc){
            int row = board.length;
            int col = board[0].length;

            boolean[][] visited = new boolean[row][col];

            ArrayDeque<Position> queue = new ArrayDeque<>();
            queue.add(new Position(sr, sc));
            board[sr][sc] = 0;
            int counter = 1; //starting position included

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    Position curr = queue.poll();
                    for(int[] dir : directions){
                        int x = dir[0] + curr.r;
                        int y = dir[1] + curr.c;

                        if(x<0||x>=row||y<0||y>=col) continue;
                        if(board[x][y] == 1){
                            queue.add(new Position(x,y));
                            board[x][y] = 0;
                            counter += 1;
                        }
                    }
                }
            }
            return counter;
        }

        public int numEnclaves(int[][] board) {
            if(board == null || board.length == 0) return 0;

            int counter = 0;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == 1 &&  !checkIsBoundary(board, i, j)){
                        counter += fillMatrix(board, i, j);;
                    }
                }
            }

            return counter;
        }



}
