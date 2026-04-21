package geeksforgeeks;

public class FlipToMaximizeOnes {
    public static void main(String[] args) {

    }
    static int maxOnes(int[] arr) {
        int totalOnes = 0;

        for(int x : arr){
            if(x == 1) totalOnes++;
        }

        int maxGain = 0;

        int currentSum = 0;

        for (int x : arr){
            if(x == 0) currentSum +=1 ;
            else currentSum -= 1;

            if(currentSum < 0) currentSum = 0;
            if (currentSum > maxGain){
                maxGain = currentSum;
            }
        }
        return totalOnes + maxGain;
    }
}
