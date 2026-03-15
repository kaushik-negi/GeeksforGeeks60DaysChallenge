package geeksforgeeks;
import java.util.*;
public class VerticalTraversal {
    public static void main(String[] args) {

    }
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        Queue<pair> q = new LinkedList<>();
        Map<Integer,ArrayList<Integer>> mp = new TreeMap<>();

        q.offer(new pair(root,0));

        while (!q.isEmpty()){
            pair p = q.poll();
            Node node = p.node;
            int level = p.level;

            if(!mp.containsKey(level)){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(node.data);
                mp.put(level,arr);
            }else{
                mp.get(level).add(node.data);
            }

            if(node.left != null) {
                q.offer(new pair(node.left,level-1));
            }
            if(node.right != null){
                q.offer(new pair(node.right,level+1));
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> m : mp.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}
