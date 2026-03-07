package geeksforgeeks;

public class DiceThrow {
    public static void main(String[] args) {

    }
    static int noOfWays(int m, int n, int x) {
        int[][] mat = new int[n+1][x+1];
        mat[0][0] = 1;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < x+1; j++) {
                int ways = 0;
                for (int k = 1; k <= m; k++) {
                    if(j>=k){
                        ways = ways + mat[i-1][j-k];
                    }
                }
                mat[i][j] = ways;
            }
        }
        return mat[n-1][x-1];
    }
}
