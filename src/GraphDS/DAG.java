package GraphDS;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DAG {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdgeDirected(0, 1, 1);
        g.addEdgeDirected(0, 2, 4);
        g.addEdgeDirected(1, 2, -3);
        g.addEdgeDirected(1, 3, 2);
        g.addEdgeDirected(2, 3, 3);

        g.bellmanFordAlgorithm(0);
        
    }
    static class Graph{
        private int totalNode;
        private static ArrayList<ArrayList<WeightedNodes>> adj;
        Graph(int V){
            this.totalNode = V;
            adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
        }
        void addEdgeDirected(int u,int v,int weight){
            WeightedNodes wtdNode = new WeightedNodes(v, weight);
            adj.get(u).add(wtdNode);
        }
        void addEdgeUndirected(int u,int v,int weight){
            WeightedNodes wtdNodeV = new WeightedNodes(v, weight);
            WeightedNodes wtdNodeU = new WeightedNodes(u, weight);
            adj.get(u).add(wtdNodeV);
            adj.get(v).add(wtdNodeU);
        }
        void KosarajuAlgorithm(){
            Stack<Integer> st = new Stack<>();
            boolean[] visited = new boolean[adj.size()];
            for(int i=0;i<adj.size();i++){
                if( visited[i] == false ){
                    fillOrder(i,visited,st);
                }
            }
            Graph gr = getTranspose(adj);

            visited = new boolean[adj.size()];

            while( !st.isEmpty() ){
                int nd = st.pop();
                if( visited[nd] == false ){
                    gr.DFSUtil(nd, visited);
                    System.out.println();
                }
            }
        }
        Graph getTranspose(ArrayList<ArrayList<WeightedNodes>> adjNew){
            Graph gr = new Graph(this.totalNode);
            for(int i=0;i<totalNode;i++){
                for( WeightedNodes wt : adjNew.get(i) ){
                    gr.addEdgeDirected(wt.getV(), i, 1);
                }
            }
            return gr;
        }
        void DFSUtil(int v , boolean[] visited){
            visited[v] = true;
            System.out.print(v+" ");
            for( WeightedNodes wt : adj.get(v) ){
                if( visited[wt.getV()] == false ) DFSUtil(wt.getV(), visited);
            }
        }
        void fillOrder(int i,boolean[] visited,Stack<Integer> st){
            visited[i] = true;
    
            for( WeightedNodes wt : adj.get(i) ){
                if( !visited[wt.getV()] ){
                    fillOrder(wt.getV(), visited, st);
                }
            }
            st.push(i);
        }
        void DjikstraAlgorithm(int s){
            PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1] );
            int[] distance = new int[adj.size()];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[s] = 0;
            for( int i = 0;i<adj.size();i++ ){
                pq.add(new int[]{i,distance[i]});
            }
            HashSet<Integer> set = new HashSet<>();
            while( set.size() < adj.size() ){
                if( pq.isEmpty() ) break;
                int[] mid = pq.poll();
                if( set.contains(mid[0]) ) continue;
                set.add(mid[0]);
                for( WeightedNodes node : adj.get(mid[0]) ){
                    if( ! set.contains(node.getV()) ){
                        if( distance[node.getV()] > distance[mid[0]] + node.getWeight() ){
                            distance[node.getV()]  = distance[mid[0]] + node.getWeight();
                        }
                        pq.add(new int[]{node.getV(),distance[node.getV()]});
                    }
                    
                }

            }
            System.out.println(Arrays.toString(distance));

        }
        void bellmanFordAlgorithm(int s){
            int[] distance = new int[adj.size()];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[s] = 0;

            for( int i=0;i<totalNode-1;i++ ){

                for( int u = 0;u<adj.size();u++){
                    for( WeightedNodes node : adj.get(u) ){
                        if( distance[node.getV()] > distance[u] + node.getWeight() ){
                            distance[node.getV()]  = distance[u] + node.getWeight();
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(distance));
        }
        static ArrayList<Integer> TopologicalSortingBFS(){
            ArrayList<Integer> arl = new ArrayList<>();
            int[] indegree = new int[adj.size()];
            for( int i = 0;i<adj.size();i++ ){
                for( WeightedNodes v : adj.get(i)){
                    indegree[v.getV()]++;
                }
            }
            Queue<Integer> qu = new ArrayDeque<Integer>();
            for(int i=0;i<adj.size();i++){
                if( indegree[i] == 0 ) qu.add(i);
            }
            
            while( !qu.isEmpty() ){
                int curr = qu.poll();
                arl.add(curr);
                for( WeightedNodes v : adj.get(curr) ){
                    indegree[v.getV()]--;
                    if( indegree[v.getV()] == 0 ) qu.add(v.getV()); 
                }
            }
            return arl;
        }
        void shortestPathDAG(int source){
            int[] dist = new int[adj.size()];
            Arrays.fill(dist, Integer.MAX_VALUE);

            ArrayList<Integer> topologicalSorted = TopologicalSortingBFS();
            dist[source] = 0;
            for( int node : topologicalSorted ){
                for( WeightedNodes v : adj.get(node) ){
                    if( dist[v.getV()] > dist[node]+v.getWeight() ){
                        dist[v.getV()] = dist[node]+v.getWeight();
                    }
                }
            }
            System.out.println(Arrays.toString(dist));
        }

    }
    
}
