package geeksforgeeks;

public class ConsecutiveOnes {
    public static void main(String[] args) {

    }
    static  int countStrings(int n) {
        int pZero = 1;
        int pOne = 1;

        for (int i = 2; i <= n; i++) {
            int zero = pZero + pOne;

            int one = pZero;

            pZero = zero;

            pOne = one;
        }
        return pZero+pOne;
    }
}
