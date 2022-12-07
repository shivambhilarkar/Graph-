package GraphRepresentation;

import java.util.ArrayList;
import java.util.Scanner;

public class G1_Adjlist_Representation_graph {
    //Edge Class. which contains source & destination of edge
    public static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    //Graph Class.
    public static class Graph{
        private final ArrayList<ArrayList<Edge>> adj;
        private final int nodes;

        Graph(int nodes){
            this.nodes = nodes;
            this.adj = new ArrayList<>();
            for(int i = 0; i < nodes; i++){
                this.adj.add(new ArrayList<>());
            }
        }

        //add directed edge a -> b
        public void addDirectedEdge(int src, int dest){
            Edge edge = new Edge(src, dest);
            adj.get(src).add(edge);
        }

        //add un-directed edge a -> b & b -> a
        public void addUndirectedEdge(int src, int dest) {
            addDirectedEdge(src, dest);
            addDirectedEdge(dest, src);
        }
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Graph graph = new Graph(5);
        graph.addDirectedEdge(1,2);
        graph.addDirectedEdge(2,3);
        graph.addDirectedEdge(3,4);
    }
}
