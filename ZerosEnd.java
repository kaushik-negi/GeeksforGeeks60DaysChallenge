package geeksforgeeks;

public class ZerosEnd {
    public static void main(String[] args) {

    }
    static void pushZerosToEnd(int[] arr) {
        int j = -1 ;
        for ( int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }
        for (int i = j+1; i < arr.length; i++) {
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
