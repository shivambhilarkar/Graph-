package GraphRepresentation;

public class G2_AdjMatrix_Representation_graph {
    public static class Graph{
        private final int[][] matrix;
        private final int nodes;

        Graph(int nodes){
            this.nodes = nodes;
            this.matrix = new int[nodes][nodes];
        }
        //add edge a -> b
        public void addDirectedEdge(int src, int dest){
            matrix[src][dest] = 1;
        }
        //add edge a -> b & b -> a
        public void addUnDirectedEdge(int src, int dest){
            addDirectedEdge(src, dest);
            addDirectedEdge(dest, src);
        }
    }

    public static void main(String[] args){
        Graph graph = new Graph(5);

        graph.addDirectedEdge(0 ,1);
        graph.addDirectedEdge(1 ,2);
        graph.addDirectedEdge(2 ,3);
        graph.addDirectedEdge(3 ,4);
    }
}
