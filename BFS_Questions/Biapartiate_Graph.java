package BFS_Questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//NOT WORKING PROPERLY

public class Biapartiate_Graph {

    class Solution {
        public class Graph{
            List<List<Integer>> adj;
            int size;

            Graph(int[][] graph){
                this.size = graph.length;
                this.adj = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    adj.add(new ArrayList<>());
                }
                int src = 0;
                for(int[] edge : graph){
                    for(int nbr : edge){
                        adj.get(src).add(nbr);
                    }
                    src += 1;
                }
            }
        }


        public boolean bfs(Graph graph, int src, int[] colors ){

            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(src);
            colors[src] = 0;

            while(!queue.isEmpty()){

                int curr = queue.poll();

                for(int nbr : graph.adj.get(curr)){
                    if(colors[nbr] == -1){
                        colors[nbr] = 1 - colors[src];
                        queue.add(nbr);
                    }else if(colors[nbr] == colors[src]){
                        return false;
                    }
                }

            }
            return true;

        }

        public boolean isBipartite(int[][] grid) {

            Graph graph = new Graph(grid);

            int[] colors = new int[grid.length];
            Arrays.fill(colors, -1);

            for(int i = 0; i < colors.length; i++){
                if(colors[i] == -1){
                    if(!bfs(graph, i, colors)){
                        return false;
                    }
                }
            }
            return true;


        }
    }
















}
