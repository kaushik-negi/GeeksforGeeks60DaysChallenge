package geeksforgeeks;

import java.util.HashSet;
import java.util.Set;

public class hasAllCodes {
    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110",2));
    }
    static boolean hasAllCodes(String s, int k) {
        if(k>s.length()){
            return false;
        }
        int i = 0;
        int j = k-1;
        Set<String> st = new HashSet<>();
        while(j < s.length()){
            st.add(s.substring(i,j+1));
            i++;
            j++;
        }
        if(st.size() != Math.pow(2,k)) return false;

        return true;

    }
}
