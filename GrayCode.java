package geeksforgeeks;

import CP2A.Array;

import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(graycode(3));
    }
    static ArrayList<String> graycode(int n) {
        ArrayList<String> ans = new ArrayList<>();
        solve(new StringBuilder(),ans,n,false);

        return ans;
    }

    static void solve(StringBuilder str ,ArrayList<String> ans,int n,boolean toggle){
        if(str.length() == n){
            ans.add(str.toString());
            return ;
        }
        if(!toggle) {
            str.append('0');
            solve(str, ans, n, false);
            str.deleteCharAt(str.length() - 1);
            str.append('1');
            solve(str, ans, n, true);
            str.deleteCharAt(str.length() - 1);
        }else{
            str.append('1');
            solve(str, ans, n, false);
            str.deleteCharAt(str.length() - 1);
            str.append('0');
            solve(str, ans, n, true);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
