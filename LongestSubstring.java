package geeksforgeeks;

import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(longestKSubstr("aabacbebebe",3));
    }
    static int longestKSubstr(String s, int k) {
        char[] ch = s.toCharArray();
        Map<Character,Integer> mp = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
       while (right < ch.length){
            mp.put(ch[right],mp.getOrDefault(ch[right],0)+1);
            if(mp.size() == k){
                max = Math.max(max,right - left+1);
            }
            if(mp.size() > k){
                mp.put(ch[left], mp.get(ch[left]) - 1);
                if(mp.get(ch[left]) == 0){
                    mp.remove(ch[left]);
                }
                left++;
           }
            right++;
        }
       if(max == Integer.MIN_VALUE) return -1;
       return max;
    }
}
