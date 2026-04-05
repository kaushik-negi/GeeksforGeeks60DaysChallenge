package geeksforgeeks;
import java.util.*;
public class TargetSum {
    public static void main(String[] args) {
        System.out.println(totalWays(new int[]{1, 2,3},2));
    }
    static int totalWays(int[] arr, int target) {
        int[][] dp = new int[arr.length][2001];
        for (int i = 0; i <arr.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,0,target,dp);
    }
    static int solve(int[] arr,int ind, int target,int[][] dp){
        if(ind == arr.length) {
            if(target == 0) return 1;
            else return 0;
        }
        if(dp[ind][target + 1000] != -1) return dp[ind][target];

        int left = solve(arr, ind+1, target-(arr[ind]),dp);

        int right = solve(arr, ind+1, target + (arr[ind]),dp);

        return dp[ind][target + 1000] = left + right;
    }
}
