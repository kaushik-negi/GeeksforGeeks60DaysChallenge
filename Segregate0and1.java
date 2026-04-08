package geeksforgeeks;

public class Segregate0and1 {
    public static void main(String[] args) {

    }
    static void segregate0and1(int[] arr) {
        int i = -1;
        for(int j = 0 ;j < arr.length;j++){
            if(arr[j] == 1){
                i = j;
                break;
            }
        }
        if(i == -1) return ;
        int j = i+1;
        while(j < arr.length){
            if(arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
    }
}
