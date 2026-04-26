package geeksforgeeks;

public class BuildingWithSunlight {
    public static void main(String[] args) {

    }
    int visibleBuildings(int arr[]) {
        int cnt = 1;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] >= max){
                max = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
