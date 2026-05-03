package geeksforgeeks;
import java.util.*;
public class SortBySetBit {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 9, 4, 6, 7, 15, 32};
        sortBySetBitCount(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sortBySetBitCount(int[] arr) {
        TreeMap<Integer,ArrayList<Integer>> mp = new TreeMap<>();
        for (int value : arr) {
            int cnt = 0;
            int k = value;
            while (k > 0) {
                int j = k & 1;
                if (j == 1) cnt += 1;
                k = k >> 1;
            }
            ArrayList<Integer> a = mp.getOrDefault(cnt, new ArrayList<>());
            a.add(value);
            mp.put(cnt, a);
        }

        int l = 0;
        for (int i = mp.size()-1;i>=0;i--){
            int k = mp.lastKey();
            ArrayList<Integer> a = mp.get(k);
            mp.remove(k);
            for (int j : a){
                arr[l++] = j;
            }
        }
    }
}
