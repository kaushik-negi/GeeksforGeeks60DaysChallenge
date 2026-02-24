package geeksforgeeks;
import java.util.*;

public class MissingElementInRange {
    public static void main(String[] args) {
        int[] arr = {10, 12, 11, 15};
        System.out.println(missingRange(arr,50,55));
    }
    static ArrayList<Integer> missingRange(int[] arr, int low, int high) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        ArrayList<Integer> li = new ArrayList<>();
//        li.addAll(Arrays.stream(arr).boxed().toList());
//        Collections.sort(li);
//        low = low+1;
//        while(low<=high){
//            if(li.contains(Integer.valueOf(low))){
//                low ++;
//            }else{
//                ans.add(low);
//                low++;
//            }
//        }
//        return ans;
        HashSet<Integer> st = new HashSet<>();

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            st.add(arr[i]);
        }
        low = low+1;
        for (int i = low; i <=high ; i++) {
            if(!st.contains(Integer.valueOf(i))){
                ans.add(i);
            }
        }
        return ans;


    }
}
