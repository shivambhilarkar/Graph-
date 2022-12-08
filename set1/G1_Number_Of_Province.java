package set1;

import java.util.ArrayList;

public class G1_Number_Of_Province {

    //depth first search on graph
    static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited){
        visited[src] = true;

        for(int nbr : adj.get(src)){
            if(!visited[nbr]){
                dfs(adj, nbr, visited);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        if(adj == null || adj.size() == 0 ) return 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        //converting into graph
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                if(adj.get(i).get(j) == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

            }
        }

        //Depth first search
        int count = 0;
        boolean[] visited = new boolean[V];
        for(int node = 0; node < visited.length; node++){
            if(!visited[node]){
                dfs(graph, node, visited);
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        //input is given as the adj matrix | adj list
    }
}
