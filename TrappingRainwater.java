package geeksforgeeks;

public class TrappingRainwater {
    public static void main(String[] args) {
        System.out.println(maxWater(new int[]{3, 0, 1, 0, 4, 0 ,2}));
    }
    static int maxWater(int arr[]) {
        int n = arr.length;
        int[] left = getLeft(arr,n);

        int[] right = getRight(arr,n);

        int sum = 0;

        for (int i = 0; i < n; i++) {

            int h =  Math.min(left[i],right[i]) - arr[i];

            sum += h;
        }
        return sum;
    }
    static int[] getLeft(int[] arr ,int n){
        int[] left = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1],arr[i]);
        }
        return left;
    }
    static int[] getRight(int[] arr,int n){
        int[] right = new int[n];
        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1],arr[i]);
        }
        return right;
    }

}
