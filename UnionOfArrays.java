package geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnionOfArrays {
    public static void main(String[] args) {
        System.out.println(findUnion(new int[] {1, 2, 3, 2, 1},new int[]{3, 2, 2, 3, 3, 2}));
    }
    static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            st.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            st.add(b[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>(st);
        return ans;
    }
}
