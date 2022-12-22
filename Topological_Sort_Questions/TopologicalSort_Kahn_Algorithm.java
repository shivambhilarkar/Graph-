package Topological_Sort_Questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSort_Kahn_Algorithm {
    public class Graph{
        List<List<Integer>> adj;
        int size;
        Graph(int nodes){
            this.size = nodes;
            for(int i = 0; i < size; i++){
                adj.add(new ArrayList<>());
            }
        }
    }


    public void KahnsAlgorithm(Graph graph){

        int[] indegree = new int[graph.size];
        //Count In-degree
        for(int src = 0; src < graph.size; src++){
            for(int nbr : graph.adj.get(src)){
                indegree[nbr]++;
            }
        }
        //get all nodes who have indegree as zero
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int node = 0; node < graph.size; node++){
            if(indegree[node] == 0){
                queue.add(node);
            }
        }

        int count = 0;
        ArrayList<Integer> topoOrder = new ArrayList<>();

        while(!queue.isEmpty()){
            int current = queue.poll();
            topoOrder.add(current);

            for(int nbr : graph.adj.get(current)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
            count += 1;
        }

        if(count != graph.size){
            System.out.println("Ordering Not possible...");
        }else{
            System.out.println("Order : "+ topoOrder);
        }
    }




    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
    }

}

