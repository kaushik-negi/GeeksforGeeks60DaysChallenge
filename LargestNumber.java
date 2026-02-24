package geeksforgeeks;
import java.util.*;
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1,2,0,0} ,34));
    }
    static String findLargest(int[] arr) {
        if(arr.length == 0) return "";
        if(arr.length == 1) return arr[0]+"";
        StringBuilder str = new StringBuilder();
        String[] str1 = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str1[i] = arr[i] + "";
        }
        Arrays.sort(str1, (a, b) -> (b + a).compareTo(a + b));
        if(str1[0].equals("0")) return "0";
        for (int i = 0; i < str1.length; i++) {
            str.append(str1[i]);
        }
        return str.toString();
    }
    public static List<Integer> addToArrayForm(int[] num, int k) {
            int carry = 0;
            int i = num.length-1;
            List<Integer> ans = new ArrayList<>(num.length);
             while(k>0  && i>=0){
                int j = k%10;
                if(num[i] + j + carry > 9){
                    ans.add((num[i] + j + carry)%10);
                    carry =  (num[i] + j)/10;
                }else{
                    ans.add((num[i] + j + carry));
                }
                k = k/10;
                i--;
            }
            if(carry == 0) return ans;
            ans.add(carry);
            return ans;
    }
    static String makeLargestSpecial(String s) {
        return solve(s.toCharArray(),0,0);
    }
    public static String solve(char[] ch,int start ,int end){
        int sum = 0;
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0;i<ch.length;i++){
            sum += ch[i] == '1' ? 1:-1;
            if(sum == 0){
                arr.add("1" + solve(ch,start+1,i-start-1)+"0");
                start = i+1;
            }

        }
        arr.sort((a, b) -> (b + a).compareTo(a + b));
        StringBuilder ans = new StringBuilder();
        for (String str : arr) {
            ans.append(str);
        }
        return ans.toString();
    }
}
