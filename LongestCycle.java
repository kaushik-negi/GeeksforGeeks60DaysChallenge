package geeksforgeeks;

import java.util.*;

public class LongestCycle {
    public static void main(String[] args) {

    }
    static int longestCycle(int V, int[][] edges) {
        int[] adj = new int[V];
        Arrays.fill(adj,-1);

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u] = v;
        }

        int[] vis = new int[V];

        int ans = -1;

        for (int i = 0; i < V; i++) {
            if(vis[i] == 1) continue;

            Map<Integer,Integer> mp = new HashMap<>();

            int node = i;

            int step = 0;

            while (node != -1 && vis[node] == 0){
                vis[node] = 1;
                mp.put(node,step++);

                node = adj[node];

                if(node != -1 && mp.containsKey(node)){
                    int cycleLength = step - mp.get(node);

                    ans = Math.max(ans,cycleLength);
                    break;
                }
            }
        }
        return ans;
    }
}
