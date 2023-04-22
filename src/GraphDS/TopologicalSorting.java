package GraphDS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);

        TopologicalSortingDFS(adj);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v){
        adj.get(u).add(v);
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
