package geeksforgeeks;

import java.util.Deque;
import java.util.LinkedList;

public class KBitFlips {
    public static void main(String[] args) {

    }
    static int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flips = 0;
        int flipFromPast = 0;
//        boolean[] isFlipped = new boolean[n];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(i>=k){
                flipFromPast -= dq.removeFirst();
            }

            if(flipFromPast%2 == arr[i]){
                if(i+k > n){
                    return -1;
                }

                flipFromPast+= 1;
                flips++;
                dq.addLast(1);
            }else {
                dq.addLast(0);
            }
        }
        return flips;
    }
}
