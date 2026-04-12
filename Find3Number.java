package geeksforgeeks;
import java.util.*;
public class Find3Number {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = arr[0];
        max[n-1] = arr[n-1];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 1;i<n;i++){
            min[i] = Math.min(arr[i],min[i-1]);

        }
        for(int i = n-2;i>=0;i--){
            max[i] = Math.max(arr[i],max[i+1]);

        }

        for(int i = 1;i<n-1;i++){
            if(arr[i] > min[i] && arr[i] < max[i]){
                ans.add(min[i]);
                ans.add(arr[i]);
                ans.add(max[i]);
                return ans;
            }
        }
        return ans;
    }
}
