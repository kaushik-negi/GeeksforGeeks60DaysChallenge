package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        System.out.println(inversionCount(arr));
    }
    static int inversionCount(int arr[]) {
        if(arr.length <= 1) return 0;
       int count =  mergeSort(arr,0,arr.length-1,0);
        return count;
    }
    static int mergeSort(int[] arr,int low,int high,int sum){
        if(low >= high) return 0;
        int mid = low + (high-low)/2;

        int a = mergeSort(arr,low,mid,sum);
        int b = mergeSort(arr,mid+1,high,sum);

        sum += merge(arr,low,mid,high) + a + b;
        return sum;
    }

    static int merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        int count = 0;
        List<Integer> temp = new ArrayList<>();
        while (left<=mid&&right<=high){
            if(arr[left] > arr[right]) {
                temp.add(arr[right]);
                count += mid-left+1;
                right++;
            }else {
                temp.add(arr[left]);
                left++;
            }
        }
        while (left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while (right<= high){
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i-low);
        }
        return count;
    }
}
