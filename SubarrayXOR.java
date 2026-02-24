package geeksforgeeks;

import java.util.HashMap;

public class SubarrayXOR {
    public static void main(String[] args) {
        System.out.println(subarrayXor(new int[]{4,2,2,6,4},6));
    }
    static long subarrayXor(int arr[], int k) {
        int  xr = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(xr,1);
        long cnt = 0;
        for (int i = 0; i < arr.length;i++) {
            xr = xr^arr[i];
            int x = xr ^ k;
            cnt += mp.getOrDefault(x,0);
            mp.put(xr,mp.getOrDefault(xr,0)+1);
        }
        return cnt;
    }

}
