package GraphDS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GraphList {
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2,3);
        addEdge(adj, 4, 5);
        
        DFS(adj);
        
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for(int i = 0;i< adj.size();i++){
            System.out.println(i+"->"+adj.get(i));
        }
    }
    public static void BFSDisconnected(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        for( int i = 0;i<adj.size();i++ ){
            if( visited[i] == false ){
                breadthFirstSearch(adj, i, visited);
            }
        }
        System.out.println("");
    }
    public static void breadthFirstSearch(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited){
        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(s);
        visited[s] = true;
        while( !qu.isEmpty() ){
            int node = qu.poll();
            System.out.print(node+" ");
            for( int val : adj.get(node) ){
                if( visited[val] == false ){
                    qu.offer(val);
                    visited[val] = true;
                }
            }
        }
    }
    public static void DFS(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        for( int i = 0;i<adj.size();i++ ){
            if( visited[i] == false ){
                DFSRecursive(adj,i,visited);
            }
        }
        System.out.println();
    }
    public static void DFSRecursive(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited){
        System.out.print(s+" ");
        visited[s] = true;
        for( int ad : adj.get(s) ){
            if( visited[ad] == false ){
                DFSRecursive(adj, ad, visited);
            }
        }
    }

}
