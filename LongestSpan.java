package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class LongestSpan {
    public static void main(String[] args) {

    }
    static  int equalSumSpan(int[] a1, int[] a2) {
        Map<Integer,Integer> mp = new HashMap<>();
        int sum1 = 0;
        int sum2 = 0;
        int ans = 0;
        for (int i = 0; i < a1.length; i++) {
            sum1 += a1[i];
            sum2 += a2[i];

            int diff = sum1 - sum2;
            if(diff == 0){
                ans = Math.max(ans,i+1);
            } else if (mp.containsKey(diff)) {
                ans = Math.max(ans,i-mp.get(diff));
            }else{
                mp.put(diff,i);
            }
        }
        return ans;
    }
}
