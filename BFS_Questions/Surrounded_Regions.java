package BFS_Questions;

import java.util.ArrayDeque;

public class Surrounded_Regions {

    public class Position{
        int r;
        int c;
        Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};

    //BFS -> method to check if element in boundary connected
    public boolean checkIsBoundary(char[][] board, int sr, int sc){
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

                    if(!visited[x][y] && board[x][y] == 'O'){
                        queue.add(new Position(x,y));
                        visited[x][y] = true;
                    }

                }
            }
        }
        return false;
    }

    //Method to change element in board -> BFS
    public void fillMatrix(char[][] board, int sr, int sc){
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(sr, sc));
        board[sr][sc] = 'X';

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Position curr = queue.poll();
                for(int[] dir : directions){
                    int x = dir[0] + curr.r;
                    int y = dir[1] + curr.c;

                    if(x<0||x>=row||y<0||y>=col) continue;
                    if(board[x][y] == 'O'){
                        queue.add(new Position(x,y));
                        board[x][y] = 'X';
                    }
                }
            }
        }
    }


    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' &&  !checkIsBoundary(board, i, j)){
                    fillMatrix(board, i, j);
                }
            }
        }

    }

    public static void main(String[] args) {
        //Main Method
    }





}
