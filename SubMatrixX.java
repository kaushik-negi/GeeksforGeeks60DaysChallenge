package geeksforgeeks;

public class SubMatrixX {
    public static void main(String[] args) {

    }
    static int countSquare(int[][] mat, int x) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] pre = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                pre[row][col] = mat[row][col];
                if(row>0){
                    pre[row][col] += pre[row-1][col];
                }
                if(col>0){
                    pre[row][col] += pre[row][col-1];
                }
                if(row>0 && col>0) {
                    pre[row][col] -= pre[row-1][col-1];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int size = 1; size <= Math.min(rows-i,cols-j); size++) {
                    int r1 = i;
                    int c1 = j;
                    int r2 = i+size-1;
                    int c2 = j+size-1;

                    int sum = pre[r2][c2];
                    if(r1>0){
                        sum -= pre[r1-1][c2];
                    }
                    if(c1>0){
                        sum -= pre[r2][c1-1];
                    }
                    if(r1>0 && c1>0){
                        sum += pre[r1-1][c1-1];
                    }
                    if(sum == x){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
