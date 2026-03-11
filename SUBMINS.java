package geeksforgeeks;
import java.util.*;
public class SUBMINS {
    public static void main(String[] args) {

    }
    public int sumSubMins(int[] arr) {
            int n = arr.length;
            Stack<Integer> st1 = new Stack<>();
            Stack<Integer> st2 = new Stack<>();
            int ans = 0;
            int[] prev = new int[arr.length];
            for (int i = 0; i < n; i++) {
                while (!st2.isEmpty() && arr[st2.peek()] > arr[i]){
                    st2.pop();
                }
                prev[i] = st2.isEmpty() ? -1: st2.peek();

                st2.push(i);
            }

            for (int i = n-1; i >= 0; i--) {
                while (!st1.isEmpty() && arr[st1.peek()] >= arr[i]){
                    st1.pop();
                }
                int nextSmaller = st1.isEmpty() ? n : st1.peek();
                int prevSmaller = prev[i];
                ans+= (i-prevSmaller)*(nextSmaller - i) * arr[i];
                st1.push(i);
            }

            return ans;

        }

}
