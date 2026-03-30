package geeksforgeeks;

public class ChoclatePickup {
    public static void main(String[] args) {

    }
    static int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = {-1,0,1};
        int[][][] dp = new int[n][m][m];
        for(int i = 0; i < n; i++){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    dp[i][j1][j2] = -1;
                }
            }
        }
        return helper(0,0,m-1,grid,n,m,arr,dp);
    }
    static int helper(int i,int j ,int y,int[][] grid,int n,int m,int[] arr,int[][][] dp){
        if(i<0 || j<0 || y<0 || i>=n || j>=m|| y>=m){
            return -(int)1e9;
        }
        int maxi = -(int)1e9;
        if(i == n-1){
            if(j == y) return  grid[i][j];
            else return grid[i][j] + grid[i][y];
        }
        if(dp[i][j][y] != -1){
            return dp[i][j][y];
        }
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int next = helper(i+1,j+arr[k],y+arr[l],grid,n,m,arr, dp);
                maxi = Math.max(next , maxi) ;
            }
        }
        int current = (j == y)?grid[i][j] : grid[i][j] + grid[i][y];
        return dp[i][j][y] = current + maxi;
    }
}
