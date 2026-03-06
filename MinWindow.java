package geeksforgeeks;

public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("timetopractice", "toc"));
    }
    static String minWindow(String s, String p) {
        int[] map = new int[26];
        int l = 0;
        int r = 0;
        int minLength = Integer.MAX_VALUE;
        int sIndex = -1;
        int cnt = 0;
        char[] ch = s.toCharArray();
        for (char c : p.toCharArray()){
            map[c - 'a'] += 1;
        }
        while (r<ch.length){
            if(map[ch[r] - 'a'] > 0){
                cnt = cnt+1;
            }
                map[ch[r] - 'a'] -= 1;
            while (cnt == p.length()){
                if(r - l + 1<minLength){
                    minLength = r -l+1;
                    sIndex = l;
                }
                map[ch[l] - 'a'] += 1;
                if(map[ch[l] - 'a'] > 0) cnt = cnt-1;
                l++;
            }
            r = r+1;

        }
        return sIndex == -1 ? "" : s.substring(sIndex,sIndex+minLength);
    }
}
