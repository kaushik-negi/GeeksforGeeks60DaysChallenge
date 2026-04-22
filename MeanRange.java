package geeksforgeeks;
import java.util.*;
public class MeanRange {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(arr.length == 0) return ans;
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int sum = prefix[r] - (l>0 ? prefix[l-1] : 0);
            ans.add(sum/(r-l+1));
        }

        return ans;
    }
}
