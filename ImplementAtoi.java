package geeksforgeeks;

public class ImplementAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("    -7awd"));
    }
    static int myAtoi(String s) {
        int n = s.length();
        int sign = 1;
        int i = 0;
       while (i<n && s.charAt(i) == ' ') i++;
       if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
           if(s.charAt(i) == '-') sign = -1;
           i++;
       }
        long sum = 0;
        while (i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';


            if(sum > (Integer.MAX_VALUE-digit)/10) return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;


            sum = sum*10 + digit;

            i++;
        }

        return (int)(sign*sum);
    }
}
