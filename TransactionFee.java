package geeksforgeeks;
import java.util.*;
public class TransactionFee {
    public static void main(String[] args) {

    }
    static int maxProfit(int arr[], int k) {
        int[][] dp = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i],-1);
        }
       return solve(0,arr,k,0,dp);
    }

    static int solve(int ind,int[] arr,int k,int have,int[][] dp){
        if(ind >= arr.length){
            return 0;
        }
        if(dp[ind][have] != -1) return dp[ind][have];
        int take = 0;
        int notTake = 0;
        if(have == 0){
          take = (-arr[ind]) + solve(ind+1, arr, k, 1,dp);

          notTake = solve(ind+1, arr, k,  0,dp);
        }else{
           take = (arr[ind] - k)+solve(ind+1, arr, k,0,dp);
           notTake =  solve(ind+1, arr, k, 1,dp);
        }

        return dp[ind][have] = Math.max(take,notTake);
    }
}
