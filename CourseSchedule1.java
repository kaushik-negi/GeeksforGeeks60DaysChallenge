package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule1 {
    public static void main(String[] args) {

    }
    static boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for(Integer j : adj.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(indegree[i]);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.poll();
            arr.add(node);
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0) q.offer(i);
            }
        }
        if(arr.size() == n) return true;

        return false;
     }
}
