package geeksforgeeks;

import java.awt.geom.QuadCurve2D;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int r;
    int c;
    int t;
    Pair(int r,int c,int t){
        this.r = r;
        this.c = c;
        this.t = t;
    }
}
public class RottenOranges {
    public static void main(String[] args) {

    }
    static int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int time = Integer.MIN_VALUE;
        while (!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int t = p.t;
            time = Math.max(t,time);
            for (int i = 0; i < 4; i++) {
                int nR = r + delRow[i];
                int nC = c + delCol[i];

                if(nR >=0 && nR < n && nC >= 0 && nC < m && vis[nR][nC] == 0){
                    vis[nR][nC] = 1;
                    q.offer(new Pair(nR,nC,t+1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && mat[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
}
