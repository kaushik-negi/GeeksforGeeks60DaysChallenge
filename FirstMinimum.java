package geeksforgeeks;

import java.util.Stack;

public class FirstMinimum {
    public static void main(String[] args) {

    }
    static int countSubarrays(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            int nextSmaller = st.isEmpty() ? n : st.peek();
            ans+= nextSmaller-i;
            st.push(i);
        }
        return ans;
    }
}
