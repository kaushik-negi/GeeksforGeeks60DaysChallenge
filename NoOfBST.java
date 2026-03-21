package geeksforgeeks;
import java.util.*;
public class NoOfBST {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;

        Map<Integer,Integer> mp = new HashMap<>();

            for (int i = 0; i < n; i++) {
                mp.put(arr[i],i);
            }

            Arrays.sort(arr);

            ArrayList<Integer> fact = new ArrayList<>();
            fact.add(1);
        for (int i = 1; i <= 2*n ; i++) {
            fact.add(i*fact.get(i-1));
        }
        ArrayList<Integer> ans = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n-i-1;

            int val = (catalan(l,fact)*catalan(r,fact));

            ans.add(mp.get(arr[i]),val);
        }
        return ans;

    }
    static int modPow(int a,int b,int mod){
        int ans = 1;
        while (b>0){
            if(b%2 == 1){
                ans = ans *a;
            }
            b = b/2;
            a = a*a;
        }
        return ans;
    }
    static int catalan(int x ,ArrayList<Integer> fact){
        int ans = fact.get(2*x);

        ans = ans * modPow(fact.get(x+1),1000000005,1000000007);
        ans = ans * modPow(fact.get(x),1000000005,1000000007 );
        return ans;
    }

}
