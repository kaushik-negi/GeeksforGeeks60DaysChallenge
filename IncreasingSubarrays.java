package geeksforgeeks;

public class IncreasingSubarrays {
    public static void main(String[] args) {
        System.out.println(countIncreasing(new int[]{1, 4, 5, 3, 7, 9}));
    }
    static int countIncreasing(int[] arr) {
        int i = 0;
        int j = 1;
        int maxcnt = 0;
        int cnt = 0;
        while (j<arr.length){
            if(arr[j]>arr[i]){
                cnt = cnt + 1;
                maxcnt += cnt;
                j++;
                i++;
            } else {
                cnt = 0;
                i++;
                j++;

            }
        }
        return maxcnt;
    }
}
