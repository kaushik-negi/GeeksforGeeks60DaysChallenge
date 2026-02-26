package geeksforgeeks;

import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {

    }
    static boolean areIsomorphic(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        Map<Character,Character> mp = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(!mp.containsKey(ch1) ){
                if(mp.containsValue(ch2)){
                    return false;
                }
                mp.put(ch1,ch2);
            }else{
                if(mp.get(ch1) != ch2) return false;

            }
        }

        return true;
    }
}
