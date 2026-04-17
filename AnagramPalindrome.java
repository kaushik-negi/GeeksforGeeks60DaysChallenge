package geeksforgeeks;

public class AnagramPalindrome {
    public static void main(String[] args) {
        System.out.println(canFormPalindrome("baba"));
    }
    static boolean canFormPalindrome(String s) {
        boolean oneOdd = false;
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(arr[i]%2 != 0){
                if(oneOdd) return false;
                if(!oneOdd) oneOdd = true;
            }
        }

        return true;
    }
}
