package geeksforgeeks;

public class WaterJugProblem {
    public static void main(String[] args) {

    }
    static int minSteps(int m, int n, int d) {
        if(d> Math.max(m,n)) return -1;

        if(d % gcd(m,n) != 0) return -1;

        int ans1 = pour(m,n,d);
        int ans2 = pour(n,m,d);

        return Math.min(ans1,ans2);
    }
    static int gcd(int m,int n){
        if (n == 0) return m;
        return gcd(n,m%n);
    }

    static int pour(int fromCap,int toCap,int d){
        int from = fromCap;
        int to = 0;
        int step = 1;

        while (from != d && to != d){
            int temp = Math.min(from,toCap);
            to += temp;
            from-=temp;
            step++;
            if(from == d || to == d) break;
            if(from == 0){
                from = fromCap;
                step++;
            }
            if(to == toCap){
                to = 0;
                step++;
            }
        }
        return step;
    }
}
