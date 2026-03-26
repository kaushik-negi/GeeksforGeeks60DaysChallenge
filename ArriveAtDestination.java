package geeksforgeeks;

import java.util.*;
class Pair2 {
    int node;
    int time;
    Pair2(int node, int time){
        this.node = node;
        this.time = time;
    }
}
public class ArriveAtDestination {
    public static void main(String[] args) {
        int[][] edges =  {{0, 2, 3}, {0, 4, 2}, {0, 5, 7}, {2, 3, 1}, {2, 5, 5}, {5, 3, 3}, {5, 1, 4}, {1, 4, 1}, {4, 5, 5}};

        System.out.println(countPaths(6,edges));
    }
    static int countPaths(int V, int[][] edges) {
        ArrayList<ArrayList<Pair2>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int t = edges[i][2];
            adj.get(u).add(new Pair2(v,t));
            adj.get(v).add(new Pair2(u,t));
        }

        int[] dis = new int[V];
        int[] ways  = new int[V];
        ways[0] = 1;
        Arrays.fill(dis,(int)1e9);

        PriorityQueue<Pair2> q = new PriorityQueue<>((x, y)->y.time-x.time);

        q.offer(new Pair2(0,0));

        dis[0] = 0;
        while (!q.isEmpty()){
            Pair2 pair = q.poll();
            int node = pair.node;
            int time = pair.time;

            for(Pair2 p : adj.get(node)){
                if(p.time + time <dis[p.node]){
                    ways[p.node] = ways[node];
                    dis[p.node] = p.time + time;
                    q.offer(new Pair2(p.node,p.time + time));
                } else if (p.time + time == dis[p.node]) {
                    ways[p.node] += ways[node];
                }

            }
        }
        return ways[V-1];
    }
}
