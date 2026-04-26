package geeksforgeeks;
import java.util.*;
public class ThreeSortedArrays {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        int alen = a.length;
        int blen = b.length;
        int clen = c.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0,j = 0,k = 0;

        while (i<alen && j<blen && k<clen){
            if(a[i] == b[j] && b[j] == c[k]){
                ans.add(a[i]);
                i++;
                j++;
                k++;
            }else if(a[i]<b[j]){
                i++;
            }else if(b[j]< c[k]){
                j++;
            }else{
                k++;
            }
        }

        return ans;
    }
}
