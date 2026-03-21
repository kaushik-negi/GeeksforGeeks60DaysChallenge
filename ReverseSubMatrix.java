package geeksforgeeks;

public class ReverseSubMatrix {
    public static void main(String[] args) {

    }
    static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int r = x+k-1;
        int c = y+k-1;
        for (int row = x; row <= r; row++) {
            for (int col = y; col <= c; col++) {
                int temp = grid[row][col];
                grid[row][col] =  grid[r][col];
                grid[r][col] = temp;
            }
        }
        return grid;
    }
}
