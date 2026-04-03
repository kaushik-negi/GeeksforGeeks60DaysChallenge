package geeksforgeeks;
import java.util.*;
public class DiagView {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(diagView(mat));
    }
    static ArrayList<Integer> diagView(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;

        ArrayList<Integer> ans = new ArrayList<>();
        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(vis[i][j] == 0){
                    int k = i;
                    int l = j;

                    while (k>=0 && l>=0 && k<m && l<n){
                        vis[k][l] = 1;
                        ans.add(mat[k][l]);
                        k++;
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}
