package geeksforgeeks;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[] {5, 1, 2, 4, 1}));
    }
    static int hIndex(int[] citations) {
        int n = citations.length ;
        Arrays.sort(citations);
        for (int j = 0; j < n; j++) {
            if(citations[j]>=n-j)
                return n-j;
        }
        return 0;
    }
}
