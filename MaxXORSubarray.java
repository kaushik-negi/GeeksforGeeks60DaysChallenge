package geeksforgeeks;

public class MaxXORSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubarrayXOR(new int[]{1,2,4,5,6},2));
    }
    static int maxSubarrayXOR(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int xor = 0;
        int maxXor = Integer.MIN_VALUE;
        while(right< arr.length) {
            xor = xor^arr[right];
            if (right - left+1>k) {
                xor = xor^arr[left];
                left++;
            }
            if (right - left+1 == k){
                maxXor = Math.max(maxXor,xor);
            }
            right++;

        }
        return maxXor;
    }
}
