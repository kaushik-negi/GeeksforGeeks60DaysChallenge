package geeksforgeeks;

public class NextSmallerPalindrome {
    public static void main(String[] args) {

    }
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        if(all9s(num)){
            int[] arr = new int[n+1];
            arr[0] = 1;
            arr[n] = 1;
            return arr;
        }

        int[] ans = num.clone();

        int mid = n/2;
        int i = mid - 1;
        int j = (n%2 == 0) ? mid + 1:mid;

        boolean leftSmaller = false;

        while (i>=0 && ans[i] == ans[j]){
            i--;
            j++;
        }

        if(i<0 || ans[i] < ans[j]){
            leftSmaller = true;
        }

        while (i>=0){
            ans[j] = ans[i];
            i--;
            j++;
        }

        if(leftSmaller){
            int carry = 1;

            i = mid-1;

            if(n%2 == 1){
                ans[mid] += carry;
                carry = ans[mid]/10;
                ans[mid] %= 10;
                j = mid+1;
            }else {
                j = mid;
            }


            while (i>=0){
                ans[i] += carry;
                carry = ans[i]/10;
                ans[i] %= 10;

                ans[j] = ans[i];
                i--;
                j++;
            }
        }
        return ans;
    }
    static boolean all9s(int[] num){
        for(int d : num){
            if(d!=9){
                return false;
            }
        }
        return true;
    }
}
