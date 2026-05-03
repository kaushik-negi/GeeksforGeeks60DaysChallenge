package geeksforgeeks;

import java.util.*;

public class SmallestWindow {
    public static void main(String[] args) {
        System.out.println(smallestSubstring("11111002102"));
    }
    static int smallestSubstring(String s) {
        int n = s.length();
        if(n<3) return -1;
        HashMap<Character,Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(j<n){
            mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)+1);

            while (mp.size() == 3 && i<j){
                min = Math.min(min,j-i+1);

                mp.replace(s.charAt(i),mp.get(s.charAt(i))-1);
                if(mp.get(s.charAt(i)) == 0){
                    mp.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}
