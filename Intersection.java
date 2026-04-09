package geeksforgeeks;
import java.util.*;
public class Intersection {
    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1, 2},new int[]{3, 4}));
    }
    static ArrayList<Integer> intersection(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        Set<Integer> st = new TreeSet<>();
        while (i<a.length&& j<b.length){
            if(a[i] == b[j]){
                st.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            }else{
                j++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(st);

        return ans;
    }
}
