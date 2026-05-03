package geeksforgeeks;

public class LongestRepeatingCharacters {
    public static void main(String[] args) {

    }
    static int longestSubstr(String s, int k) {
        int ans = 0;
        int n = s.length();

        for(char ch = 'A';ch<='Z';ch++){
            int i = 0;
            int j = 0;
            int rem = k;
            while (j<n){
                if(s.charAt(j) != ch && rem == 0){
                    while (i<=j && s.charAt(i) == ch) {
                        i++;
                    }
                i++;
                rem++;
                }
            if(s.charAt(j) != ch && rem > 0){
                rem--;
            }
            ans = Math.max(ans,j-i+1);
            j++;
            }
        }
        return ans;
    }
}
