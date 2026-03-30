package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair3{
    int n;
    int d;
    Pair3(int n,int d){
        this.n = n;
        this.d = d;
    }
}
public class ConnectAllHouses {
    public static void main(String[] args) {

    }
    static int minCost(int[][] houses) {
        ArrayList<ArrayList<Pair3>> adj = new ArrayList<>();
        for (int i = 0; i < houses.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < houses.length; i++) {
            for (int j = i+1; j < houses.length; j++) {
                int dist = Math.abs(houses[i][0]-houses[j][0])+Math.abs(houses[i][1]-houses[j][1]);

                adj.get(i).add(new Pair3(j,dist));
                adj.get(j).add(new Pair3(i,dist));
            }
        }
        int[] vis = new int[adj.size()];
        Arrays.fill(vis,-1);
        PriorityQueue<Pair3> pq = new PriorityQueue<>((x,y)->x.d-y.d);
        int sum = 0;
        pq.offer(new Pair3(0,0));
        vis[0] = 1;

        while(!pq.isEmpty()){
            Pair3 pa = pq.poll();
            int n = pa.n;
            int d = pa.d;
            if(vis[n] == 1) continue;
            vis[n] = 1;
            sum += d;
            for(Pair3 p : adj.get(n)){
                if(vis[p.n] == -1){
                    pq.offer(new Pair3(p.n,p.d));
                }
            }

        }
        return sum;

    }
}
