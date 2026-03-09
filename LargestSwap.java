package geeksforgeeks;

public class LargestSwap {
    public static void main(String[] args) {

    }
    static String largestSwap(String s) {
        char[] ch = s.toCharArray();
        int[] arr = new int[10];

        for (int i = 0; i < ch.length; i++) {
            arr[ch[i] - '0'] = i;
        }
        for (int i = 0; i < ch.length; i++) {
            for (int j = 9; j > ch[i]-'0'; j--) {
                if(arr[j] > i){
                    char temp = ch[i];
                    ch[i] = ch[arr[j]];
                    ch[arr[j]] = temp;

                    return new String(ch);
                }
            }
        }
        return s;
    }
}
