package geeksforgeeks;
import java.util.*;
public class PythagonTriplet {
    public static void main(String[] args) {
        System.out.println(pythagoreanTriplet(new int[]{3, 2, 4, 6, 5}));
    }
    static boolean pythagoreanTriplet(int[] arr) {
        HashSet<Integer> st  = new HashSet<>();

        for (int i : arr){
            st.add(i*i);
        }
        for(int a : st){
            for (int b : st){
                if(a!=b){
                    if(st.contains(a+b)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
