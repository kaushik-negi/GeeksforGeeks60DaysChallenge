package geeksforgeeks;
import java.util.*;

public class ClosestPair {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int j = arr2.length - 1;
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        while(i<arr1.length && j>=0){
            sum += arr1[i] + arr2[j];
            int currdiff = Math.abs(sum-x);
            if(currdiff < diff){
                diff = currdiff;
                arr.add(0,arr1[i]);
                arr.add(1,arr2[j]);
            }
            if(sum>x){
                j--;
            }else{
                i++;
            }
        }
        return arr;
    }
}
