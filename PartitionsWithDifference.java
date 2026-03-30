package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;

public class PartitionsWithDifference {
    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{1,1,1,1},0));
    }
    static int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if((totalSum + diff)%2 != 0) return 0;
        int target = (totalSum+diff)/2;
        int[][] dp = new int[arr.length][target+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
       return solve(0,arr,target,dp);

    }
    static int solve(int i,int[] arr,int target,int[][] dp){
        if(target < 0) return 0;
        if(i>=arr.length){
            if(target == 0) return 1;
            return 0;
        }
        if(dp[i][target] != -1) return dp[i][target];

        int take = solve(i+1,arr,target - arr[i],dp);
        int notTake = solve(i+1,arr,target,dp);

        return dp[i][target] = take+notTake;
    }
}
