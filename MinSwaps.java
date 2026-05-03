package geeksforgeeks;

public class MinSwaps {
    public static void main(String[] args) {

    }
        static int minSwaps(int[] arr) {
            int n = arr.length;
            int cnt = 0;
           for (int i : arr){
               if(i == 1) cnt+=1;
           }
           int l = 0;
           int windowOnes =0,max_window = 0;
           for (int i = 0 ;i<arr.length*2;i++) {
               if(arr[i%n] == 1){
                   windowOnes += 1;
               }
               if(i-l+1 > cnt){
                   windowOnes -= arr[l%n];
                   l+=1;
               }
               max_window = Math.max(max_window,windowOnes);
           }
           return cnt - max_window;
        }
}
