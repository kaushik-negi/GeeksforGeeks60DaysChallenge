package geeksforgeeks;
import java.util.*;
public class StableMarriageProblem {
    public static void main(String[] args) {

    }
    static int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        int[] womanPartner = new int[n];
        Arrays.fill(womanPartner,-1);
        int[] manPartner = new int[n];
        Arrays.fill(manPartner,-1);
        int[] nextProposal = new int[n];

        int[][] ranks = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ranks[i],-1);
        }

        for (int w = 0; w < n; w++) {
            for (int rank = 0; rank < n; rank++) {
                ranks[w][women[w][rank]] = rank;
            }
        }
        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.offer(i);
        }

        while (!freeMen.isEmpty()){
            int man = freeMen.poll();

            int woman = men[man][nextProposal[man]];
            nextProposal[man]++;

            if(womanPartner[woman] == -1){
                womanPartner[woman] = man;
                manPartner[man] = woman;
            }else{
                int currentMen = womanPartner[woman];

                if(ranks[woman][man] < ranks[woman][currentMen]){
                    womanPartner[woman] = man;
                    manPartner[man] = woman;

                    freeMen.offer(currentMen);
                    manPartner[currentMen] = -1;
                }else {
                    freeMen.offer(man);
                }
            }
        }
        return manPartner;
    }
}
