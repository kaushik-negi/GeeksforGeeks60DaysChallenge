package geeksforgeeks;
import java.util.*;
public class LongestSubarray {
    public static void main(String[] args) {

    }
    static int longestSubarray(int[] arr, int k) {
            HashMap<Integer,Integer> mp = new HashMap<>();
            int maxLen = 0;
            int prefixSum = 0;
            for(int i = 0;i<arr.length;i++){
                if(arr[i] >k ) prefixSum++;
                else prefixSum --;

                if(prefixSum > 0){
                    maxLen = i+1;
                }
                if(mp.containsKey(prefixSum - 1)){
                    maxLen = Math.max(maxLen,i-mp.get(prefixSum - 1));
                }
                if(!mp.containsKey(prefixSum)){
                    mp.put(prefixSum,i);
                }

            }
            return maxLen;
        }

}
