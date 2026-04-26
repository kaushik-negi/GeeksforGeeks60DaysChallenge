package geeksforgeeks;
import java.util.*;
public class OppositeSign {
    public static void main(String[] args) {
        System.out.println(reducePairs(new int[]{10, -5, -8, 2, -5}));
    }
    static ArrayList<Integer> reducePairs(int[] arr) {
        int n = arr.length;
        if(n == 0) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : arr) {
            ans.add(x);
            while (ans.size()>=2) {
                int top = ans.getLast();
                int second = ans.get(ans.size() - 2);
                if (top * second < 0) {
                    ans.removeLast();
                    ans.removeLast();
                    if (Math.abs(top) == Math.abs(second)) {
                        continue;
                    } else if (Math.abs(top) > Math.abs(second)) {
                        ans.add(top);
                    } else {
                        ans.add(second);
                    }
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
