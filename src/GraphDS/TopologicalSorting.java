package GraphDS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        addEdgeDirected(adj, 0, 1);
        addEdgeDirected(adj, 1, 2);
        addEdgeDirected(adj, 2, 1);
        addEdgeDirected(adj, 1, 3);
        addEdgeDirected(adj, 3, 4);
        addEdgeDirected(adj, 4, 5);
        addEdgeDirected(adj, 5, 4);

        TopologicalSortingDFS(adj);
    }

    public static void addEdgeDirected(ArrayList<ArrayList<Integer>> adj, int u,int v){
        adj.get(u).add(v);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void TopologicalSortingBFS(ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[adj.size()];
        for( int i = 0;i<adj.size();i++ ){
            for( int v : adj.get(i)){
                indegree[v]++;
            }
        }
        Queue<Integer> qu = new ArrayDeque<Integer>();
        for(int i=0;i<adj.size();i++){
            if( indegree[i] == 0 ) qu.add(i);
        }
        
        while( !qu.isEmpty() ){
            int curr = qu.poll();
            System.out.print(curr+" ");
            for( int v : adj.get(curr) ){
                indegree[v]--;
                if( indegree[v] == 0 ) qu.add(v); 
            }
        }

        System.out.println("");

    }
    public static void TopologicalSortingDFS(ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        for( int i = 0;i<adj.size();i++ ){
            if( visited[i] == false ){
                DFSTopological(adj,st,visited,i);
            }
        }

        while( !st.isEmpty() ){
            System.out.print(st.pop()+" ");
        }
        System.out.println("");

    }
    public static void DFSTopological(ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] visited,int i){
        visited[i] = true;
        for( int ad : adj.get(i) ){
            if( visited[ad] == false ){
                DFSTopological(adj, st, visited, ad);
            }
        }
        st.push(i);
    }

    
}
