package geeksforgeeks;

import java.util.*;

public class KSumPaths {
    public static void main(String[] args) {

    }
    static int countAllPaths(Node root, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int[] cnt = new int[1];
        solve(root,cnt,k,mp,0);
        return cnt[0];
    }
    static void solve(Node root,int[] cnt ,int k,Map<Integer,Integer> mp ,int currSum){
        if(root == null) return;

        currSum += root.data;
        if(currSum == k){
            cnt[0]++;
        }
        if(mp.containsKey(currSum-k)){
            cnt[0] += mp.get(currSum-k);
        }

        mp.put(currSum , mp.getOrDefault(currSum,0)+1);

        solve(root.left, cnt, k, mp, currSum);
        solve(root.right, cnt, k, mp, currSum);
        mp.put(currSum,mp.get(currSum)-1);
    }
}
