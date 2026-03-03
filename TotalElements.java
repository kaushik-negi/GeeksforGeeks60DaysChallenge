    package geeksforgeeks;

    import java.util.*;
    public class TotalElements {
        public static void main(String[] args) {
            System.out.println(totalElements(new int[]{3, 1, 2, 2, 2, 2}));
        }
        static int totalElements(int[] arr) {
            int maxLen = 0;
            int left = 0;
            int right = 0;
            Map<Integer,Integer> mp = new HashMap<>();

            while(right<arr.length){
                mp.put(arr[right] , mp.getOrDefault(arr[right],0)+1);

                if (mp.size()>2){
                    mp.put(arr[left],mp.get(arr[left])-1);
                    if(mp.get(arr[left]) == 0) mp.remove(arr[left]);
                    left = left+1;
                }
                maxLen = Math.max(maxLen,right-left+1);

                right += 1;
            }
            return maxLen;
        }
    }
