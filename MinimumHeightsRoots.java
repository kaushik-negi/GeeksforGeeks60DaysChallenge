package geeksforgeeks;
import java.util.*;
public class MinimumHeightsRoots {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        if(V == 1) {
            res.add(0);
            return res;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] inDegree = new int[V];

        for (int i = 0; i < adj.size(); i++) {
            for(int j : adj.get(i)){
                inDegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 1) q.add(i);
        }
        int remainingNodes = V;
        while (remainingNodes > 2){
            int size = q.size();
            remainingNodes-=size;
            for(int i = 0;i<size;i++){
                int node = q.poll();
                for(int j : adj.get(node)) {
                    inDegree[j]--;
                    if (inDegree[j] == 1) q.offer(j);
                }
            }
        }
        while (!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }
}
